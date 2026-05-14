package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

import java.time.LocalDate;
import java.util.UUID;

public final class SchedulePreventivePruningDomain {

    private UUID id;
    private UUID status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private UUID tree;
    private UUID quadrille;
    private UUID type;
    private String photographicRecordPath;
    private String observations;

    public SchedulePreventivePruningDomain(
            UUID status,
            LocalDate plannedDate,
            LocalDate executedDate,
            UUID tree,
            UUID quadrille,
            UUID type,
            String photographicRecordPath,
            String observations) {
        generateId();
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
    }

    private void generateId() {
        this.id = UUIDHelper.getUUIDHelper().generateNewUUID();
    }

    public void regenerateId() {
        generateId();
    }

    private void setStatus(UUID status) {
        this.status = status;
    }

    private void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
    }

    private void setExecutedDate(LocalDate executedDate) {
        this.executedDate = executedDate;
    }

    private void setTree(UUID tree) {
        this.tree = tree;
    }

    private void setQuadrille(UUID quadrille) {
        this.quadrille = quadrille;
    }

    private void setType(UUID type) {
        this.type = type;
    }

    private void setPhotographicRecordPath(String photographicRecordPath) {
        this.photographicRecordPath = photographicRecordPath;
    }

    private void setObservations(String observations) {
        this.observations = observations;
    }

    public UUID getId() { return id; }
    public UUID getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public UUID getTree() { return tree; }
    public UUID getQuadrille() { return quadrille; }
    public UUID getType() { return type; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }
}
