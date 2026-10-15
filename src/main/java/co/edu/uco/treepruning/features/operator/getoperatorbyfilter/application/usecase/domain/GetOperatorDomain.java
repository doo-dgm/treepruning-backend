package co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class GetOperatorDomain {

    private UUID id;
    private UUID person;
    private UUID quadrille;

    @JsonCreator
    public GetOperatorDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("person") UUID person,
            @JsonProperty("quadrille") UUID quadrille) {
        setId(id);
        setPerson(person);
        setQuadrille(quadrille);
    }

    public GetOperatorDomain() {
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
