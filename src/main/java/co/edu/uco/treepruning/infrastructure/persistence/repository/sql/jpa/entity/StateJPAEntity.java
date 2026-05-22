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
@Table(name = "state")
public class StateJPAEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryJPAEntity country;

    public StateJPAEntity() {}

    public StateJPAEntity(UUID id, String name,
            CountryJPAEntity country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public UUID getId() { 
        return id;
        }
    public String getName() {
        return name; 
        }
    public CountryJPAEntity getCountry() { 
        return country;
        }

    public void setId(UUID id) { 
        this.id = id; 
        }
    public void setName(String name) { 
        this.name = name;
        }
    public void setCountry(CountryJPAEntity country) {
        this.country = country;
    }
}