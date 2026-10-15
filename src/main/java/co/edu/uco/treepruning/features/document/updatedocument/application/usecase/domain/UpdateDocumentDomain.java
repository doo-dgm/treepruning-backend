package co.edu.uco.treepruning.features.document.updatedocument.application.usecase.domain;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public final class UpdateDocumentDomain {

    private UUID id;
    private String name;
    private String code;

    @JsonCreator
    public UpdateDocumentDomain(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("code") String code) {
        setId(id);
        setName(name);
        setCode(code);
    }

    public UpdateDocumentDomain() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.getDefault());
        setCode(TextHelper.getDefault());
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    private void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    private void setCode(final String code) {
        this.code = TextHelper.getDefaultWithTrim(code);
    }
}
