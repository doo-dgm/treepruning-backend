package co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class GetAdministratorDomain {

    private UUID id;
    private String username;
    private String email;
    private boolean emailConfirmed;
    private String phone;
    private boolean phoneConfirmed;

    @JsonCreator
    public GetAdministratorDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("username") String username,
            @JsonProperty("email") String email,
            @JsonProperty("emailConfirmed") boolean emailConfirmed,
            @JsonProperty("phone") String phone,
            @JsonProperty("phoneConfirmed") boolean phoneConfirmed) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setPhone(phone);
        setPhoneConfirmed(phoneConfirmed);
    }

    public GetAdministratorDomain() {
        setId(UUIDHelper.getDefault());
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmed(false);
        setPhone(TextHelper.getDefault());
        setPhoneConfirmed(false);
    }

    public UUID getId() {
        return id;
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

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
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
