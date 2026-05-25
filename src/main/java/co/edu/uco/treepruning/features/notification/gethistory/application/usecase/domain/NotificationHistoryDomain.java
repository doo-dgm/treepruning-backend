package co.edu.uco.treepruning.features.notification.gethistory.application.usecase.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class NotificationHistoryDomain {

    private UUID          id;
    private UUID          userId;
    private String        title;
    private String        body;
    private UUID          pruningId;
    private UUID        type;
    private LocalDateTime sentAt;
    private boolean       success;

    public NotificationHistoryDomain(UUID userId, String title,
            String body, UUID pruningId, UUID type,
            LocalDateTime sentAt) {
        setUserId(userId);
        setTitle(title);
        setBody(body);
        setPruningId(pruningId);
        setType(type);
        setSentAt(sentAt);
    }

    public UUID          getId()        { return id;        }
    public UUID          getUserId()    { return userId;    }
    public String        getTitle()     { return title;     }
    public String        getBody()      { return body;      }
    public UUID          getPruningId() { return pruningId; }
    public UUID        getType()      { return type;      }
    public LocalDateTime getSentAt()    { return sentAt;    }
    public boolean       isSuccess()    { return success;   }

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

    private void setType(final UUID type) {
        this.type = UUIDHelper.getDefault(type);
    }

    private void setSentAt(final LocalDateTime sentAt) {
        this.sentAt = ObjectHelper.getDefault(sentAt, LocalDateTime.now());
    }

    private void setSuccess(final boolean success) {
        this.success = success;
    }
}