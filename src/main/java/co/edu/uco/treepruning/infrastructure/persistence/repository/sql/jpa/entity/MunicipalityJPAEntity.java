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
@Table(name = "municipality")
public class MunicipalityJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private StateJPAEntity state;

    public MunicipalityJPAEntity() {}

    public MunicipalityJPAEntity(UUID id, String name,
            StateJPAEntity state) {
        setId(id);
        setName(name);
        setState(state);
    }

    public UUID getId() { 
        return id;
        }
    public String getName() {
        return name;
        }
    public StateJPAEntity getState() {
        return state;
        }

    public void setId(UUID id) { 
        this.id = id;
        }
    public void setName(String name) {
        this.name = name;
        }
    public void setState(StateJPAEntity state) {
        this.state = state;
    }
}