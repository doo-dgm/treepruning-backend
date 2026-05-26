package co.edu.uco.treepruning.features.auth.login.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;

public final class LoginRequestDTO {
    private String username;
    private String password;
    private String recaptchaToken;

    public LoginRequestDTO(String username, String password, String recaptchaToken) {
        setUsername(username);
        setPassword(password);
        setRecaptchaToken(recaptchaToken);
    }

    public LoginRequestDTO() {
        this("", "", "");
    }

    public String getUsername()       { return username;       }
    public String getPassword()       { return password;       }
    public String getRecaptchaToken() { return recaptchaToken; }

    private void setUsername(final String username) {
        this.username = TextHelper.getDefaultWithTrim(username);
    }
    private void setPassword(final String password) {
        this.password = TextHelper.getDefaultWithTrim(password);
    }
    private void setRecaptchaToken(final String recaptchaToken) {
        this.recaptchaToken = TextHelper.getDefaultWithTrim(recaptchaToken);
    }
}