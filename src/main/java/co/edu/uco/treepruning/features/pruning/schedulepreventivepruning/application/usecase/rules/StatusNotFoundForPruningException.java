package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.Map;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class StatusNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private StatusNotFoundForPruningException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 404);
    }

    public static StatusNotFoundForPruningException create(UUID statusId) {
        return new StatusNotFoundForPruningException(
                "ERROR.PRUNING.STATUS_NOT_FOUND",
                "TECHNICAL.ERROR.PRUNING.STATUS_NOT_FOUND",
                Map.of("statusId", statusId)
        );
    }
}
