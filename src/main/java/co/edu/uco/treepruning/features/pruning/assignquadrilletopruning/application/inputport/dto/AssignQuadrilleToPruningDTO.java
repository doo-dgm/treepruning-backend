package co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class AssignQuadrilleToPruningDTO {

    private UUID id;
    private UUID quadrille;

    public AssignQuadrilleToPruningDTO(UUID id, UUID quadrille) {
        setId(id);
        setQuadrille(quadrille);
    }

    public AssignQuadrilleToPruningDTO() {
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
