package co.edu.uco.treepruning.features.notification.registertoken.application.inputport.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class RegisterTokenDTO {
	private UUID   userId;
    private String fcmToken;
    private String language;

    public RegisterTokenDTO(UUID userId, String fcmToken, String language) {
        setUserId(userId);
        setFcmToken(fcmToken);
        setLanguage(language);
    }

    public UUID   getUserId()   { return userId;    }
    public String getFcmToken() { return fcmToken;  }
    public String getLanguage() { return language;  }

    private void setUserId(final UUID userId) {
        this.userId = UUIDHelper.getDefault(userId);
    }

    private void setFcmToken(final String fcmToken) {
        this.fcmToken = ObjectHelper.getDefault(fcmToken, "");
    }

    private void setLanguage(final String language) {
        this.language = ObjectHelper.getDefault(language, "es");
    }
}
