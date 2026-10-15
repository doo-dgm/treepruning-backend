package co.edu.uco.treepruning.features.sector.createsector.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class CreateSectorDTO {

    private String name;
    private UUID municipality;

    public CreateSectorDTO(String name, UUID municipality) {
        setName(name);
        setMunicipality(municipality);
    }

    public CreateSectorDTO() {
        setName(TextHelper.getDefault());
        setMunicipality(UUIDHelper.getDefault());
    }

    public String getName() {
        return name;
    }
    public UUID getMunicipality() {
        return municipality;
    }

    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setMunicipality(final UUID municipality) {
        this.municipality = UUIDHelper.getDefault(municipality);
    }
}
