package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

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
	
	private void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	private void setName(String name) {
		this.name = TextHelper.getDefault(name);
	}
	private void setCountry(CountryEntity country) {
		this.country = ObjectHelper.getDefault(country, null);
	}
    
    
}
