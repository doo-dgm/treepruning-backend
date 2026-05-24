package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator;

import java.time.LocalDate;
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
            throw TreePruningException.create(
                    "El estado de la poda es obligatorio.",
                    "SchedulePreventivePruningDTO.status: null or default UUID");
        }
    }

    public static void validatePlannedDate(LocalDate plannedDate,int horizonMonths) {
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
        // executedDate is optional when scheduling — only validate if explicitly set
        // (i.e. not the default sentinel applied by the DTO setter).
        if (DateHelper.isDefaultDate(executedDate)) {
            return;
        }
        if (executedDate.isBefore(plannedDate)) {
            throw TreePruningException.create(
                    "La fecha de ejecución no puede ser anterior a la fecha programada.",
                    "SchedulePreventivePruningDTO.executedDate: before plannedDate");
        }
    }

    public static void validateTree(UUID tree) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(tree))) {
            throw TreePruningException.create(
                    "El árbol a intervenir es obligatorio.",
                    "SchedulePreventivePruningDTO.tree: null or default UUID");
        }
    }

    public static void validateQuadrille(UUID quadrille) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(quadrille))) {
            throw TreePruningException.create(
                    "La cuadrilla asignada es obligatoria.",
                    "SchedulePreventivePruningDTO.quadrille: null or default UUID");
        }
    }

    public static void validateType(UUID type) {
        if (UUIDHelper.isDefaultUUID(
                UUIDHelper.getDefault(type))) {
            throw TreePruningException.create(
                    "El tipo de poda es obligatorio.",
                    "SchedulePreventivePruningDTO.type: null or default UUID");
        }
    }

    /**
     * El registro fotográfico es opcional al programar una poda preventiva:
     * la foto se sube luego al ejecutar la poda en campo. Si está presente,
     * solo se valida que el largo de la key sea razonable.
     */
    public static void validatePhotographicRecordPath(String photographicRecordPath) {
        if (TextHelper.isEmptyWithTrim(photographicRecordPath)) {
            return;
        }
        if (!TextHelper.lengthIsValidWithTrim(photographicRecordPath,
                CrossCuttingConstants.SHORT_TEXT_MIN_LENGTH,
                CrossCuttingConstants.SHORT_TEXT_MAX_LENGTH)) {
            throw TreePruningException.create(
                    "La ruta del registro fotográfico no puede superar los 500 caracteres.",
                    "SchedulePreventivePruningDTO.photographicRecordPath: exceeds 500 characters");
        }
    }

    private static final long PHOTO_MAX_SIZE_BYTES = 5L * 1024L * 1024L;

    public static void validatePhoto(byte[] bytes, String contentType) {
        if (bytes == null || bytes.length == 0) {
            return;
        }
        if (bytes.length > PHOTO_MAX_SIZE_BYTES) {
            throw TreePruningException.create(
                    "La fotografía supera el tamaño máximo permitido de 5 MB.",
                    "SchedulePreventivePruningDTO.photo: size=" + bytes.length + " bytes");
        }
        if (!isAllowedImageMime(contentType)) {
            throw TreePruningException.create(
                    "Formato de imagen no soportado. Use JPEG, PNG o WebP.",
                    "SchedulePreventivePruningDTO.photo: contentType=" + contentType);
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
            throw TreePruningException.create(
                    "Las observaciones de la poda son obligatorias.",
                    "SchedulePreventivePruningDTO.observations: null or empty");
        }
        if (!TextHelper.lengthIsValidWithTrim(observations,
                CrossCuttingConstants.OBSERVATIONS_MIN_LENGTH,
                CrossCuttingConstants.OBSERVATIONS_MAX_LENGTH)) {
            throw TreePruningException.create(
                    "Las observaciones deben tener entre 10 y 500 caracteres.",
                    "SchedulePreventivePruningDTO.observations: length out of range [10, 500]");
        }
    }
}
