package co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class GetMunicipalityDTO {

    private UUID id;
    private String name;
    private UUID state;

    public GetMunicipalityDTO(UUID id, String name, UUID state) {
        setId(id);
        setName(name);
        setState(state);
    }

    public GetMunicipalityDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setState(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public UUID getState() {
        return state;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setState(final UUID state) {
        this.state = UUIDHelper.getDefault(state);
    }
}
