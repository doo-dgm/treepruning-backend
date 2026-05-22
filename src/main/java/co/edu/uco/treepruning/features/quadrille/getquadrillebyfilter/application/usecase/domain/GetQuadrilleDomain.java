package co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain.GetManagerDomain;

public final class GetQuadrilleDomain {
    private UUID id;
    private String quadrilleName;
    private GetManagerDomain manager;

    public GetQuadrilleDomain(UUID id, String quadrilleName, GetManagerDomain manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UUID getId() { return id; }
    public String getQuadrilleName() { return quadrilleName; }
    public GetManagerDomain getManager() { return manager; }

    private void setId(final UUID id) { this.id = UUIDHelper.getDefault(id); }
    private void setQuadrilleName(final String quadrilleName) { this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName); }
    private void setManager(final GetManagerDomain manager) { this.manager = manager; }
}
