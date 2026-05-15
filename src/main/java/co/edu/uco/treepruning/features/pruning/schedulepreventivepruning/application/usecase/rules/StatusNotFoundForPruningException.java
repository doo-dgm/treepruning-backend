package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class StatusNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private StatusNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static StatusNotFoundForPruningException create(
            UUID statusId) {
        return new StatusNotFoundForPruningException(
            "No se encontró el estado seleccionado para la poda.",
            "SchedulePreventivePruning: status not found with id=" + statusId
        );
    }
}