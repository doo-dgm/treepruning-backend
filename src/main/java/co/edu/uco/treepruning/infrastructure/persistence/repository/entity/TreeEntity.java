package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.math.BigDecimal;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class TreeEntity {
    private UUID id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private FamilyEntity family;
    private SectorEntity sector;
    private ProgrammingEntity programming;

    public TreeEntity() {
        super();
        setId(UUIDHelper.getDefault());
        setLongitude(BigDecimal.ZERO);
        setLatitude(BigDecimal.ZERO);
        setFamily(new FamilyEntity());
        setSector(new SectorEntity());
        setProgramming(new ProgrammingEntity());
    }

    public UUID getId() { 
    	return id;
    	}
    public BigDecimal getLongitude() { 
    	return longitude;
    	}
    public BigDecimal getLatitude() { 
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
        this.id = UUIDHelper.getDefault(id);
    }
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude != null ? longitude : BigDecimal.ZERO;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude != null ? latitude : BigDecimal.ZERO;
    }
    public void setFamily(FamilyEntity family) {
        this.family = ObjectHelper.getDefault(family, new FamilyEntity());
    }
    public void setSector(SectorEntity sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorEntity());
    }
    public void setProgramming(ProgrammingEntity programming) {
        this.programming = ObjectHelper.getDefault(programming, new ProgrammingEntity());
    }
}
