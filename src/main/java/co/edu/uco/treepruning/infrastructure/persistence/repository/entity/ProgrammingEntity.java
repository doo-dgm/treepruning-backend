package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.NumericHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class ProgrammingEntity {

    private UUID id;
    private LocalDate initialDate;
    private int frequencyMonths;
    private int amount;

    public ProgrammingEntity() {}

    public ProgrammingEntity(UUID id) {
        setId(id);
        setInitialDate(DateHelper.getDateHelper().getDefault());
        setFrequencyMonths(NumericHelper.getDefaultInt());
        setAmount(NumericHelper.getDefaultInt());
    }

    public ProgrammingEntity(UUID id, LocalDate initialDate,
            int frequencyMonths, int amount) {
        setId(id);
        setInitialDate(initialDate);
        setFrequencyMonths(frequencyMonths);
        setAmount(amount);
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

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = DateHelper.getDateHelper()
                .getDefault(initialDate);
    }
    public void setFrequencyMonths(int frequencyMonths) {
        this.frequencyMonths = NumericHelper
                .getDefaultInt(frequencyMonths);
    }
    public void setAmount(int amount) {
        this.amount = NumericHelper.getDefaultInt(amount);
    }
}
