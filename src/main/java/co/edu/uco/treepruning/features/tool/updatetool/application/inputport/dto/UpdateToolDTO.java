package co.edu.uco.treepruning.features.tool.updatetool.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class UpdateToolDTO {

    private UUID id;
    private String name;
    private String description;

    public UpdateToolDTO(UUID id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public UpdateToolDTO() {
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
