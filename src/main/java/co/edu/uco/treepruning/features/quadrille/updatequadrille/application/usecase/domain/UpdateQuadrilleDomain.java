package co.edu.uco.treepruning.features.quadrille.updatequadrille.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class UpdateQuadrilleDomain {

    private UUID id;
    private String quadrilleName;
    private UUID manager;

    @JsonCreator
    public UpdateQuadrilleDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("quadrilleName") String quadrilleName,
            @JsonProperty("manager") UUID manager) {
        setId(id);
        setQuadrilleName(quadrilleName);
        setManager(manager);
    }

    public UpdateQuadrilleDomain() {
        setId(UUIDHelper.getDefault());
        setQuadrilleName(TextHelper.getDefault());
        setManager(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getQuadrilleName() {
        return quadrilleName;
    }
    public UUID getManager() {
        return manager;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setQuadrilleName(final String quadrilleName) {
        this.quadrilleName = TextHelper.getDefaultWithTrim(quadrilleName);
    }
    private void setManager(final UUID manager) {
        this.manager = UUIDHelper.getDefault(manager);
    }
}
