package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public class DocumentEntity {

    private UUID id;
    private String name;
    private String code;
    
     public DocumentEntity() {
	 	
	 }
     
     public DocumentEntity(UUID id) {
 		setId(id);
     }
    
	public DocumentEntity(UUID id, String name, String code) {
		super();
		setId(id);
		setName(name);
		setCode(code);
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	
	private void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	private void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	private void setCode(String code) {
		this.code = TextHelper.getDefaultWithTrim(code);
	}
    
    
}
