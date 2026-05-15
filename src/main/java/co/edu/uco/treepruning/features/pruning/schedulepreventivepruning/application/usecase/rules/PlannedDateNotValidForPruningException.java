package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class PlannedDateNotValidForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private PlannedDateNotValidForPruningException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 400);
    }

    public static PlannedDateNotValidForPruningException
            createDateInPast() {
        return new PlannedDateNotValidForPruningException(
            "La fecha programada de la poda no puede ser " +
            "una fecha pasada.",
            "SchedulePreventivePruning: plannedDate is in the past"
        );
    }

    public static PlannedDateNotValidForPruningException
            createDateIsNull() {
        return new PlannedDateNotValidForPruningException(
            "La fecha programada de la poda es obligatoria.",
            "SchedulePreventivePruning: plannedDate is null"
        );
    }
}