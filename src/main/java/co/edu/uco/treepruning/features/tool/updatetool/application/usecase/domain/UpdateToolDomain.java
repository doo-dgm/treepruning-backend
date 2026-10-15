package co.edu.uco.treepruning.features.tool.updatetool.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class UpdateToolDomain {

    private UUID id;
    private String name;
    private String description;

    @JsonCreator
    public UpdateToolDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public UpdateToolDomain() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setDescription(final String description) {
        this.description = TextHelper.getDefaultWithTrim(description);
    }
}
