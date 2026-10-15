package co.edu.uco.treepruning.features.programming.createprogramming.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public final class CreateProgrammingDomain {

    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    @JsonCreator
    public CreateProgrammingDomain(
            @JsonProperty("initialDate") LocalDate initialDate,
            @JsonProperty("frequencyMonths") int frequencyMonths,
            @JsonProperty("amount") int amount) {
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
    }

    public CreateProgrammingDomain() {
        setInitialDate(DateHelper.getDefault());
        setFrequencyMonths(NumericHelper.getDefaultInt());
        setAmount(NumericHelper.getDefaultInt());
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
