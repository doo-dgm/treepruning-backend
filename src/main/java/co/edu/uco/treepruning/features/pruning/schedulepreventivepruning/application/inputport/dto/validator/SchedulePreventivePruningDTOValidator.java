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

    public static void validatePlannedDate(LocalDate plannedDate) {
        if (DateHelper.isDefaultDate(
                DateHelper.getDefault(plannedDate))) {
            throw PlannedDateNotValidForPruningException.createDateIsNull();
        }
        if (!DateHelper.isLocalDateAfterOrEquals(plannedDate)) {
            throw PlannedDateNotValidForPruningException.createDateInPast();
        }
        if (!DateHelper.isLocalDateBefore(plannedDate)) {
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

    public static void validatePhotographicRecordPath(String photographicRecordPath) {
        if (TextHelper.isEmptyWithTrim(photographicRecordPath)) {
            throw TreePruningException.create(
                    "El registro fotográfico de la poda es obligatorio.",
                    "SchedulePreventivePruningDTO.photographicRecordPath: null or empty");
        }
        if (!TextHelper.lengthIsValidWithTrim(photographicRecordPath,
                CrossCuttingConstants.SHORT_TEXT_MIN_LENGTH,
                CrossCuttingConstants.SHORT_TEXT_MAX_LENGTH)) {
            throw TreePruningException.create(
                    "La ruta del registro fotográfico no puede superar los 500 caracteres.",
                    "SchedulePreventivePruningDTO.photographicRecordPath: exceeds 500 characters");
        }
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
