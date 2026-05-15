package co.edu.uco.treepruning.features.pruning.gettypebyid.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class TypeNotFoundException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private TypeNotFoundException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static TypeNotFoundException create(UUID typeId) {
        return new TypeNotFoundException(
            "El tipo de poda seleccionado no existe.",
            "GetTypeById: type not found with id=" + typeId
        );
    }
}