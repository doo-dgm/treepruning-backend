package co.edu.uco.treepruning.features.operator.createoperator.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class CreateOperatorDomain {

    private UUID person;
    private UUID quadrille;

    @JsonCreator
    public CreateOperatorDomain(
            @JsonProperty("person") UUID person,
            @JsonProperty("quadrille") UUID quadrille) {
        setPerson(person);
        setQuadrille(quadrille);
    }

    public CreateOperatorDomain() {
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
