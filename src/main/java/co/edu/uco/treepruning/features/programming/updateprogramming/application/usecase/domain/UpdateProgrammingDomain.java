package co.edu.uco.treepruning.features.programming.updateprogramming.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;

public final class UpdateProgrammingDomain {

    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    @JsonCreator
    public UpdateProgrammingDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("initialDate") LocalDate initialDate,
            @JsonProperty("frequencyMonths") int frequencyMonths,
            @JsonProperty("amount") int amount) {
        setId(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
    }

    public UpdateProgrammingDomain() {
        setId(UUIDHelper.getDefault());
        setInitialDate(DateHelper.getDefault());
        setFrequencyMonths(NumericHelper.getDefaultInt());
        setAmount(NumericHelper.getDefaultInt());
    }

    public UUID getId() {
        return id;
    }
    public LocalDate getInitialDate() {
        return initialDate;
    }
    public int getFrequencyMonths() {
        return frequencyMonths;
    }
    public int getAmount() {
        return amount;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setInitialDate(final LocalDate initialDate) {
        this.initialDate = DateHelper.getDefault(initialDate);
    }
    private void setFrequencyMonths(final int frequencyMonths) {
        this.frequencyMonths = NumericHelper.getDefaultInt(frequencyMonths);
    }
    private void setAmount(final int amount) {
        this.amount = NumericHelper.getDefaultInt(amount);
    }
}
