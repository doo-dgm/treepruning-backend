package co.edu.uco.treepruning.features.auth.login.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;

public final class LoginDomain {
    private String username;
    private String password;
    private String recaptchaToken;

    public LoginDomain(String username, String password, String recaptchaToken) {
        setUsername(username);
        setPassword(password);
        setRecaptchaToken(recaptchaToken);
    }

    public LoginDomain() {
        this("", "", "");
    }

    public String getUsername()       { return username;       }
    public String getPassword()       { return password;       }
    public String getRecaptchaToken() { return recaptchaToken; }

    private void setUsername(final String username) {
        this.username = TextHelper.getDefaultWithTrim(username);
    }
    private void setPassword(final String password) {
        this.password = TextHelper.getDefault(password);
    }
    private void setRecaptchaToken(final String recaptchaToken) {
        this.recaptchaToken = TextHelper.getDefaultWithTrim(recaptchaToken);
    }
}