package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sector")
public class SectorJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private MunicipalityJPAEntity municipality;

    protected SectorJPAEntity() {}

    public SectorJPAEntity(UUID id, String name,
            MunicipalityJPAEntity municipality) {
        setId(id);
        setName(name);
        setMunicipality(municipality);
    }

    public UUID getId() {
    	return id;
    	}
    public String getName() { 
    	return name;
    	}
    public MunicipalityJPAEntity getMunicipality() {
        return municipality;
    }

    private void setId(UUID id) { 
    	this.id = id; 
    	}
    private void setName(String name) {
    	this.name = name; 
    	}
    private void setMunicipality(MunicipalityJPAEntity municipality) {
        this.municipality = municipality;
    }
}
