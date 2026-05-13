package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "municipality")
public class MunicipalityJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateJPAEntity state;

    protected MunicipalityJPAEntity() {}

    public MunicipalityJPAEntity(UUID id, String name,
            StateJPAEntity state) {
        setId(id);
        setName(name);
        setState(state);
    }

    public UUID getId() { 
    	return id;
    	}
    public String getName() {
    	return name;
    	}
    public StateJPAEntity getState() {
    	return state;
    	}

    private void setId(UUID id) { 
    	this.id = id;
    	}
    private void setName(String name) {
    	this.name = name;
    	}
    private void setState(StateJPAEntity state) {
        this.state = state;
    }
}