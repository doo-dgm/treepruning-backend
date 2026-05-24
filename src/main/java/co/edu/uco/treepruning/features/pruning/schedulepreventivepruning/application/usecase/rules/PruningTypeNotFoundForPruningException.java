package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.Map;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class PruningTypeNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private PruningTypeNotFoundForPruningException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 404);
    }

    public static PruningTypeNotFoundForPruningException create(UUID typeId) {
        return new PruningTypeNotFoundForPruningException(
                "USER.ERROR.PRUNING.TYPE_NOT_FOUND",
                "TECHNICAL.ERROR.PRUNING.TYPE_NOT_FOUND",
                Map.of("typeId", typeId)
        );
    }
}
