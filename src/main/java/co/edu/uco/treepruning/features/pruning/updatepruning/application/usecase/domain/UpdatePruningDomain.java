package co.edu.uco.treepruning.features.pruning.updatepruning.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;

public final class UpdatePruningDomain {

    private UUID id;
    private UUID status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private UUID tree;
    private UUID quadrille;
    private UUID type;
    private UUID pqr;
    private String photographicRecordPath;
    private String observations;

    @JsonCreator
    public UpdatePruningDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("status") UUID status,
            @JsonProperty("plannedDate") LocalDate plannedDate,
            @JsonProperty("executedDate") LocalDate executedDate,
            @JsonProperty("tree") UUID tree,
            @JsonProperty("quadrille") UUID quadrille,
            @JsonProperty("type") UUID type,
            @JsonProperty("pqr") UUID pqr,
            @JsonProperty("photographicRecordPath") String photographicRecordPath,
            @JsonProperty("observations") String observations) {
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

    public UpdatePruningDomain() {
        setId(UUIDHelper.getDefault());
        setStatus(UUIDHelper.getDefault());
        setPlannedDate(DateHelper.getDefault());
        setExecutedDate(DateHelper.getDefault());
        setTree(UUIDHelper.getDefault());
        setQuadrille(UUIDHelper.getDefault());
        setType(UUIDHelper.getDefault());
        setPqr(UUIDHelper.getDefault());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getStatus() {
        return status;
    }
    public LocalDate getPlannedDate() {
        return plannedDate;
    }
    public LocalDate getExecutedDate() {
        return executedDate;
    }
    public UUID getTree() {
        return tree;
    }
    public UUID getQuadrille() {
        return quadrille;
    }
    public UUID getType() {
        return type;
    }
    public UUID getPqr() {
        return pqr;
    }
    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }
    public String getObservations() {
        return observations;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setStatus(final UUID status) {
        this.status = UUIDHelper.getDefault(status);
    }
    private void setPlannedDate(final LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    private void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDefault(executedDate);
    }
    private void setTree(final UUID tree) {
        this.tree = UUIDHelper.getDefault(tree);
    }
    private void setQuadrille(final UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
    private void setType(final UUID type) {
        this.type = UUIDHelper.getDefault(type);
    }
    private void setPqr(final UUID pqr) {
        this.pqr = UUIDHelper.getDefault(pqr);
    }
    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}
