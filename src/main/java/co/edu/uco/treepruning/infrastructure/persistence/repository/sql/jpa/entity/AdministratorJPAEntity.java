package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrator")
public class AdministratorJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "username", length = 60)
    private String username;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "email_confirmed")
    private boolean emailConfirmed;

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "phone_confirmed")
    private boolean phoneConfirmed;

    public AdministratorJPAEntity() {}

    public AdministratorJPAEntity(UUID id, String username, String email,
            boolean emailConfirmed, String phone, boolean phoneConfirmed) {
        setId(id);
        setUsername(username);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setPhone(phone);
        setPhoneConfirmed(phoneConfirmed);
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

    public void setId(UUID id) {
        this.id = id;
        }
    public void setUsername(String username) {
        this.username = username;
        }
    public void setEmail(String email) {
        this.email = email;
        }
    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
        }
    public void setPhone(String phone) {
        this.phone = phone;
        }
    public void setPhoneConfirmed(boolean phoneConfirmed) {
        this.phoneConfirmed = phoneConfirmed;
        }
}
