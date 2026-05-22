package co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetStatusDTO {
    private UUID id;
    private String name;

    public GetStatusDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public GetStatusDTO(UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
    }

    public GetStatusDTO() {
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
