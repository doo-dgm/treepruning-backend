package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class QuadrilleNotFoundForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private QuadrilleNotFoundForPruningException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static QuadrilleNotFoundForPruningException create(
            UUID quadrilleId) {
        return new QuadrilleNotFoundForPruningException(
            "No se encontró la cuadrilla seleccionada para programar la poda.",
            "SchedulePreventivePruning: quadrille not found with id=" + quadrilleId
        );
    }
}