package co.edu.uco.treepruning.features.manager.updatemanager.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class UpdateManagerDTO {

    private UUID id;
    private UUID person;

    public UpdateManagerDTO(UUID id, UUID person) {
        setId(id);
        setPerson(person);
    }

    public UpdateManagerDTO() {
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
