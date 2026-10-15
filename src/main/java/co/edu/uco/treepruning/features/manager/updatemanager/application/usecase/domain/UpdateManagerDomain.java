package co.edu.uco.treepruning.features.manager.updatemanager.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class UpdateManagerDomain {

    private UUID id;
    private UUID person;

    @JsonCreator
    public UpdateManagerDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("person") UUID person) {
        setId(id);
        setPerson(person);
    }

    public UpdateManagerDomain() {
        setId(UUIDHelper.getDefault());
        setPerson(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getPerson() {
        return person;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setPerson(final UUID person) {
        this.person = UUIDHelper.getDefault(person);
    }
}
