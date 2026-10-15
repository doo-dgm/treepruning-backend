package co.edu.uco.treepruning.features.administrator.createadministrator.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;

public final class CreateAdministratorDTO {

    private String username;
    private String email;
    private boolean emailConfirmed;
    private String phone;
    private boolean phoneConfirmed;

    public CreateAdministratorDTO(String username, String email, boolean emailConfirmed, String phone, boolean phoneConfirmed) {
        setUsername(username);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setPhone(phone);
        setPhoneConfirmed(phoneConfirmed);
    }

    public CreateAdministratorDTO() {
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhone(TextHelper.getDefault());
        setPhoneConfirmed(false);
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }
    public String getPhone() {
        return phone;
    }
    public boolean isPhoneConfirmed() {
        return phoneConfirmed;
    }

    private void setUsername(final String username) {
        this.username = TextHelper.getDefaultWithTrim(username);
    }
    private void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }
    private void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }
    private void setPhone(final String phone) {
        this.phone = TextHelper.getDefaultWithTrim(phone);
    }
    private void setPhoneConfirmed(final boolean phoneConfirmed) {
        this.phoneConfirmed = phoneConfirmed;
    }
}
