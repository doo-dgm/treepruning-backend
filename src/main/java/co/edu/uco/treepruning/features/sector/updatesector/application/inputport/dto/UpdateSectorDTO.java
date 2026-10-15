package co.edu.uco.treepruning.features.sector.updatesector.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class UpdateSectorDTO {

    private UUID id;
    private String name;
    private UUID municipality;

    public UpdateSectorDTO(UUID id, String name, UUID municipality) {
        setId(id);
        setName(name);
        setMunicipality(municipality);
    }

    public UpdateSectorDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setMunicipality(UUIDHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public UUID getMunicipality() {
        return municipality;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setMunicipality(final UUID municipality) {
        this.municipality = UUIDHelper.getDefault(municipality);
    }
}
