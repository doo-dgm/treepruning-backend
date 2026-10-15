package co.edu.uco.treepruning.features.family.updatefamily.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class UpdateFamilyDTO {

    private UUID id;
    private String scientificName;
    private String commonName;

    public UpdateFamilyDTO(UUID id, String scientificName, String commonName) {
        setId(id);
        setScientificName(scientificName);
        setCommonName(commonName);
    }

    public UpdateFamilyDTO() {
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
