package co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class AssignPQRRiskDomain {

    private UUID id;
    private UUID risk;

    @JsonCreator
    public AssignPQRRiskDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("risk") UUID risk) {
        setId(id);
        setRisk(risk);
    }

    public AssignPQRRiskDomain() {
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
