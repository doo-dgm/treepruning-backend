package co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.usecase.domain;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.usecase.domain.GetPersonDomain;

public final class GetManagerDomain {
    private UUID id;
    private GetPersonDomain person;

    public GetManagerDomain(UUID id, GetPersonDomain person) {
        setId(id);
        setPerson(person);
    }

    public UUID getId() { return id; }
    public GetPersonDomain getPerson() { return person; }

    private void setId(final UUID id) { this.id = UUIDHelper.getDefault(id); }
    private void setPerson(final GetPersonDomain person) { this.person = person; }
}
