package co.edu.uco.treepruning.features.family.updatefamily.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class UpdateFamilyDomain {

    private UUID id;
    private String scientificName;
    private String commonName;

    @JsonCreator
    public UpdateFamilyDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("scientificName") String scientificName,
            @JsonProperty("commonName") String commonName) {
        setId(id);
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public UpdateFamilyDomain() {
        setId(UUIDHelper.getDefault());
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getScientificName() {
        return scientificName;
    }
    public String getCommonName() {
        return commonName;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setScientificName(final String scientificName) {
        this.scientificName = TextHelper.getDefaultWithTrim(scientificName);
    }
    private void setCommonName(final String commonName) {
        this.commonName = TextHelper.getDefaultWithTrim(commonName);
    }
}
