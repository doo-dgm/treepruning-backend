package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class FamilyEntity {

    private UUID id;
    private String scientificName;
    private String commonName;

    public FamilyEntity() {}

    public FamilyEntity(UUID id) {
        setId(id);
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public FamilyEntity(UUID id, String scientificName,
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

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    public void setScientificName(String scientificName) {
        this.scientificName = TextHelper
                .getDefaultWithTrim(scientificName);
    }
    public void setCommonName(String commonName) {
        this.commonName = TextHelper.getDefaultWithTrim(commonName);
    }
}