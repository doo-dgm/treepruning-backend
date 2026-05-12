package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

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
	
	private void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	private void setDate(LocalDate date) {
		this.date = DateHelper.getDateHelper().getDefault(date);
	}
	private void setStatus(StatusEntity status) {
		this.status = ObjectHelper.getDefault(status, null);
	}
	private void setRisk(RiskEntity risk) {
		this.risk = ObjectHelper.getDefault(risk, null);
	}
	private void setSector(SectorEntity sector) {
		this.sector = ObjectHelper.getDefault(sector, null);
	}
	private void setPerson(PersonEntity person) {
		this.person = ObjectHelper.getDefault(person, null);
	}
	private void setPhotographicRecordPath(String photographicRecordPath) {
		this.photographicRecordPath = TextHelper.getDefault(photographicRecordPath);
	}
    
    
}
