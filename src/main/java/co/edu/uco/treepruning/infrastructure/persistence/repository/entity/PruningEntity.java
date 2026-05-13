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

    public PruningEntity() {}

    public PruningEntity(UUID id) {
        setId(id);
        setStatus(new StatusEntity());
        setPlannedDate(DateHelper.getDateHelper().getDefault());
        setExecutedDate(DateHelper.getDateHelper().getDefault());
        setTree(new TreeEntity());
        setQuadrille(new QuadrilleEntity());
        setType(new TypeEntity());
        setPqr(new PQREntity());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public PruningEntity(UUID id, StatusEntity status,
            LocalDate plannedDate, LocalDate executedDate,
            TreeEntity tree, QuadrilleEntity quadrille,
            TypeEntity type, PQREntity pqr,
            String photographicRecordPath, String observations) {
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

    private void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    private void setStatus(StatusEntity status) {
        this.status = ObjectHelper.getDefault(
                status, new StatusEntity());
    }
    private void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = DateHelper.getDateHelper()
                .getDefault(plannedDate);
    }
    private void setExecutedDate(LocalDate executedDate) {
        this.executedDate = DateHelper.getDateHelper()
                .getDefault(executedDate);
    }
    private void setTree(TreeEntity tree) {
        this.tree = ObjectHelper.getDefault(
                tree, new TreeEntity());
    }
    private void setQuadrille(QuadrilleEntity quadrille) {
        this.quadrille = ObjectHelper.getDefault(
                quadrille, new QuadrilleEntity());
    }
    private void setType(TypeEntity type) {
        this.type = ObjectHelper.getDefault(
                type, new TypeEntity());
    }
    private void setPqr(PQREntity pqr) {
        this.pqr = ObjectHelper.getDefault(pqr, new PQREntity());
    }
    private void setPhotographicRecordPath(
            String photographicRecordPath) {
        this.photographicRecordPath = TextHelper
                .getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(String observations) {
        this.observations = TextHelper
                .getDefaultWithTrim(observations);
    }
}