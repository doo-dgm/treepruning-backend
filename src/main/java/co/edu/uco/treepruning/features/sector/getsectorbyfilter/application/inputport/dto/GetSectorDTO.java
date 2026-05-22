package co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public final class GetSectorDTO {
    private UUID id;
    private String name;

    public GetSectorDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public GetSectorDTO(UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
    }

    public GetSectorDTO() {
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
