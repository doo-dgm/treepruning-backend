package co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import java.util.UUID;

public final class GetDocumentDTO {

    private UUID id;
    private String name;
    private String code;

    public GetDocumentDTO(UUID id, String name, String code) {
        setId(id);
        setName(name);
        setCode(code);
    }

    public GetDocumentDTO() {
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
