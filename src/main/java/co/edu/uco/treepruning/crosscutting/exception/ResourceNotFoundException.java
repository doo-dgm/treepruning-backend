package co.edu.uco.treepruning.crosscutting.exception;

import java.io.Serial;
import java.util.Map;
import java.util.UUID;

public final class ResourceNotFoundException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private ResourceNotFoundException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 404);
    }

    public static ResourceNotFoundException create(String entityName, UUID id) {
        return new ResourceNotFoundException(
                "USER.ERROR.GENERIC.RESOURCE_NOT_FOUND",
                "TECHNICAL.ERROR.GENERIC.RESOURCE_NOT_FOUND",
                Map.of("entityName", entityName, "id", id)
        );
    }
}
