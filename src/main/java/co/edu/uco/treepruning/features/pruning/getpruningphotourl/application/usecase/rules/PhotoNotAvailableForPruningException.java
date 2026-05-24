package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class PhotoNotAvailableForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private PhotoNotAvailableForPruningException(String userMessage, String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static PhotoNotAvailableForPruningException create(UUID pruningId) {
        return new PhotoNotAvailableForPruningException(
                "La poda no tiene registro fotográfico asociado.",
                "Pruning with id=" + pruningId + " has no photographicRecordPath");
    }
}
