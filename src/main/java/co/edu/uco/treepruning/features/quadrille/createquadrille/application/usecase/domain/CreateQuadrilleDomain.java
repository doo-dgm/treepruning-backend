package co.edu.uco.treepruning.features.quadrille.createquadrille.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class CreateQuadrilleDomain {

    private String quadrilleName;
    private UUID manager;

    @JsonCreator
    public CreateQuadrilleDomain(
            @JsonProperty("quadrilleName") String quadrilleName,
            @JsonProperty("manager") UUID manager) {
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public CreateQuadrilleDomain() {
        setQuadrilleName(TextHelper.getDefault());
        setManager(UUIDHelper.getDefault());
    }

    public String getQuadrilleName() {
        return quadrilleName;
    }
    public UUID getManager() {
        return manager;
    }

    private void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }
    private void setManager(final UUID manager) {
        this.manager = UUIDHelper.getDefault(manager);
    }
}
