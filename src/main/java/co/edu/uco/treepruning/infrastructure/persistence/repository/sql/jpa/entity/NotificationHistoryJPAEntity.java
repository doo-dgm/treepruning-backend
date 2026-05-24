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
@Table(name = "notification_history")
public class NotificationHistoryJPAEntity {
	
	@Id
	@Column(name = "id")
	private UUID          id;
	
	@Column(name = "user_id")
    private UUID          userId;
	
	@Column(name = "title")
    private String        title;
	
	@Column(name = "body")
    private String        body;
	
	@Column(name = "pruning_id")
    private UUID          pruningId;
	
	@Column(name = "type")
    private String        type;
	
	@Column(name = "sent_at")
    private LocalDateTime sentAt;
	
	@Column(name = "success")
    private boolean       success;
	
	public NotificationHistoryJPAEntity() {}
	
	public NotificationHistoryJPAEntity(UUID id, UUID userId, String title, String body, UUID pruningId, String type,
			LocalDateTime sentAt, boolean success) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.pruningId = pruningId;
		this.type = type;
		this.sentAt = sentAt;
		this.success = success;
	}
	
	public UUID getId() {
		return id;
	}
	
	public UUID getUserId() {
		return userId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getBody() {
		return body;
	}
	
	public UUID getPruningId() {
		return pruningId;
	}
	
	public String getType() {
		return type;
	}
	
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	private void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}
	
	private void setUserId(final UUID userId) {
		this.userId = UUIDHelper.getDefault(userId);
	}
	
	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}
	
	private void setBody(final String body) {
		this.body = TextHelper.getDefaultWithTrim(body);
	}
	
	private void setPruningId(final UUID pruningId) {
		this.pruningId = UUIDHelper.getDefault(pruningId);
	}
	
	private void setType(final String type) {
		this.type = TextHelper.getDefaultWithTrim(type);
	}
	
	private void setSentAt(final LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	
	private void setSuccess(final boolean success) {
		this.success = success;
	}
	
	
	
}
