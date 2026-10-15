package co.edu.uco.treepruning.features.state.getstatebyfilter.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class GetStateDomain {

    private UUID id;
    private String name;
    private UUID country;

    @JsonCreator
    public GetStateDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("country") UUID country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public GetStateDomain() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setCountry(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public UUID getCountry() {
        return country;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setCountry(final UUID country) {
        this.country = UUIDHelper.getDefault(country);
    }
}
