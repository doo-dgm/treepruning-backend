package co.edu.uco.treepruning.features.sector.updatesector.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class UpdateSectorDomain {

    private UUID id;
    private String name;
    private UUID municipality;

    @JsonCreator
    public UpdateSectorDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("municipality") UUID municipality) {
        setId(id);
        setName(name);
        setMunicipality(municipality);
    }

    public UpdateSectorDomain() {
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
