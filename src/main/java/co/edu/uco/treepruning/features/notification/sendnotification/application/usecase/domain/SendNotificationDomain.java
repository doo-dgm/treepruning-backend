package co.edu.uco.treepruning.features.notification.sendnotification.application.usecase.domain;

import java.util.Map;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class SendNotificationDomain {

    private UUID                userId;
    private UUID                pruningId;
    // Prefijos de codigo Strapi sin el sufijo de idioma.
    // Ej: "notifications.pruning-scheduled.title" →
    //     "notifications.pruning-scheduled.title.es" o ".en" segun el token.
    private String              titleCode;
    private String              bodyCode;
    // Variables de interpolacion para el cuerpo (ej: date).
    private Map<String, Object> vars;

    public SendNotificationDomain(UUID userId, UUID pruningId,
                                  String titleCode, String bodyCode,
                                  Map<String, Object> vars) {
        setUserId(userId);
        setPruningId(pruningId);
        setTitleCode(titleCode);
        setBodyCode(bodyCode);
        this.vars = vars != null ? vars : Map.of();
    }

    public SendNotificationDomain() {
        this(UUIDHelper.getDefault(), UUIDHelper.getDefault(), "", "", Map.of());
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
        this.titleCode = TextHelper.getDefaultWithTrim(titleCode);
    }

    private void setBodyCode(final String bodyCode) {
        this.bodyCode = TextHelper.getDefaultWithTrim(bodyCode);
    }
}