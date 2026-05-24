package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class SchedulePreventivePruningDTO {

    private UUID status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private UUID tree;
    private UUID quadrille;
    private UUID type;
    private String photographicRecordPath;
    private String observations;

    private final byte[] photoBytes;
    private final String photoContentType;
    private final String photoOriginalFilename;

    public SchedulePreventivePruningDTO(
            UUID status,
            LocalDate plannedDate,
            LocalDate executedDate,
            UUID tree,
            UUID quadrille,
            UUID type,
            String photographicRecordPath,
            String observations) {
        this(status, plannedDate, executedDate, tree, quadrille, type,
                photographicRecordPath, observations, null, null, null);
    }

    public SchedulePreventivePruningDTO(
            UUID status,
            LocalDate plannedDate,
            LocalDate executedDate,
            UUID tree,
            UUID quadrille,
            UUID type,
            String photographicRecordPath,
            String observations,
            byte[] photoBytes,
            String photoContentType,
            String photoOriginalFilename) {
        setStatus(status);
        setPlannedDate(plannedDate);
        setExecutedDate(executedDate);
        setTree(tree);
        setQuadrille(quadrille);
        setType(type);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
        this.photoBytes = photoBytes;
        this.photoContentType = photoContentType;
        this.photoOriginalFilename = photoOriginalFilename;
    }

    public UUID getStatus() { return status; }
    public LocalDate getPlannedDate() { return plannedDate; }
    public LocalDate getExecutedDate() { return executedDate; }
    public UUID getTree() { return tree; }
    public UUID getQuadrille() { return quadrille; }
    public UUID getType() { return type; }
    public String getPhotographicRecordPath() { return photographicRecordPath; }
    public String getObservations() { return observations; }
    public byte[] getPhotoBytes() { return photoBytes; }
    public String getPhotoContentType() { return photoContentType; }
    public String getPhotoOriginalFilename() { return photoOriginalFilename; }

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

    public void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }

    private void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}
