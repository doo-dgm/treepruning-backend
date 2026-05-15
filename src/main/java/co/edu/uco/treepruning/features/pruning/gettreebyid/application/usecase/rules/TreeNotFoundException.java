package co.edu.uco.treepruning.features.pruning.gettreebyid.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class TreeNotFoundException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private TreeNotFoundException(String userMessage,
            String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static TreeNotFoundException create(UUID treeId) {
        return new TreeNotFoundException(
            "El árbol seleccionado no existe.",
            "GetTreeById: tree not found with id=" + treeId
        );
    }
}