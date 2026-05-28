package co.edu.uco.treepruning.crosscutting.event;

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

import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.SendNotificationUseCase;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.domain.SendNotificationDomain;

/**
 * Escucha eventos de dominio y dispara notificaciones FCM al usuario autenticado.
 *
 * Los eventos de Spring son síncronos por defecto: corren en el mismo hilo
 * que el publicador, por lo que el SecurityContext sigue disponible aquí.
 *
 * El idioma ya NO se resuelve aquí: cada token FCM almacena su propio idioma
 * y SendNotificationUseCaseImpl resuelve el mensaje en el idioma de cada token.
 * Así un usuario con dispositivos en distintos idiomas recibe en el correcto.
 */
@Component
public class NotificationEventListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationEventListener.class);

    // Prefijos de código Strapi (sin sufijo de idioma).
    // El use case añade ".es" o ".en" según el idioma de cada token FCM.
    private static final String CODE_TITLE_PREFIX = "notifications.pruning-scheduled.title";
    private static final String CODE_BODY_PREFIX  = "notifications.pruning-scheduled.body";

    private final SendNotificationUseCase sendNotificationUseCase;

    public NotificationEventListener(SendNotificationUseCase sendNotificationUseCase) {
        this.sendNotificationUseCase = sendNotificationUseCase;
    }

    // AFTER_COMMIT: la poda ya está committed cuando esto corre,
    // así que pruningRepository.findById() la encontrará en T2 (REQUIRES_NEW).
    // Sigue en el mismo hilo de la request → SecurityContext disponible.
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onPruningScheduled(PruningScheduledEvent event) {
        UUID userId = resolveCurrentUserId();
        if (userId == null) {
            log.warn("[NOTIFICATION] No se pudo resolver el userId del contexto de seguridad; notificacion omitida.");
            return;
        }

        log.info("[NOTIFICATION] Enviando notificacion a userId={} | pruningId={}", userId, event.getPruningId());

        try {
            sendNotificationUseCase.execute(
                    new SendNotificationDomain(
                            userId,
                            event.getPruningId(),
                            CODE_TITLE_PREFIX,
                            CODE_BODY_PREFIX,
                            Map.of("date", event.getPlannedDate().toString())
                    )
            );
        } catch (Exception ex) {
            // No propagamos el error: la poda ya fue creada, la notificacion
            // es best-effort y no debe hacer rollback de la transaccion.
            log.error("[NOTIFICATION] Error al enviar notificacion FCM: {}", ex.getMessage(), ex);
        }
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
