package co.edu.uco.treepruning.features.pqr.changepqrstatus.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class ChangePQRStatusDTO {

    private UUID id;
    private UUID status;

    public ChangePQRStatusDTO(UUID id, UUID status) {
        setId(id);
        setStatus(status);
    }

    public ChangePQRStatusDTO() {
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
