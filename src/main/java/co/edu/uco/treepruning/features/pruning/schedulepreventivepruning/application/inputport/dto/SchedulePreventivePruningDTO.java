package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.SanitizerHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class SchedulePreventivePruningDTO {

    private List<UUID> trees;
    private LocalDate  plannedDate;
    private UUID       quadrille;
    private String     photographicRecordPath;
    private String     observations;

    public SchedulePreventivePruningDTO(
            List<UUID> trees,
            LocalDate  plannedDate,
            UUID       quadrille,
            String     photographicRecordPath,
            String     observations) {
        setTrees(trees);
        setPlannedDate(plannedDate);
        setQuadrille(quadrille);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
    }

    public List<UUID> getTrees()                  { return trees; }
    public LocalDate  getPlannedDate()            { return plannedDate; }
    public UUID       getQuadrille()              { return quadrille; }
    public String     getPhotographicRecordPath() { return photographicRecordPath; }
    public String     getObservations()           { return observations; }

    private void setTrees(List<UUID> trees) {
        this.trees = (trees == null) ? Collections.emptyList() : List.copyOf(trees);
    }
    private void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    private void setQuadrille(UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
    public void setPhotographicRecordPath(String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(String observations) {
        this.observations = SanitizerHelper.sanitize(observations);
    }
}
