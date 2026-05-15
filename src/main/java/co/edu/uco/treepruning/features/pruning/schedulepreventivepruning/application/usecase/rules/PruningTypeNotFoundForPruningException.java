package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class PruningTypeNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private PruningTypeNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static PruningTypeNotFoundForPruningException create(
            UUID typeId) {
        return new PruningTypeNotFoundForPruningException(
            "No se encontró el tipo de poda seleccionado.",
            "SchedulePreventivePruning: pruning type not found with id=" + typeId
        );
    }
}
