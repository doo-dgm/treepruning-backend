package co.edu.uco.treepruning.features.sector.createsector.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class CreateSectorDomain {

    private String name;
    private UUID municipality;

    @JsonCreator
    public CreateSectorDomain(
            @JsonProperty("name") String name,
            @JsonProperty("municipality") UUID municipality) {
        setName(name);
        setMunicipality(municipality);
    }

    public CreateSectorDomain() {
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
