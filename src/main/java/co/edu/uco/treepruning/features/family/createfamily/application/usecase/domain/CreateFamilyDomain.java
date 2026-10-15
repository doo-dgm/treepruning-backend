package co.edu.uco.treepruning.features.family.createfamily.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class CreateFamilyDomain {

    private String scientificName;
    private String commonName;

    @JsonCreator
    public CreateFamilyDomain(
            @JsonProperty("scientificName") String scientificName,
            @JsonProperty("commonName") String commonName) {
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public CreateFamilyDomain() {
        setScientificName(TextHelper.getDefault());
        setCommonName(TextHelper.getDefault());
    }

    public String getScientificName() {
        return scientificName;
    }
    public String getCommonName() {
        return commonName;
    }

    private void setScientificName(final String scientificName) {
        this.scientificName = TextHelper.getDefaultWithTrim(scientificName);
    }
    private void setCommonName(final String commonName) {
        this.commonName = TextHelper.getDefaultWithTrim(commonName);
    }
}
