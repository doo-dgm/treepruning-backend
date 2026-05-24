package co.edu.uco.treepruning.features.notification.registertoken.application.inputport.dto;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class RegisterTokenDTO {
	private UUID   userId;
    private String fcmToken;

    public RegisterTokenDTO(UUID userId, String fcmToken) {
        setUserId(userId);
        setFcmToken(fcmToken);
    }

    public RegisterTokenDTO(UUID userId) {
        this(userId, "");
    }

    public RegisterTokenDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID   getUserId()  { return userId;   }
    public String getFcmToken() { return fcmToken; }

    private void setUserId(final UUID userId) {
        this.userId = UUIDHelper.getDefault(userId);
    }

    private void setFcmToken(final String fcmToken) {
        this.fcmToken = ObjectHelper.getDefault(fcmToken, "");
    }
}
