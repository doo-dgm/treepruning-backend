package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class SectorEntity {
    private UUID id;
    private String name;
    private MunicipalityEntity municipality;
    
    public SectorEntity() {
		
	}
    
    public SectorEntity(UUID id) {
		super();
		setId(id);
    }
    
    
	public SectorEntity(UUID id, String name, MunicipalityEntity municipality) {
		super();
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
	public MunicipalityEntity getMunicipality() {
		return municipality;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	public void setName(String name) {
		this.name = TextHelper.getDefault(name);
	}
	public void setMunicipality(MunicipalityEntity municipality) {
		this.municipality = ObjectHelper.getDefault(municipality, null);
	}
    
    
}
