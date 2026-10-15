package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class TreeEntity {
    private UUID id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private FamilyEntity family;
    private SectorEntity sector;
    private ProgrammingEntity programming;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public TreeEntity() {
        super();
        setId(UUIDHelper.getDefault());
        setLongitude(BigDecimal.ZERO);
        setLatitude(BigDecimal.ZERO);
        setFamily(new FamilyEntity());
        setSector(new SectorEntity());
        setProgramming(new ProgrammingEntity());
        setCreatedAt(DateHelper.getDefaultZonedDateTime());
        setUpdatedAt(DateHelper.getDefaultZonedDateTime());
    }
    
    public TreeEntity(final UUID id) {
		super();
		setId(id);
		setLongitude(BigDecimal.ZERO);
		setLatitude(BigDecimal.ZERO);
		setFamily(new FamilyEntity());
		setSector(new SectorEntity());
		setProgramming(new ProgrammingEntity());
		setCreatedAt(DateHelper.getDefaultZonedDateTime());
		setUpdatedAt(DateHelper.getDefaultZonedDateTime());
	}
    
    public TreeEntity(final UUID id, final BigDecimal longitude, final BigDecimal latitude, final FamilyEntity family, final SectorEntity sector, final ProgrammingEntity programming, final ZonedDateTime createdAt, final ZonedDateTime updatedAt) {
    			super();
		setId(id);
		setLongitude(longitude);
		setLatitude(latitude);
		setFamily(family);
		setSector(sector);
		setProgramming(programming);
		setCreatedAt(createdAt);
		setUpdatedAt(updatedAt);
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

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setLongitude(final BigDecimal longitude) {
        this.longitude = longitude != null ? longitude : BigDecimal.ZERO;
    }
    public void setLatitude(final BigDecimal latitude) {
        this.latitude = latitude != null ? latitude : BigDecimal.ZERO;
    }
    public void setFamily(final FamilyEntity family) {
        this.family = ObjectHelper.getDefault(family, new FamilyEntity());
    }
    public void setSector(final SectorEntity sector) {
        this.sector = ObjectHelper.getDefault(sector, new SectorEntity());
    }
    public void setProgramming(final ProgrammingEntity programming) {
        this.programming = ObjectHelper.getDefault(programming, new ProgrammingEntity());
    }
    public void setCreatedAt(final ZonedDateTime createdAt) {
		this.createdAt = DateHelper.getDefaultZonedDateTime(createdAt);
	}
    public void setUpdatedAt(final ZonedDateTime updatedAt) {
		this.updatedAt = DateHelper.getDefaultZonedDateTime(updatedAt);
	}
}
