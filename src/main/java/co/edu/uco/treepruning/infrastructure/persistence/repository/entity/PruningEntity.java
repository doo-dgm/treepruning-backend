package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class PruningEntity {
    private UUID id;
    private StatusEntity status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private TreeEntity tree;
    private QuadrilleEntity quadrille;
    private TypeEntity type;
    private PQREntity pqr;
    private String photographicRecordPath;
    private String observations;

    public PruningEntity() {
        super();
        setId(UUIDHelper.getDefault());
        setStatus(new StatusEntity());
        setPlannedDate(DateHelper.getDefault());
        setExecutedDate(DateHelper.getDefault());
        setTree(new TreeEntity());
        setQuadrille(new QuadrilleEntity());
        setType(new TypeEntity());
        setPqr(new PQREntity());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public StatusEntity getStatus() {
        return status;
    }
    public LocalDate getPlannedDate() {
        return plannedDate;
    }
    public LocalDate getExecutedDate() {
        return executedDate;
    }
    public TreeEntity getTree() {
        return tree;
    }
    public QuadrilleEntity getQuadrille() {
        return quadrille;
    }
    public TypeEntity getType() {
        return type;
    }
    public PQREntity getPqr() {
        return pqr;
    }
    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }
    public String getObservations() {
        return observations;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setStatus(final StatusEntity status) {
        this.status = ObjectHelper.getDefault(status, new StatusEntity());
    }
    public void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    public void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDefault(executedDate);
    }
    public void setTree(final TreeEntity tree) {
        this.tree = ObjectHelper.getDefault(tree, new TreeEntity());
    }
    public void setQuadrille(final QuadrilleEntity quadrille) {
        this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleEntity());
    }
    public void setType(final TypeEntity type) {
        this.type = ObjectHelper.getDefault(type, new TypeEntity());
    }
    public void setPqr(final PQREntity pqr) {
        this.pqr = ObjectHelper.getDefault(pqr, new PQREntity());
    }
    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    public void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}
