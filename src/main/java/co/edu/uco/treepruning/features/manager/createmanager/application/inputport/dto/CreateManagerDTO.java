package co.edu.uco.treepruning.features.manager.createmanager.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class CreateManagerDTO {

    private UUID person;

    public CreateManagerDTO(UUID person) {
        setPerson(person);
    }

    public CreateManagerDTO() {
        setPerson(UUIDHelper.getDefault());
    }

    public UUID getPerson() {
        return person;
    }

    private void setPerson(final UUID person) {
        this.person = UUIDHelper.getDefault(person);
    }
}
