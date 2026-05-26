package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class SchedulePreventivePruningDomain {

    private UUID id;
    private List<UUID> trees;
    private UUID status;
    private LocalDate plannedDate;
    private LocalDate executedDate;
    private UUID tree;
    private UUID quadrille;
    private UUID type;
    private String photographicRecordPath;
    private String observations;

    /**
     * Constructor para el DTOMapper (nivel inputport).
     * Recibe la lista de arboles sin status/type/executedDate ya que
     * esos los resuelve el UseCase.
     */
    public SchedulePreventivePruningDomain(
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

    /**
     * Constructor para el UseCaseImpl (dominio por-arbol).
     * Recibe todos los IDs ya resueltos; lo usa el DomainMapper para
     * crear la PruningEntity.
     */
    public SchedulePreventivePruningDomain(
            UUID       status,
            LocalDate  plannedDate,
            LocalDate  executedDate,
            UUID       tree,
            UUID       quadrille,
            UUID       type,
            String     photographicRecordPath,
            String     observations) {
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
        this.id = UUIDHelper.generateNewUUID();
    }

    public void regenerateId() {
        generateId();
    }

    public UUID       getId()                    { return id; }
    public List<UUID> getTrees()                 { return trees; }
    public UUID       getStatus()                { return status; }
    public LocalDate  getPlannedDate()           { return plannedDate; }
    public LocalDate  getExecutedDate()          { return executedDate; }
    public UUID       getTree()                  { return tree; }
    public UUID       getQuadrille()             { return quadrille; }
    public UUID       getType()                  { return type; }
    public String     getPhotographicRecordPath(){ return photographicRecordPath; }
    public String     getObservations()          { return observations; }

    private void setTrees(List<UUID> trees) {
        this.trees = (trees == null) ? Collections.emptyList() : List.copyOf(trees);
    }
    private void setStatus(UUID status) {
        this.status = UUIDHelper.getDefault(status);
    }
    private void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDefault(plannedDate);
    }
    private void setExecutedDate(LocalDate executedDate) {
        this.executedDate = DateHelper.getDefault(executedDate);
    }
    private void setTree(UUID tree) {
        this.tree = UUIDHelper.getDefault(tree);
    }
    private void setQuadrille(UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
    private void setType(UUID type) {
        this.type = UUIDHelper.getDefault(type);
    }
    private void setPhotographicRecordPath(String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}
