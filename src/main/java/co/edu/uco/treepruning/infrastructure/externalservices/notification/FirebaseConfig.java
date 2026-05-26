package co.edu.uco.treepruning.infrastructure.externalservices.notification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Initialises Firebase / FCM.
 *
 * Credentials are resolved in this order:
 *   1. FIREBASE_CREDENTIALS_JSON env-var  → inline JSON string (preferred for Docker / CI)
 *   2. FIREBASE_CREDENTIALS_PATH env-var  → path to a service-account JSON file (local dev)
 *
 * If neither is set the bean is skipped and FCM is silently disabled.
 */
@Configuration
public class FirebaseConfig {

    private static final Logger log = LoggerFactory.getLogger(FirebaseConfig.class);

    /** Full JSON of the service-account key (set via env var FIREBASE_CREDENTIALS_JSON). */
    @Value("${firebase.credentials-json:}")
    private String credentialsJson;

    /** Path to a service-account JSON file (set via env var FIREBASE_CREDENTIALS_PATH). */
    @Value("${firebase.credentials-path:}")
    private String credentialsPath;

    @Bean
    public FirebaseMessaging firebaseMessaging() throws IOException {
        InputStream credentialsStream = resolveCredentials();
        if (credentialsStream == null) {
            log.warn("FirebaseConfig — no credentials configured " +
                     "(set FIREBASE_CREDENTIALS_JSON or FIREBASE_CREDENTIALS_PATH). FCM disabled.");
            return null;
        }

        GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        log.info("FirebaseConfig — FirebaseMessaging initialised.");
        return FirebaseMessaging.getInstance();
    }

    private InputStream resolveCredentials() throws IOException {
        if (credentialsJson != null && !credentialsJson.isBlank()) {
            log.info("FirebaseConfig — loading credentials from FIREBASE_CREDENTIALS_JSON");
            return new ByteArrayInputStream(credentialsJson.getBytes(StandardCharsets.UTF_8));
        }
        if (credentialsPath != null && !credentialsPath.isBlank()) {
            log.info("FirebaseConfig — loading credentials from file: {}", credentialsPath);
            return new FileInputStream(credentialsPath);
        }
        return null;
    }
}
