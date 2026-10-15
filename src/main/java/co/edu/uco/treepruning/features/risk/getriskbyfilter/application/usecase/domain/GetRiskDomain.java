package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class GetRiskDomain {

    private UUID id;
    private String name;

    @JsonCreator
    public GetRiskDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name) {
        setId(id);
        setName(name);
    }

    public GetRiskDomain() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}
