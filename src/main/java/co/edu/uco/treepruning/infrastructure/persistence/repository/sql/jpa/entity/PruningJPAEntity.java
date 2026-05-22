package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pruning")
public class PruningJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private StatusJPAEntity status;

    @Column(name = "planned_date")
    private LocalDate plannedDate;

    @Column(name = "executed_date")
    private LocalDate executedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tree_id")
    private TreeJPAEntity tree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quadrille_id")
    private QuadrilleJPAEntity quadrille;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private TypeJPAEntity type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pqr_id")
    private PQRJPAEntity pqr;

    @Column(name = "photographic_report_path")
    private String photographicRecordPath;

    @Column(name = "observations")
    private String observations;

    public PruningJPAEntity() {}

    private PruningJPAEntity(Builder builder) {
        setId(builder.id);
        setStatus(builder.status);
        setPlannedDate(builder.plannedDate);
        setExecutedDate(builder.executedDate);
        setTree(builder.tree);
        setQuadrille(builder.quadrille);
        setType(builder.type);
        setPqr(builder.pqr);
        setPhotographicRecordPath(builder.photographicRecordPath);
        setObservations(builder.observations);
    }

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() { return id; }
    public StatusJPAEntity getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public TreeJPAEntity getTree() { return tree; }
    public QuadrilleJPAEntity getQuadrille() { return quadrille; }
    public TypeJPAEntity getType() { return type; }
    public PQRJPAEntity getPqr() { return pqr; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setStatus(final StatusJPAEntity status) {
        this.status = status;
    }
    public void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    public void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDefault(executedDate);
    }
    public void setTree(final TreeJPAEntity tree) {
        this.tree = tree;
    }
    public void setQuadrille(final QuadrilleJPAEntity quadrille) {
        this.quadrille = quadrille;
    }
    public void setType(final TypeJPAEntity type) {
        this.type = type;
    }
    public void setPqr(final PQRJPAEntity pqr) {
        this.pqr = pqr;
    }
    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefault(photographicRecordPath);
    }
    public void setObservations(final String observations) {
        this.observations = TextHelper.getDefault(observations);
    }

    // ── GoF Builder ───────────────────────────────────────────────────────────
    public static final class Builder {
        private UUID id;
        private StatusJPAEntity status;
        private LocalDate plannedDate;
        private LocalDate executedDate;
        private TreeJPAEntity tree;
        private QuadrilleJPAEntity quadrille;
        private TypeJPAEntity type;
        private PQRJPAEntity pqr;
        private String photographicRecordPath;
        private String observations;

        private Builder() {}

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder status(StatusJPAEntity status) { this.status = status; return this; }
        public Builder plannedDate(LocalDate plannedDate) { this.plannedDate = plannedDate; return this; }
        public Builder executedDate(LocalDate executedDate) { this.executedDate = executedDate; return this; }
        public Builder tree(TreeJPAEntity tree) { this.tree = tree; return this; }
        public Builder quadrille(QuadrilleJPAEntity quadrille) { this.quadrille = quadrille; return this; }
        public Builder type(TypeJPAEntity type) { this.type = type; return this; }
        public Builder pqr(PQRJPAEntity pqr) { this.pqr = pqr; return this; }
        public Builder photographicRecordPath(String path) { this.photographicRecordPath = path; return this; }
        public Builder observations(String observations) { this.observations = observations; return this; }

        public PruningJPAEntity build() {
            return new PruningJPAEntity(this);
        }
    }
}
