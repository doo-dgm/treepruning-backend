package co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class GetRiskDTO {

    private UUID id;
    private String name;

    public GetRiskDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public GetRiskDTO() {
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
