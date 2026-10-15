package co.edu.uco.treepruning.features.manager.createmanager.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class CreateManagerDomain {

    private UUID person;

    @JsonCreator
    public CreateManagerDomain(
            @JsonProperty("person") UUID person) {
        setPerson(person);
    }

    public CreateManagerDomain() {
        setPerson(UUIDHelper.getDefault());
    }

    public UUID getPerson() {
        return person;
    }

    private void setPerson(final UUID person) {
        this.person = UUIDHelper.getDefault(person);
    }
}
