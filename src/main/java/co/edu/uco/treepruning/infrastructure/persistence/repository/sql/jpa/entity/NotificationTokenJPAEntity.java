package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification_tokens")
public class NotificationTokenJPAEntity {
	
	@Id
	@Column(name = "id")
	private UUID          id;
	
	@Column(name = "user_id")
    private UUID          userId;
	
	@Column(name = "fcm_token")
    private String        fcmToken;

	@Column(name = "language", length = 5)
    private String        language;

	@Column(name = "created_at")
    private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
    private LocalDateTime updatedAt;
	
	@Column(name = "active")
    private boolean       active;
	
	public NotificationTokenJPAEntity() {}

	public NotificationTokenJPAEntity(UUID id, UUID userId, String fcmToken, String language,
			LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
		this.id = id;
		this.userId = userId;
		this.fcmToken = fcmToken;
		this.language = language;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.active = active;
	}

	public UUID getId() {
		return id;
	}

	public UUID getUserId() {
		return userId;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public String getLanguage() {
		return language;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public boolean isActive() {
		return active;
	}

	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}

	private void setUserId(final UUID userId) {
		this.userId = UUIDHelper.getDefault(userId);
	}

	private void setFcmToken(final String fcmToken) {
		this.fcmToken = TextHelper.getDefault(fcmToken);
	}

	private void setLanguage(final String language) {
		this.language = TextHelper.getDefault(language);
	}

	private void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	private void setUpdatedAt(final LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	private void setActive(final boolean active) {
		this.active = active;
	}
	
    
}
