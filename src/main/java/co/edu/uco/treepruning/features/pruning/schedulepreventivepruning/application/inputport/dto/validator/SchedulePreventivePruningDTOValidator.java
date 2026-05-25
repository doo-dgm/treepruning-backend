package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PlannedDateNotValidForPruningException;

public final class SchedulePreventivePruningDTOValidator {

    private SchedulePreventivePruningDTOValidator() {
    }

    public static void validateStatus(UUID status) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(status))) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.STATUS_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.STATUS_REQUIRED");
        }
    }

    public static void validatePlannedDate(LocalDate plannedDate, int horizonMonths) {
        if (DateHelper.isDefaultDate(
                DateHelper.getDefault(plannedDate))) {
            throw PlannedDateNotValidForPruningException.createDateIsNull();
        }
        if (!DateHelper.isLocalDateAfterOrEquals(plannedDate)) {
            throw PlannedDateNotValidForPruningException.createDateInPast();
        }
        if (!DateHelper.isLocalDateBefore(plannedDate, horizonMonths)) {
            throw PlannedDateNotValidForPruningException.createDateBeyondHorizon();
        }
    }

    public static void validateExecutedDate(LocalDate executedDate, LocalDate plannedDate) {
        // executedDate is optional when scheduling -- only validate if explicitly set
        // (i.e. not the default sentinel applied by the DTO setter).
        if (DateHelper.isDefaultDate(executedDate)) {
            return;
        }
        if (executedDate.isBefore(plannedDate)) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.EXECUTED_BEFORE_PLANNED",
                    "TECHNICAL.VALIDATION.PRUNING.EXECUTED_BEFORE_PLANNED");
        }
    }

    public static void validateTree(UUID tree) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(tree))) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.TREE_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.TREE_REQUIRED");
        }
    }

    public static void validateQuadrille(UUID quadrille) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(quadrille))) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.QUADRILLE_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.QUADRILLE_REQUIRED");
        }
    }

    public static void validateType(UUID type) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(type))) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.TYPE_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.TYPE_REQUIRED");
        }
    }

    /**
     * El registro fotografico es opcional al programar una poda preventiva:
     * la foto se sube luego al ejecutar la poda en campo. Si esta presente,
     * solo se valida que el largo de la key sea razonable.
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
        if (contentType == null) {
            return false;
        }
        String ct = contentType.toLowerCase();
        return "image/jpeg".equals(ct)
                || "image/jpg".equals(ct)
                || "image/png".equals(ct)
                || "image/webp".equals(ct);
    }

    public static void validateObservations(String observations) {
        if (TextHelper.isEmptyWithTrim(observations)) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.OBSERVATIONS_REQUIRED",
                    "TECHNICAL.VALIDATION.PRUNING.OBSERVATIONS_REQUIRED");
        }
        if (!TextHelper.lengthIsValidWithTrim(observations,
                CrossCuttingConstants.OBSERVATIONS_MIN_LENGTH,
                CrossCuttingConstants.OBSERVATIONS_MAX_LENGTH)) {
            throw TreePruningException.fromCode(
                    "USER.VALIDATION.PRUNING.OBSERVATIONS_LENGTH",
                    "TECHNICAL.VALIDATION.PRUNING.OBSERVATIONS_LENGTH");
        }
    }
}
