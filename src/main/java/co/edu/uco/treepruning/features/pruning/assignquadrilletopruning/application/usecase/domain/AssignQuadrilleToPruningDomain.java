package co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class AssignQuadrilleToPruningDomain {

    private UUID id;
    private UUID quadrille;

    @JsonCreator
    public AssignQuadrilleToPruningDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("quadrille") UUID quadrille) {
        setId(id);
        setQuadrille(quadrille);
    }

    public AssignQuadrilleToPruningDomain() {
        setId(UUIDHelper.getDefault());
        setQuadrille(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getQuadrille() {
        return quadrille;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setQuadrille(final UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
}
