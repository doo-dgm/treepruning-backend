package co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.usecase.rules;

import java.io.Serial;
import java.util.Map;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

public final class PhotoNotAvailableForPruningException extends TreePruningException {

    @Serial
    private static final long serialVersionUID = 1L;

    private PhotoNotAvailableForPruningException(String code, String technicalCode,
            Map<String, Object> variables) {
        super(code, technicalCode, variables, 404);
    }

    public static PhotoNotAvailableForPruningException create(UUID pruningId) {
        return new PhotoNotAvailableForPruningException(
                "USER.ERROR.PRUNING.PHOTO_NOT_AVAILABLE",
                "TECHNICAL.ERROR.PRUNING.PHOTO_NOT_AVAILABLE",
                Map.of("pruningId", pruningId)
        );
    }
}
