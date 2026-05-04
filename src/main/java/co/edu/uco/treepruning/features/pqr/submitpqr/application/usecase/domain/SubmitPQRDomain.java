package co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.domain;

import java.time.LocalDate;
import java.util.UUID;

public class SubmitPQRDomain {
	private UUID id;
	private LocalDate date;
	private UUID status;
	private UUID sector;
	private UUID risk;
	private UUID person;
	private String photographicRecordPath;
	
	
	
	public SubmitPQRDomain(LocalDate date, UUID status, UUID sector, UUID risk, UUID person,
			String photographicRecordPath) {
		super();
		generateId();
		setDate(date);
		setStatus(status);
		setSector(sector);
		setRisk(risk);
		setPerson(person);
		setPhotographicRecordPath(photographicRecordPath);
	}

	private void generateId() {
		this.id = UUID.randomUUID();
	}
	
	public void regenerateId() {
		this.generateId();
	}
	
	public UUID getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public UUID getStatus() {
		return status;
	}
	public UUID getSector() {
		return sector;
	}
	public UUID getRisk() {
		return risk;
	}
	public UUID getPerson() {
		return person;
	}
	public String getPhotographicRecordPath() {
		return photographicRecordPath;
	}
	private void setDate(LocalDate date) {
		this.date = date;
	}
	private void setStatus(UUID status) {
		this.status = status;
	}
	private void setSector(UUID sector) {
		this.sector = sector;
	}
	private void setRisk(UUID risk) {
		this.risk = risk;
	}
	private void setPerson(UUID person) {
		this.person = person;
	}
	private void setPhotographicRecordPath(String photographicRecordPath) {
		this.photographicRecordPath = photographicRecordPath;
	}
	
}
