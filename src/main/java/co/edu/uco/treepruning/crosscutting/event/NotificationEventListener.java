package co.edu.uco.treepruning.crosscutting.event;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.SendNotificationUseCase;
import co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.domain.SendNotificationDomain;

/**
 * Escucha eventos de dominio y dispara notificaciones FCM al usuario autenticado.
 *
 * Los eventos de Spring son síncronos por defecto: corren en el mismo hilo
 * que el publicador, por lo que el SecurityContext sigue disponible aquí.
 */
@Component
public class NotificationEventListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationEventListener.class);

    private final SendNotificationUseCase sendNotificationUseCase;

    public NotificationEventListener(SendNotificationUseCase sendNotificationUseCase) {
        this.sendNotificationUseCase = sendNotificationUseCase;
    }

    @EventListener
    public void onPruningScheduled(PruningScheduledEvent event) {
        UUID userId = resolveCurrentUserId();
        if (userId == null) {
            log.warn("[NOTIFICATION] No se pudo resolver el userId del contexto de seguridad; notificación omitida.");
            return;
        }

        String title = "Poda preventiva programada";
        String body  = String.format(
                "Se programó una poda preventiva para el %s.",
                event.getPlannedDate().toString()
        );

        log.info("[NOTIFICATION] Enviando notificación a userId={} | pruningId={}", userId, event.getPruningId());

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
