package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class PlannedDateNotValidForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private PlannedDateNotValidForPruningException(String code, String technicalCode) {
        super(code, technicalCode, null, 400);
    }

    public static PlannedDateNotValidForPruningException createDateInPast() {
        return new PlannedDateNotValidForPruningException(
                "USER.ERROR.PRUNING.PLANNED_DATE_PAST",
                "TECHNICAL.ERROR.PRUNING.PLANNED_DATE_PAST"
        );
    }

    public static PlannedDateNotValidForPruningException createDateIsNull() {
        return new PlannedDateNotValidForPruningException(
                "USER.ERROR.PRUNING.PLANNED_DATE_NULL",
                "TECHNICAL.ERROR.PRUNING.PLANNED_DATE_NULL"
        );
    }

    public static PlannedDateNotValidForPruningException createDateBeyondHorizon() {
        return new PlannedDateNotValidForPruningException(
                "USER.ERROR.PRUNING.PLANNED_DATE_BEYOND_HORIZON",
                "TECHNICAL.ERROR.PRUNING.PLANNED_DATE_BEYOND_HORIZON"
        );
    }
}
