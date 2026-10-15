package co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class GetStateDTO {

    private UUID id;
    private String name;
    private UUID country;

    public GetStateDTO(UUID id, String name, UUID country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public GetStateDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setCountry(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public UUID getCountry() {
        return country;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setCountry(final UUID country) {
        this.country = UUIDHelper.getDefault(country);
    }
}
