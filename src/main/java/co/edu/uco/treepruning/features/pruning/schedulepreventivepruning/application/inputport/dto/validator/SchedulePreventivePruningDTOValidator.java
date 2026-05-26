package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PlannedDateNotValidForPruningException;

public final class SchedulePreventivePruningDTOValidator {

    private static final int MAX_TREES = 50;

    private SchedulePreventivePruningDTOValidator() {}

    /** Minimo 1 arbol, maximo {@value MAX_TREES}. */
    public static void validateTrees(List<UUID> trees) {
        if (trees == null || trees.isEmpty()) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.TREES_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.TREES_REQUIRED");
        }
        if (trees.size() > MAX_TREES) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.TREES_MAX",
                    "TECHNICAL.VALIDATION.PRUNING.TREES_MAX",
                    Map.of("max", MAX_TREES));
        }
    }

    /** Fecha obligatoria, no pasada, dentro del horizonte de programacion. */
    public static void validatePlannedDate(LocalDate plannedDate, int horizonMonths) {
        if (DateHelper.isDefaultDate(DateHelper.getDefault(plannedDate))) {
            throw PlannedDateNotValidForPruningException.createDateIsNull();
        }
        if (!DateHelper.isLocalDateAfterOrEquals(plannedDate)) {
            throw PlannedDateNotValidForPruningException.createDateInPast();
        }
        if (!DateHelper.isLocalDateBefore(plannedDate, horizonMonths)) {
            throw PlannedDateNotValidForPruningException.createDateBeyondHorizon();
        }
    }

    /** Cuadrilla obligatoria. */
    public static void validateQuadrille(UUID quadrille) {
        if (UUIDHelper.isDefaultUUID(UUIDHelper.getDefault(quadrille))) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.QUADRILLE_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.QUADRILLE_REQUIRED");
        }
    }

    /**
     * Registro fotografico opcional.
     * Si viene, valida que las keys no superen el limite de texto corto.
     */
    public static void validatePhotographicRecordPath(String photographicRecordPath) {
        if (TextHelper.isEmptyWithTrim(photographicRecordPath)) {
            return;
        }
        if (!TextHelper.lengthIsValidWithTrim(photographicRecordPath,
                CrossCuttingConstants.SHORT_TEXT_MIN_LENGTH,
                CrossCuttingConstants.SHORT_TEXT_MAX_LENGTH)) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.PHOTO_TOO_LONG",
                    "TECHNICAL.VALIDATION.PRUNING.PHOTO_TOO_LONG");
        }
    }

    // ── Validacion de archivo de foto (usado por UploadPruningPhotoController) ──

    private static final long PHOTO_MAX_SIZE_BYTES = 5L * 1024L * 1024L;

    public static void validatePhoto(byte[] bytes, String contentType) {
        if (bytes == null || bytes.length == 0) {
            return;
        }
        if (bytes.length > PHOTO_MAX_SIZE_BYTES) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.PHOTO_MAX_SIZE",
                    "TECHNICAL.VALIDATION.PRUNING.PHOTO_MAX_SIZE",
                    Map.of("size", bytes.length));
        }
        if (!isAllowedImageMime(contentType)) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.PHOTO_INVALID_FORMAT",
                    "TECHNICAL.VALIDATION.PRUNING.PHOTO_INVALID_FORMAT",
                    Map.of("contentType", contentType != null ? contentType : "null"));
        }
    }

    private static boolean isAllowedImageMime(String contentType) {
        if (contentType == null) return false;
        String ct = contentType.toLowerCase();
        return "image/jpeg".equals(ct)
            || "image/jpg".equals(ct)
            || "image/png".equals(ct)
            || "image/webp".equals(ct);
    }
}
