package co.edu.uco.treepruning.features.notification.sendnotification.application.inputport.dto;

import java.util.Map;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class SendNotificationDTO {

    private UUID                userId;
    private UUID                pruningId;
    private String              titleCode;
    private String              bodyCode;
    private Map<String, Object> vars;

    public SendNotificationDTO(UUID userId, UUID pruningId,
                               String titleCode, String bodyCode,
                               Map<String, Object> vars) {
        setUserId(userId);
        setPruningId(pruningId);
        setTitleCode(titleCode);
        setBodyCode(bodyCode);
        this.vars = vars != null ? vars : Map.of();
    }

    public UUID                getUserId()    { return userId;     }
    public UUID                getPruningId() { return pruningId;  }
    public String              getTitleCode() { return titleCode;  }
    public String              getBodyCode()  { return bodyCode;   }
    public Map<String, Object> getVars()      { return vars;       }

    private void setUserId(final UUID userId) {
        this.userId = UUIDHelper.getDefault(userId);
    }

    private void setPruningId(final UUID pruningId) {
        this.pruningId = UUIDHelper.getDefault(pruningId);
    }

    private void setTitleCode(final String titleCode) {
        this.titleCode = TextHelper.getDefault(titleCode);
    }

    private void setBodyCode(final String bodyCode) {
        this.bodyCode = TextHelper.getDefault(bodyCode);
    }
}
