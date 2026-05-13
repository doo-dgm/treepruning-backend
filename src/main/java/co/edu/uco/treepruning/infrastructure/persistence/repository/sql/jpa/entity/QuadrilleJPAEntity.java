package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quadrille")
public class QuadrilleJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "quadrille_name")
    private String quadrilleName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagerJPAEntity manager;

    protected QuadrilleJPAEntity() {}

    public QuadrilleJPAEntity(UUID id, String quadrilleName,
            ManagerJPAEntity manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UUID getId() { 
    	return id;
    	}
    public String getQuadrilleName() {
    	return quadrilleName;
    	}
    public ManagerJPAEntity getManager() {
    	return manager; 
    	}

    private void setId(UUID id) {
    	this.id = id; 
    	}
    private void setQuadrilleName(String quadrilleName) {
        this.quadrilleName = quadrilleName;
        }
    private void setManager(ManagerJPAEntity manager) {
        this.manager = manager; 
        }
}
