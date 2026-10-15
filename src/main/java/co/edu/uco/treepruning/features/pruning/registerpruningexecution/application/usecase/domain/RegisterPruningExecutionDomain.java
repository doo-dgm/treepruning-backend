package co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;

public final class RegisterPruningExecutionDomain {

    private UUID id;
    private LocalDate executedDate;
    private String photographicRecordPath;
    private String observations;

    @JsonCreator
    public RegisterPruningExecutionDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("executedDate") LocalDate executedDate,
            @JsonProperty("photographicRecordPath") String photographicRecordPath,
            @JsonProperty("observations") String observations) {
        setId(id);
        setExecutedDate(executedDate);
        setPhotographicRecordPath(photographicRecordPath);
        setObservations(observations);
    }

    public RegisterPruningExecutionDomain() {
        setId(UUIDHelper.getDefault());
        setExecutedDate(DateHelper.getDefault());
        setPhotographicRecordPath(TextHelper.getDefault());
        setObservations(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public LocalDate getExecutedDate() {
        return executedDate;
    }
    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }
    public String getObservations() {
        return observations;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setExecutedDate(final LocalDate executedDate) {
        this.executedDate = DateHelper.getDefault(executedDate);
    }
    private void setPhotographicRecordPath(final String photographicRecordPath) {
        this.photographicRecordPath = TextHelper.getDefaultWithTrim(photographicRecordPath);
    }
    private void setObservations(final String observations) {
        this.observations = TextHelper.getDefaultWithTrim(observations);
    }
}
