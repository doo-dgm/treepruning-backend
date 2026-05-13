package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "family")
public class FamilyJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "common_name")
    private String commonName;

    protected FamilyJPAEntity() {}

    public FamilyJPAEntity(UUID id, String scientificName,
            String commonName) {
        setId(id);
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public UUID getId() { 
    	return id;
    	}
    public String getScientificName() {
    	return scientificName;
    	}
    public String getCommonName() { 
    	return commonName;
    	}

    private void setId(UUID id) { 
    	this.id = id;
    	}
    private void setScientificName(String scientificName) {
        this.scientificName = scientificName; 
        }
    private void setCommonName(String commonName) {
        this.commonName = commonName;
        }
}
