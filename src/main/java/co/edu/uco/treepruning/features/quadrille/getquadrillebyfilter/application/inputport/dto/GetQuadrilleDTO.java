package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;

public final class GetQuadrilleDTO {
    private UUID id;
    private String quadrilleName;
    private GetManagerDTO manager;

    public GetQuadrilleDTO(UUID id, String quadrilleName, GetManagerDTO manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public GetQuadrilleDTO(UUID id) {
        this(id, TextHelper.getDefault(), new GetManagerDTO());
    }

    public GetQuadrilleDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getId() { return id; }
    public String getQuadrilleName() { return quadrilleName; }
    public GetManagerDTO getManager() { return manager; }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }
    private void setManager(final GetManagerDTO manager) {
        this.manager = ObjectHelper.getDefault(manager, new GetManagerDTO());
    }
}
