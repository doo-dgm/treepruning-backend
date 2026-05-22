package co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetProgrammingDTO {
    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    public GetProgrammingDTO(UUID id, LocalDate initialDate, int frequencyMonths, int amount) {
        setId(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
    }

    public GetProgrammingDTO(UUID id) {
        setId(id);
        setInitialDate(DateHelper.getDefault());
        setFrequencyMonths(0);
        setAmount(0);
    }

    public GetProgrammingDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getId() { return id; }
    public LocalDate getInitialDate() { return initialDate; }
    public int getFrequencyMonths() { return frequencyMonths; }
    public int getAmount() { return amount; }

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
