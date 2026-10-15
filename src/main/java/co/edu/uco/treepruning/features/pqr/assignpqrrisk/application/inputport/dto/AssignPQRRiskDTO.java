package co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class AssignPQRRiskDTO {

    private UUID id;
    private UUID risk;

    public AssignPQRRiskDTO(UUID id, UUID risk) {
        setId(id);
        setRisk(risk);
    }

    public AssignPQRRiskDTO() {
        setId(UUIDHelper.getDefault());
        setRisk(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getRisk() {
        return risk;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setRisk(final UUID risk) {
        this.risk = UUIDHelper.getDefault(risk);
    }
}
