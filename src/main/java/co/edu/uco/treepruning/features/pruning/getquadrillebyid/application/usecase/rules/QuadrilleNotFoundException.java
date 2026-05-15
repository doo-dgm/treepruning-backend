package co.edu.uco.treepruning.features.pruning.getquadrillebyid.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class QuadrilleNotFoundException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private QuadrilleNotFoundException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static QuadrilleNotFoundException create(UUID quadrilleId) {
        return new QuadrilleNotFoundException(
            "La cuadrilla seleccionada no existe.",
            "GetQuadrilleById: quadrille not found with id=" + quadrilleId
        );
    }
}
