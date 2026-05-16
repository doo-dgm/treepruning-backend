package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class PQREntity {
    private UUID id;
    private LocalDate date;
    private StatusEntity status;
    private RiskEntity risk;
    private SectorEntity sector;
    private PersonEntity person;
    private String photographicRecordPath;
    
    public PQREntity() {
    	
    }
    
    public PQREntity(UUID id) {
		super();
		setId(id);
		setDate(DateHelper.getDateHelper().getDefault());
		setStatus(new StatusEntity());
		setRisk(new RiskEntity());
		setSector(new SectorEntity());
		setPerson(new PersonEntity());
		setPhotographicRecordPath(TextHelper.getDefault());
    }
    
	public PQREntity(UUID id, LocalDate date, StatusEntity status, RiskEntity risk, SectorEntity sector,
			PersonEntity person, String photographicRecordPath) {
		super();
		setId(id);
		setDate(date);
		setStatus(status);
		setRisk(risk);
		setSector(sector);
		setPerson(person);
		setPhotographicRecordPath(photographicRecordPath);
	}
	
	public UUID getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public StatusEntity getStatus() {
		return status;
	}
	public RiskEntity getRisk() {
		return risk;
	}
	public SectorEntity getSector() {
		return sector;
	}
	public PersonEntity getPerson() {
		return person;
	}
	public String getPhotographicRecordPath() {
		return photographicRecordPath;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	public void setDate(LocalDate date) {
		this.date = DateHelper.getDateHelper().getDefault(date);
	}
	public void setStatus(StatusEntity status) {
		this.status = ObjectHelper.getDefault(status, null);
	}
	public void setRisk(RiskEntity risk) {
		this.risk = ObjectHelper.getDefault(risk, null);
	}
	public void setSector(SectorEntity sector) {
		this.sector = ObjectHelper.getDefault(sector, null);
	}
	public void setPerson(PersonEntity person) {
		this.person = ObjectHelper.getDefault(person, null);
	}
	public void setPhotographicRecordPath(String photographicRecordPath) {
		this.photographicRecordPath = TextHelper.getDefault(photographicRecordPath);
	}
    
    
}
