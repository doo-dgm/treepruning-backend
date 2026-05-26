package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class TreeAlreadyScheduledForDateException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private TreeAlreadyScheduledForDateException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 409);
    }

    public static TreeAlreadyScheduledForDateException create(UUID treeId, LocalDate plannedDate) {
        return new TreeAlreadyScheduledForDateException(
                "ERROR.PRUNING.TREE_ALREADY_SCHEDULED",
                "TECHNICAL.ERROR.PRUNING.TREE_ALREADY_SCHEDULED",
                Map.of("treeId", treeId, "plannedDate", plannedDate)
        );
    }
}
