package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class MunicipalityEntity {
    private UUID id;
    private String name;
    private StateEntity state;
    
    public MunicipalityEntity() {
		
	}
    
    public MunicipalityEntity(UUID id) {
    	setId(id);
    	setName(TextHelper.getDefault());
    	setState(new StateEntity());
    }
    
	public MunicipalityEntity(UUID id, String name, StateEntity state) {
		super();
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
	public StateEntity getState() {
		return state;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	public void setName(String name) {
		this.name = TextHelper.getDefault(name);
	}
	public void setState(StateEntity state) {
		this.state = ObjectHelper.getDefault(state, new StateEntity());
	}
    
    
}	
