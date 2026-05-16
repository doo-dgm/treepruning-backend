package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class StateEntity {
    private UUID id;
    private String name;
    private CountryEntity country;
    
    public StateEntity() {
		
	}
    
    public StateEntity(UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setCountry(new CountryEntity());
	}
    
    
	public StateEntity(UUID id, String name, CountryEntity country) {
		super();
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	private UUID getId() {
		return id;
	}
	private String getName() {
		return name;
	}
	private CountryEntity getCountry() {
		return country;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	public void setName(String name) {
		this.name = TextHelper.getDefault(name);
	}
	public void setCountry(CountryEntity country) {
		this.country = ObjectHelper.getDefault(country, null);
	}
    
    
}
