package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class GetMunicipalityDomain {

    private UUID id;
    private String name;
    private UUID state;

    @JsonCreator
    public GetMunicipalityDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("state") UUID state) {
        setId(id);
        setName(name);
        setState(state);
    }

    public GetMunicipalityDomain() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setState(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public UUID getState() {
        return state;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setState(final UUID state) {
        this.state = UUIDHelper.getDefault(state);
    }
}
