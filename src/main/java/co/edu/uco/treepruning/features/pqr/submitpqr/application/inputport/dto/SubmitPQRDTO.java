package co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;

public final class SubmitPQRDTO {

    private LocalDate date;
    private UUID status;
    private UUID risk;
    private UUID sector;
    private UUID person;
    private String photographicRecordPath;

    public SubmitPQRDTO(LocalDate date, UUID status, UUID sector,
            UUID risk, UUID person, String photographicRecordPath) {
        setDate(date);
        setStatus(status);
        setSector(sector);
        setRisk(risk);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public LocalDate getDate() {
        return date;
    }

    public UUID getStatus() {
        return status;
    }

    public UUID getRisk() {
        return risk;
    }

    public UUID getSector() {
        return sector;
    }

    public UUID getPerson() {
        return person;
    }

    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }

	private void setDate(LocalDate date) {
		this.date = DateHelper.getDateHelper().getDefault(date);
	}

	private void setStatus(UUID status) {
		this.status = UUIDHelper.getUUIDHelper().getDefault(status);
	}

	private void setRisk(UUID risk) {
		this.risk = UUIDHelper.getUUIDHelper().getDefault(risk);
	}

	private void setSector(UUID sector) {
		this.sector = UUIDHelper.getUUIDHelper().getDefault(sector);
	}

	private void setPerson(UUID person) {
		this.person = UUIDHelper.getUUIDHelper().getDefault(person);
	}

	private void setPhotographicRecordPath(String photographicRecordPath) {
		this.photographicRecordPath = TextHelper.getDefault(photographicRecordPath);
	}
    
    
    
}
