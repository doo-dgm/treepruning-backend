package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.usecase.domain;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetStatusDomain {
    private UUID id;
    private String name;

    @JsonCreator
    public GetStatusDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name) {
        setId(id);
        setName(name);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }

    private void setId(final UUID id) { this.id = UUIDHelper.getDefault(id); }
    private void setName(final String name) { this.name = TextHelper.getDefaultWithTrim(name); }
}