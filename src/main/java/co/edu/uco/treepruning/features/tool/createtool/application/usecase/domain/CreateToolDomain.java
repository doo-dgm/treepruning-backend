package co.edu.uco.treepruning.features.tool.createtool.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class CreateToolDomain {

    private String name;
    private String description;

    @JsonCreator
    public CreateToolDomain(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description) {
        setName(name);
        setDescription(description);
    }

    public CreateToolDomain() {
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setDescription(final String description) {
        this.description = TextHelper.getDefaultWithTrim(description);
    }
}
