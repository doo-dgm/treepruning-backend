package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "programming")
public class ProgrammingJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "frequency_months")
    private int frequencyMonths;

    @Column(name = "amount")
    private int amount;

    public ProgrammingJPAEntity() {
        
    }

    public ProgrammingJPAEntity(UUID id, LocalDate initialDate,
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
        this.id = id;
        }
    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
        }
    public void setFrequencyMonths(int frequencyMonths) {
        this.frequencyMonths = frequencyMonths; 
        }
    public void setAmount(int amount) { 
        this.amount = amount; 
        }
}