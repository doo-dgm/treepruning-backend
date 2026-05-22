package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class CountryEntity {
    private UUID id;
    private String name;

    public CountryEntity() {
        super();
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }
}
