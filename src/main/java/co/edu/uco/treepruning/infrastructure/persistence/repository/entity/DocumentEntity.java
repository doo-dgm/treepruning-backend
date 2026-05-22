package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class DocumentEntity {
    private UUID id;
    private String name;
    private String code;

    public DocumentEntity() {
        super();
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

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id);
    }
    public void setName(String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
    public void setCode(String code) {
        this.code = TextHelper.getDefaultWithTrim(code);
    }
}
