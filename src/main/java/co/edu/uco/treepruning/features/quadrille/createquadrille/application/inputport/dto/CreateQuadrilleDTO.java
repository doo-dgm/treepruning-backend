package co.edu.uco.treepruning.features.quadrille.createquadrille.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class CreateQuadrilleDTO {

    private String quadrilleName;
    private UUID manager;

    public CreateQuadrilleDTO(String quadrilleName, UUID manager) {
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public CreateQuadrilleDTO() {
        setQuadrilleName(TextHelper.getDefault());
        setManager(UUIDHelper.getDefault());
    }

    public String getQuadrilleName() {
        return quadrilleName;
    }
    public UUID getManager() {
        return manager;
    }

    private void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }
    private void setManager(final UUID manager) {
        this.manager = UUIDHelper.getDefault(manager);
    }
}
