package co.edu.uco.treepruning.crosscutting.exception;

import java.io.Serial;
import java.util.UUID;

public final class ResourceNotFoundException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private ResourceNotFoundException(String userMessage, String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static ResourceNotFoundException create(String entityName, UUID id) {
        return new ResourceNotFoundException(
            "No se encontró el recurso solicitado.",
            entityName + " not found with id=" + id
        );
    }
}
