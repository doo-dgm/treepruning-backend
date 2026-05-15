package co.edu.uco.treepruning.features.pruning.getstatusbyid.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class StatusNotFoundException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private StatusNotFoundException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static StatusNotFoundException create(UUID statusId) {
        return new StatusNotFoundException(
            "El estado seleccionado no existe.",
            "GetStatusById: status not found with id=" + statusId
        );
    }
}
