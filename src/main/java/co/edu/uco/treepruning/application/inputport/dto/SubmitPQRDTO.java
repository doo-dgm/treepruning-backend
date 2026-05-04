package co.edu.uco.treepruning.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;

public class SubmitPQRDTO {

    private LocalDate date;
    private UUID status;
    private UUID risk;
    private UUID sector;
    private UUID person;
    private String photographicRecordPath;

    public SubmitPQRDTO(LocalDate date, UUID status, UUID sector, UUID risk, UUID person, String photographicRecordPath) {
        super();
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
        this.date = date;
    }

    private void setStatus(UUID status) {
        this.status = status;
    }

    private void setRisk(UUID risk) {
        this.risk = risk;
    }

    private void setSector(UUID sector) {
        this.sector = sector;
    }

    private void setPerson(UUID person) {
        this.person = person;
    }

    private void setPhotographicRecordPath(String photographicRecordPath) {
        this.photographicRecordPath = photographicRecordPath;
    }
}
