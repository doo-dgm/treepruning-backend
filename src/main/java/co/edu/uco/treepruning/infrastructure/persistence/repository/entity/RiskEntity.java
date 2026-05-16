package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class RiskEntity {
    private UUID id;
    private String name;
    
    public RiskEntity() {
		
	}
    
    public RiskEntity(UUID id) {
		super();
		setId(id);
		setName(TextHelper.getDefault());
    }
    
    
	public RiskEntity(UUID id, String name) {
		super();
		setId(id);
		setName(name);
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	public void setName(String name) {
		this.name = TextHelper.getDefault(name);
	}
    
}
