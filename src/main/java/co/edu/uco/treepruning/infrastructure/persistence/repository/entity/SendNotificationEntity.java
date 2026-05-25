package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class SendNotificationEntity {
	private UUID   userId;
    private UUID   pruningId;
    private String title;
    private String body;
    
    public SendNotificationEntity(UUID userId, UUID pruningId, String title, String body) {
		setUserId(userId);
		setPruningId(pruningId);
		setTitle(title);
		setBody(body);
	}
    
	public UUID getUserId() {
		return userId;
	}
    	
	public UUID getPruningId() {
		return pruningId;
	}
    		
	public String getTitle() {
		return title;
	}
    			
	public String getBody() {
		return body;
	}
    		
	private void setUserId(final UUID userId) {
		this.userId = UUIDHelper.getDefault(userId);
	}
    	
	private void setPruningId(final UUID pruningId) {
		this.pruningId = UUIDHelper.getDefault(pruningId);
	}
    		
	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}
				
	private void setBody(final String body) {
		this.body = TextHelper.getDefaultWithTrim(body);
	}
}
