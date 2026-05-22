package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class StateEntity {
    private UUID id;
    private String name;
    private CountryEntity country;

    public StateEntity() {
        super();
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setCountry(new CountryEntity());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public CountryEntity getCountry() {
        return country;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }
    public void setCountry(CountryEntity country) {
        this.country = ObjectHelper.getDefault(country, new CountryEntity());
    }
}
