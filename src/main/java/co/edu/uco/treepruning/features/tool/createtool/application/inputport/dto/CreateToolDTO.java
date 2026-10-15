package co.edu.uco.treepruning.features.tool.createtool.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;

public final class CreateToolDTO {

    private String name;
    private String description;

    public CreateToolDTO(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public CreateToolDTO() {
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
