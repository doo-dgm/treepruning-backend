package co.edu.uco.treepruning.features.pqr.updatepqr.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;

public final class UpdatePQRDomain {

    private UUID id;
    private LocalDate date;
    private UUID status;
    private UUID risk;
    private UUID sector;
    private UUID person;
    private String photographicRecordPath;

    @JsonCreator
    public UpdatePQRDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("date") LocalDate date,
            @JsonProperty("status") UUID status,
            @JsonProperty("risk") UUID risk,
            @JsonProperty("sector") UUID sector,
            @JsonProperty("person") UUID person,
            @JsonProperty("photographicRecordPath") String photographicRecordPath) {
        setId(id);
        setDate(date);
        setStatus(status);
        setRisk(risk);
        setSector(sector);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public UpdatePQRDomain() {
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
