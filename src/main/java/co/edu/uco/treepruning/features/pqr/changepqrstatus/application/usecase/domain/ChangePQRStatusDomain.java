package co.edu.uco.treepruning.features.pqr.changepqrstatus.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class ChangePQRStatusDomain {

    private UUID id;
    private UUID status;

    @JsonCreator
    public ChangePQRStatusDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("status") UUID status) {
        setId(id);
        setStatus(status);
    }

    public ChangePQRStatusDomain() {
        setId(UUIDHelper.getDefault());
        setStatus(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getStatus() {
        return status;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setStatus(final UUID status) {
        this.status = UUIDHelper.getDefault(status);
    }
}
