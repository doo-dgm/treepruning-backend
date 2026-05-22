package co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.usecase.domain;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.usecase.domain.GetQuadrilleDomain;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain.GetStatusDomain;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.usecase.domain.GetTreeDomain;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.usecase.domain.GetTypeDomain;

public final class GetPruningDomain {
    private UUID id;
    private GetStatusDomain status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private GetTreeDomain tree;
    private GetQuadrilleDomain quadrille;
    private GetTypeDomain type;
    private UUID pqr;
    private String photographicRecordPath;
    private String observations;

    public GetPruningDomain(UUID id, GetStatusDomain status,
            LocalDate plannedDate, LocalDate executedDate,
            GetTreeDomain tree, GetQuadrilleDomain quadrille, GetTypeDomain type,
            UUID pqr, String photographicRecordPath, String observations) {
        setId(id);
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPqr(pqr);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
    }

    public UUID getId() { return id; }
    public GetStatusDomain getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public GetTreeDomain getTree() { return tree; }
    public GetQuadrilleDomain getQuadrille() { return quadrille; }
    public GetTypeDomain getType() { return type; }
    public UUID getPqr() { return pqr; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }

    private void setId(final UUID id) { this.id = UUIDHelper.getDefault(id); }
    private void setStatus(final GetStatusDomain status) { this.status = status; }
    private void setPlannedDate(final LocalDate plannedDate) { this.plannedDate = DateHelper.getDefault(plannedDate); }
    private void setExecutedDate(final LocalDate executedDate) { this.executedDate = DateHelper.getDefault(executedDate); }
    private void setTree(final GetTreeDomain tree) { this.tree = tree; }
    private void setQuadrille(final GetQuadrilleDomain quadrille) { this.quadrille = quadrille; }
    private void setType(final GetTypeDomain type) { this.type = type; }
    private void setPqr(final UUID pqr) { this.pqr = UUIDHelper.getDefault(pqr); }
    private void setPhotographicRecordPath(final String photographicRecordPath) { this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath); }
    private void setObservations(final String observations) { this.observations = TextHelper.getDefaultWithTrim(observations); }
}
