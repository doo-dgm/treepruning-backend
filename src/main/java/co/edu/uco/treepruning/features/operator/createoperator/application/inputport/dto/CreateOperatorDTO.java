package co.edu.uco.treepruning.features.operator.createoperator.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class CreateOperatorDTO {

    private UUID person;
    private UUID quadrille;

    public CreateOperatorDTO(UUID person, UUID quadrille) {
        setPerson(person);
        setQuadrille(quadrille);
    }

    public CreateOperatorDTO() {
        setPerson(UUIDHelper.getDefault());
        setQuadrille(UUIDHelper.getDefault());
    }

    public UUID getPerson() {
        return person;
    }
    public UUID getQuadrille() {
        return quadrille;
    }

    private void setPerson(final UUID person) {
        this.person = UUIDHelper.getDefault(person);
    }
    private void setQuadrille(final UUID quadrille) {
        this.quadrille = UUIDHelper.getDefault(quadrille);
    }
}
