package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.Map;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class QuadrilleNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private QuadrilleNotFoundForPruningException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 404);
    }

    public static QuadrilleNotFoundForPruningException create(UUID quadrilleId) {
        return new QuadrilleNotFoundForPruningException(
                "USER.ERROR.PRUNING.QUADRILLE_NOT_FOUND",
                "TECHNICAL.ERROR.PRUNING.QUADRILLE_NOT_FOUND",
                Map.of("quadrilleId", quadrilleId)
        );
    }
}
