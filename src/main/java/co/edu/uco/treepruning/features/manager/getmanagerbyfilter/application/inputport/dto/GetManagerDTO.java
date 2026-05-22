package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;

public final class GetManagerDTO {
    private UUID id;
    private GetPersonDTO person;

    public GetManagerDTO(UUID id, GetPersonDTO person) {
        setId(id);
        setPerson(person);
    }

    public GetManagerDTO(UUID id) {
        this(id, new GetPersonDTO());
    }

    public GetManagerDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getId() { return id; }
    public GetPersonDTO getPerson() { return person; }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setPerson(final GetPersonDTO person) {
        this.person = ObjectHelper.getDefault(person, new GetPersonDTO());
    }
}
