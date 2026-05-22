package co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetTypeDTO {
    private UUID id;
    private String name;

    public GetTypeDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public GetTypeDTO(UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
    }

    public GetTypeDTO() {
        this(UUIDHelper.getDefault());
    }

    public UUID getId() { return id; }
    public String getName() { return name; }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}
