package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pqr")
public class PQRJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusJPAEntity status;

    @ManyToOne
    @JoinColumn(name = "risk_id")
    private RiskJPAEntity risk;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private SectorJPAEntity sector;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonJPAEntity person;

    @Column(name = "photographic_record_path")
    private String photographicRecordPath;

    protected PQRJPAEntity() {}

    public PQRJPAEntity(UUID id, LocalDate date,
            StatusJPAEntity status, RiskJPAEntity risk,
            SectorJPAEntity sector, PersonJPAEntity person,
            String photographicRecordPath) {
        setId(id);
        setDate(date);
        setStatus(status);
        setRisk(risk);
        setSector(sector);
        setPerson(person);
        setPhotographicRecordPath(photographicRecordPath);
    }

    public UUID getId() { 
    	return id;
    	}
    public LocalDate getDate() { 
    	return date;
    	}
    public StatusJPAEntity getStatus() { 
    	return status; 
    	}
    public RiskJPAEntity getRisk() { 
    	return risk; 
    	}
    public SectorJPAEntity getSector() {
    	return sector; 
    	}
    public PersonJPAEntity getPerson() {
    	return person; 
    	}
    public String getPhotographicRecordPath() {
        return photographicRecordPath;
    }

    private void setId(UUID id) { 
    	this.id = id; 
    	}
    private void setDate(LocalDate date) {
    	this.date = date; 
    	}
    private void setStatus(StatusJPAEntity status) {
        this.status = status; }
    private void setRisk(RiskJPAEntity risk) { 
    	this.risk = risk; 
    	}
    private void setSector(SectorJPAEntity sector) {
        this.sector = sector; }
    private void setPerson(PersonJPAEntity person) {
        this.person = person; }
    private void setPhotographicRecordPath(
            String photographicRecordPath) {
        this.photographicRecordPath = photographicRecordPath; }
}
