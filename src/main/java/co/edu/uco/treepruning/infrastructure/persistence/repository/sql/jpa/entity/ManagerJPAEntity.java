package co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager")
public class ManagerJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonJPAEntity person;

    public ManagerJPAEntity() {
        
    }

    public ManagerJPAEntity(UUID id, PersonJPAEntity person) {
        setId(id);
        setPerson(person);
    }

    public UUID getId() {
        return id; 
        }
    public PersonJPAEntity getPerson() { 
        return person; 
        }

    public void setId(UUID id) {
        this.id = id;
        }
    public void setPerson(PersonJPAEntity person) {
        this.person = person;
        }
}
