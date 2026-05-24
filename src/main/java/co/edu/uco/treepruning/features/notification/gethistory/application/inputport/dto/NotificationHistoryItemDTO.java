package co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class NotificationHistoryItemDTO {

    private UUID          id;
    private String        title;
    private String        body;
    private String        referenceId;
    private String        type;
    private LocalDateTime sentAt;
    private boolean       success;

    public NotificationHistoryItemDTO(
            UUID id,
            String title,
            String body,
            String referenceId,
            String type,
            LocalDateTime sentAt,
            boolean success) {
        setId(id);
        setTitle(title);
        setBody(body);
        setReferenceId(referenceId);
        setType(type);
        setSentAt(sentAt);
        setSuccess(success);
    }

    public NotificationHistoryItemDTO() {
        this(UUIDHelper.getDefault(), "", "", "", "", LocalDateTime.now(), false);
    }

    public UUID          getId()          { return id;          }
    public String        getTitle()       { return title;       }
    public String        getBody()        { return body;        }
    public String        getReferenceId() { return referenceId; }
    public String        getType()        { return type;        }
    public LocalDateTime getSentAt()      { return sentAt;      }
    public boolean       isSuccess()      { return success;     }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }

    private void setTitle(final String title) {
        this.title = TextHelper.getDefault(title);
    }

    private void setBody(final String body) {
        this.body = TextHelper.getDefault(body);
    }

    private void setReferenceId(final String referenceId) {
        this.referenceId = TextHelper.getDefault(referenceId);
    }

    private void setType(final String type) {
        this.type = TextHelper.getDefault(type);
    }

    private void setSentAt(final LocalDateTime sentAt) {
        this.sentAt = ObjectHelper.getDefault(sentAt, LocalDateTime.now());
    }

    private void setSuccess(final boolean success) {
        this.success = success;
    }
}
