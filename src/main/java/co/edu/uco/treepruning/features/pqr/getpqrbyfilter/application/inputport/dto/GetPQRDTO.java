package co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.time.LocalDate;
import java.util.UUID;

public final class GetPQRDTO {

    private UUID id;
    private LocalDate date;
    private UUID status;
    private UUID risk;
    private UUID sector;
    private UUID person;
    private String photographicRecordPath;

    public GetPQRDTO(UUID id, LocalDate date, UUID status, UUID risk, UUID sector, UUID person, String photographicRecordPath) {
        setId(id);
        setDate(date);
        setStatus(status);
        setRisk(risk);
        setSector(sector);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public GetPQRDTO() {
        setId(UUIDHelper.getDefault());
        setDate(DateHelper.getDefault());
        setStatus(UUIDHelper.getDefault());
        setRisk(UUIDHelper.getDefault());
        setSector(UUIDHelper.getDefault());
        setPerson(UUIDHelper.getDefault());
        setPhotographicRecordPath(TextHelper.getDefault());
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

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setDate(final LocalDate date) {
        this.date = DateHelper.getDefault(date);
    }
    private void setStatus(final UUID status) {
        this.status = UUIDHelper.getDefault(status);
    }
    private void setRisk(final UUID risk) {
        this.risk = UUIDHelper.getDefault(risk);
    }
    private void setSector(final UUID sector) {
        this.sector = UUIDHelper.getDefault(sector);
    }
    private void setPerson(final UUID person) {
        this.person = UUIDHelper.getDefault(person);
    }
    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
}
