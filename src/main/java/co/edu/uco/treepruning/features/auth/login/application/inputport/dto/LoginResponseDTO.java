package co.edu.uco.treepruning.features.auth.login.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;

public final class LoginResponseDTO {
    private String accessToken;
    private String refreshToken;
    private int    expiresIn;

    public LoginResponseDTO(String accessToken, String refreshToken, int expiresIn) {
        setAccessToken(accessToken);
        setRefreshToken(refreshToken);
        setExpiresIn(expiresIn);
    }

    public LoginResponseDTO() {
        this("", "", 0);
    }

    public String getAccessToken()  { return accessToken;  }
    public String getRefreshToken() { return refreshToken; }
    public int    getExpiresIn()    { return expiresIn;    }

    private void setAccessToken(final String accessToken) {
        this.accessToken = TextHelper.getDefaultWithTrim(accessToken);
    }
    private void setRefreshToken(final String refreshToken) {
        this.refreshToken = TextHelper.getDefaultWithTrim(refreshToken);
    }
    private void setExpiresIn(final int expiresIn) {
        this.expiresIn = expiresIn;
    }
}