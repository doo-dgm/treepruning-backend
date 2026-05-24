package co.edu.uco.treepruning.features.notification.registertoken.application.usecase.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;


public class NotificationTokenDomain {

    private UUID          id;
    private UUID          userId;
    private String        fcmToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean       active;
    
    public NotificationTokenDomain() {
		this(UUIDHelper.getDefault(), UUIDHelper.getDefault(), "", LocalDateTime.now(), LocalDateTime.now(), true);
	}

    public NotificationTokenDomain(UUID id, UUID userId, String fcmToken,
            LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
        setId(id);
        setUserId(userId);
        setFcmToken(fcmToken);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        setActive(active);
    }
    
    public NotificationTokenDomain(UUID userId, String fcmToken) {
		this(UUIDHelper.getDefault(), userId, fcmToken, LocalDateTime.now(), LocalDateTime.now(), true);
	}


    public UUID          getId()        { return id;        }
    public UUID          getUserId()    { return userId;    }
    public String        getFcmToken()  { return fcmToken;  }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public boolean       isActive()     { return active;    }

    public void activate() {
        this.active    = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        this.active    = false;
        this.updatedAt = LocalDateTime.now();
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }

    private void setUserId(final UUID userId) {
        this.userId = UUIDHelper.getDefault(userId);
    }

    private void setFcmToken(final String fcmToken) {
        this.fcmToken = TextHelper.getDefaultWithTrim(fcmToken);
    }

    private void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = ObjectHelper.getDefault(createdAt, LocalDateTime.now());
    }

    private void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    private void setActive(final boolean active) {
        this.active = active;
    }
}
