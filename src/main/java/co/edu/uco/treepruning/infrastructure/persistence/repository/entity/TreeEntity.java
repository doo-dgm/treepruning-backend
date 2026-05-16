package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class TreeEntity {

    private UUID id;
    private String longitude;
    private String latitude;
    private FamilyEntity family;
    private SectorEntity sector;
    private ProgrammingEntity programming;

    public TreeEntity() {}

    public TreeEntity(UUID id) {
        setId(id);
        setLongitude(TextHelper.getDefault());
        setLatitude(TextHelper.getDefault());
        setFamily(new FamilyEntity());
        setSector(new SectorEntity());
        setProgramming(new ProgrammingEntity());
    }

    public TreeEntity(UUID id, String longitude, String latitude,
            FamilyEntity family, SectorEntity sector,
            ProgrammingEntity programming) {
        setId(id);
        setLongitude(longitude);
        setLatitude(latitude);
        setFamily(family);
        setSector(sector);
        setProgramming(programming);
    }

    public UUID getId() {
    	return id;
    	}
    public String getLongitude() { 
    	return longitude; 
    	}
    public String getLatitude() { 
    	return latitude;
    	}
    public FamilyEntity getFamily() { 
    	return family; 
    	}
    public SectorEntity getSector() { 
    	return sector;
    	}
    public ProgrammingEntity getProgramming() { 
    	return programming; 
    	}

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    public void setLongitude(String longitude) {
        this.longitude = TextHelper.getDefaultWithTrim(longitude);
    }
    public void setLatitude(String latitude) {
        this.latitude = TextHelper.getDefaultWithTrim(latitude);
    }
    public void setFamily(FamilyEntity family) {
        this.family = ObjectHelper.getDefault(
                family, new FamilyEntity());
    }
    public void setSector(SectorEntity sector) {
        this.sector = ObjectHelper.getDefault(
                sector, new SectorEntity());
    }
    public void setProgramming(ProgrammingEntity programming) {
        this.programming = ObjectHelper.getDefault(
                programming, new ProgrammingEntity());
    }
}