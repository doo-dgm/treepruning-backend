package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class TreeNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private TreeNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static TreeNotFoundForPruningException create(UUID treeId) {
        return new TreeNotFoundForPruningException(
            "No se encontró el árbol seleccionado para programar la poda.",
            "SchedulePreventivePruning: tree not found with id=" + treeId
        );
    }
}