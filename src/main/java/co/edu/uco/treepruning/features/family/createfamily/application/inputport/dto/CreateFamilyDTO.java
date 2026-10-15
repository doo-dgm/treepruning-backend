package co.edu.uco.treepruning.features.family.createfamily.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;

public final class CreateFamilyDTO {

    private String scientificName;
    private String commonName;

    public CreateFamilyDTO(String scientificName, String commonName) {
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public CreateFamilyDTO() {
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
