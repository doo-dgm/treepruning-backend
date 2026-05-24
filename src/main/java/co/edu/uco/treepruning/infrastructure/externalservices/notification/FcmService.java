package co.edu.uco.treepruning.infrastructure.externalservices.notification;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FcmService {

    private final FirebaseMessaging firebaseMessaging;
    private static final Logger log = LoggerFactory.getLogger(FcmService.class);

    public FcmService(@Autowired(required = false) FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
        if (firebaseMessaging == null) {
            log.warn("[FCM] Firebase no configurado (firebase.credentials-path no definido). Las notificaciones push estaran deshabilitadas.");
        }
    }

    public boolean send(String fcmToken, String title, String body) {
        if (firebaseMessaging == null) {
            log.debug("[FCM] Notificacion ignorada (Firebase no configurado): {}", title);
            return false;
        }
        try {
            Message message = Message.builder()
                .setToken(fcmToken)
                .setNotification(
                    Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build()
                )
                .build();

            firebaseMessaging.send(message);
            return true;
        } catch (FirebaseMessagingException e) {
            log.warn("[FCM] Error enviando notificacion: {}", e.getMessage());
            return false;
        }
    }
}
