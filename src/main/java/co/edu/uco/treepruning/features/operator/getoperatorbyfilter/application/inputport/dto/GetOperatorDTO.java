package co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class GetOperatorDTO {

    private UUID id;
    private UUID person;
    private UUID quadrille;

    public GetOperatorDTO(UUID id, UUID person, UUID quadrille) {
        setId(id);
        setPerson(person);
        setQuadrille(quadrille);
    }

    public GetOperatorDTO() {
        setId(UUIDHelper.getDefault());
        setPerson(UUIDHelper.getDefault());
        setQuadrille(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public UUID getPerson() {
        return person;
    }
    public UUID getQuadrille() {
        return quadrille;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setPerson(final UUID person) {
        this.person = UUIDHelper.getDefault(person);
    }
    private void setQuadrille(final UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
}
