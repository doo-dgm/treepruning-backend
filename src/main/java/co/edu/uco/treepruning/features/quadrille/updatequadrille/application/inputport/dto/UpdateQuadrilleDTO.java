package co.edu.uco.treepruning.features.quadrille.updatequadrille.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class UpdateQuadrilleDTO {

    private UUID id;
    private String quadrilleName;
    private UUID manager;

    public UpdateQuadrilleDTO(UUID id, String quadrilleName, UUID manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UpdateQuadrilleDTO() {
        setId(UUIDHelper.getDefault());
        setQuadrilleName(TextHelper.getDefault());
        setManager(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getQuadrilleName() {
        return quadrilleName;
    }
    public UUID getManager() {
        return manager;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }
    private void setManager(final UUID manager) {
        this.manager = UUIDHelper.getDefault(manager);
    }
}
