package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class ManagerEntity {
    private UUID id;
    private PersonEntity person;

    public ManagerEntity() {
        super();
        setId(UUIDHelper.getDefault());
        setPerson(new PersonEntity());
    }

    public UUID getId() {
        return id;
    }
    public PersonEntity getPerson() {
        return person;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setPerson(PersonEntity person) {
        this.person = ObjectHelper.getDefault(person, new PersonEntity());
    }
}
