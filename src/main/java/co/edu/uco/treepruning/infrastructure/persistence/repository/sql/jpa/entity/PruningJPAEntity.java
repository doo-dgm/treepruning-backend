package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusJPAEntity status;

    @Column(name = "planned_date")
    private LocalDate plannedDate;

    @Column(name = "executed_date")
    private LocalDate executedDate;

    @ManyToOne
    @JoinColumn(name = "tree_id")
    private TreeJPAEntity tree;

    @ManyToOne
    @JoinColumn(name = "quadrille_id")
    private QuadrilleJPAEntity quadrille;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeJPAEntity type;

    @ManyToOne
    @JoinColumn(name = "pqr_id")
    private PQRJPAEntity pqr;

    @Column(name = "photographic_record_path")
    private String photographicRecordPath;

    @Column(name = "observations")
    private String observations;

    protected PruningJPAEntity() {}

    public PruningJPAEntity(UUID id, StatusJPAEntity status,
            LocalDate plannedDate, LocalDate executedDate,
            TreeJPAEntity tree, QuadrilleJPAEntity quadrille,
            TypeJPAEntity type, PQRJPAEntity pqr,
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
    public StatusJPAEntity getStatus() { 
    	return status; 
    	}
    public LocalDate getPlannedDate() {
    	return plannedDate;
    	}
    public LocalDate getExecutedDate() {
    	return executedDate; 
    	}
    public TreeJPAEntity getTree() { 
    	return tree; 
    	}
    public QuadrilleJPAEntity getQuadrille() { 
    	return quadrille;
    	}
    public TypeJPAEntity getType() { 
    	return type;
    	}
    public PQRJPAEntity getPqr() { 
    	return pqr; 
    	}
    public String getPhotographicRecordPath() {
        return photographicRecordPath;
        }
    public String getObservations() {
    	return observations; 
    	}

    private void setId(UUID id) {
    	this.id = id; 
    	}
    private void setStatus(StatusJPAEntity status) {
        this.status = status; 
        }
    private void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
        }
    private void setExecutedDate(LocalDate executedDate) {
        this.executedDate = executedDate; 
        }
    private void setTree(TreeJPAEntity tree) { 
    	this.tree = tree; 
    	}
    private void setQuadrille(QuadrilleJPAEntity quadrille) {
        this.quadrille = quadrille;
        }
    private void setType(TypeJPAEntity type) { 
    	this.type = type; 
    	}
    private void setPqr(PQRJPAEntity pqr) { 
    	this.pqr = pqr;
    	}
    private void setPhotographicRecordPath(
            String photographicRecordPath) {
        this.photographicRecordPath = photographicRecordPath;
        }
    private void setObservations(String observations) {
        this.observations = observations;
        }
}