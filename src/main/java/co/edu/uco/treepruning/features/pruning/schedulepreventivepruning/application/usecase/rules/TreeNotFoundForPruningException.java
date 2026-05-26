package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.Map;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class TreeNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private TreeNotFoundForPruningException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 404);
    }

    public static TreeNotFoundForPruningException create(UUID treeId) {
        return new TreeNotFoundForPruningException(
                "ERROR.PRUNING.TREE_NOT_FOUND",
                "TECHNICAL.ERROR.PRUNING.TREE_NOT_FOUND",
                Map.of("treeId", treeId)
        );
    }
}
