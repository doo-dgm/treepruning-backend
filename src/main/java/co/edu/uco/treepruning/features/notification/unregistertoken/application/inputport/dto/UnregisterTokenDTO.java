package co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;

public class UnregisterTokenDTO {
	private String fcmToken;

    public UnregisterTokenDTO(String fcmToken) {
        setFcmToken(fcmToken);
    }

    public String getFcmToken() { return fcmToken; }

    private void setFcmToken(final String fcmToken) {
        this.fcmToken = ObjectHelper.getDefault(fcmToken, "");
    }
}
