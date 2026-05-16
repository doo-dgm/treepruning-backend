package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class StatusEntity {
	private UUID id;
	private String name;
	
	public StatusEntity() {
		
	}
	
	public StatusEntity(UUID id) {
		super();
		setId(id);
	}
	
	public StatusEntity(UUID id, String name) {
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
