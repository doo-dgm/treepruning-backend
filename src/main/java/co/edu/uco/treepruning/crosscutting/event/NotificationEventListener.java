package co.edu.uco.treepruning.crosscutting.event;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain.NotificationTokenDomain;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.SendNotificationUseCase;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.domain.SendNotificationDomain;
import co.edu.uco.treepruning.infrastructure.persistence.repository.NotificationTokenRepository;

/**
 * Escucha eventos de dominio y dispara notificaciones FCM al usuario autenticado.
 *
 * Los eventos de Spring son síncronos por defecto: corren en el mismo hilo
 * que el publicador, por lo que el SecurityContext sigue disponible aquí.
 */
@Component
public class NotificationEventListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationEventListener.class);

    // Códigos Strapi: notifications.pruning-scheduled.title.{es|en}
    //                 notifications.pruning-scheduled.body.{es|en}
    private static final String CODE_TITLE_PREFIX = "notifications.pruning-scheduled.title.";
    private static final String CODE_BODY_PREFIX  = "notifications.pruning-scheduled.body.";
    private static final String DEFAULT_LANG      = "es";

    private final SendNotificationUseCase    sendNotificationUseCase;
    private final NotificationTokenRepository tokenRepository;
    private final MessageCatalogService       messageCatalogService;

    public NotificationEventListener(
            SendNotificationUseCase sendNotificationUseCase,
            NotificationTokenRepository tokenRepository,
            MessageCatalogService messageCatalogService) {
        this.sendNotificationUseCase = sendNotificationUseCase;
        this.tokenRepository         = tokenRepository;
        this.messageCatalogService   = messageCatalogService;
    }

    // AFTER_COMMIT: la poda ya está committed cuando esto corre,
    // así que pruningRepository.findById() la encontrará en T2 (REQUIRES_NEW).
    // Sigue en el mismo hilo de la request → SecurityContext disponible.
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onPruningScheduled(PruningScheduledEvent event) {
        UUID userId = resolveCurrentUserId();
        if (userId == null) {
            log.warn("[NOTIFICATION] No se pudo resolver el userId del contexto de seguridad; notificación omitida.");
            return;
        }

        String lang  = resolveUserLanguage(userId);
        String title = messageCatalogService.resolve(CODE_TITLE_PREFIX + lang);
        String body  = messageCatalogService.resolve(
                CODE_BODY_PREFIX + lang,
                Map.of("date", event.getPlannedDate().toString())
        );

        log.info("[NOTIFICATION] Enviando notificación a userId={} | lang={} | pruningId={}", userId, lang, event.getPruningId());

        try {
            sendNotificationUseCase.execute(
                    new SendNotificationDomain(userId, event.getPruningId(), title, body)
            );
        } catch (Exception ex) {
            // No propagamos el error: la poda ya fue creada, la notificación
            // es best-effort y no debe hacer rollback de la transacción.
            log.error("[NOTIFICATION] Error al enviar notificación FCM: {}", ex.getMessage(), ex);
        }
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    /**
     * Obtiene el idioma preferido del usuario a partir de su primer token FCM activo.
     * Si no hay tokens o el idioma está en blanco, devuelve el idioma por defecto.
     */
    private String resolveUserLanguage(UUID userId) {
        try {
            List<NotificationTokenDomain> tokens = tokenRepository.findAllActiveByUserId(userId);
            if (tokens != null && !tokens.isEmpty()) {
                String lang = tokens.get(0).getLanguage();
                if (lang != null && !lang.isBlank()) {
                    return lang;
                }
            }
        } catch (Exception ex) {
            log.warn("[NOTIFICATION] No se pudo obtener el idioma del usuario {}: {}", userId, ex.getMessage());
        }
        return DEFAULT_LANG;
    }

    private UUID resolveCurrentUserId() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated()) return null;

            Object principal = auth.getPrincipal();
            if (principal instanceof Jwt jwt) {
                return UUID.fromString(jwt.getSubject());
            }
            return null;
        } catch (Exception ex) {
            log.warn("[NOTIFICATION] No se pudo extraer userId del JWT: {}", ex.getMessage());
            return null;
        }
    }
}
