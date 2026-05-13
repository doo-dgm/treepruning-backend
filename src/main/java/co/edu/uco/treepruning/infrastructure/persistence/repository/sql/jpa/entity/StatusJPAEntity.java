package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class StatusJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    protected StatusJPAEntity() {}

    public StatusJPAEntity(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() { 
    	return id;
    	}
    public String getName() { 
    	return name; 
    	}

    private void setId(UUID id) {
    	this.id = id;
    	}
    private void setName(String name) { 
    	this.name = name;
    	}
}