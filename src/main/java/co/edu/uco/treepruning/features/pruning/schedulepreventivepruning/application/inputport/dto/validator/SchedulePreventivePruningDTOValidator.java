package co.edu.uco.treepruning.features.pruning
        .schedulepreventivepruning.application.inputport.dto.validator;

import java.time.LocalDate;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PlannedDateNotValidForPruningException;

public final class SchedulePreventivePruningDTOValidator {

    private SchedulePreventivePruningDTOValidator() {
    }

    public static void validateStatus(UUID status) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(status))) {
            throw TreePruningException.create(
                    "El estado de la poda es obligatorio.",
                    "SchedulePreventivePruningDTO.status: null or default UUID");
        }
    }

    public static void validatePlannedDate(LocalDate plannedDate) {
        if (DateHelper.getDateHelper().isDefaultDate(
                DateHelper.getDateHelper().getDefault(plannedDate))) {
            throw PlannedDateNotValidForPruningException.createDateIsNull();
        }
        if (!DateHelper.getDateHelper().isLocalDateAfterOrEquals(plannedDate)) {
            throw PlannedDateNotValidForPruningException.createDateInPast();
        }
    }

    public static void validateExecutedDate(LocalDate executedDate, LocalDate plannedDate) {
        if (executedDate != null &&
                !DateHelper.getDateHelper().isDefaultDate(executedDate)) {
            if (executedDate.isBefore(plannedDate)) {
                throw TreePruningException.create(
                        "La fecha de ejecución no puede ser anterior a la fecha programada.",
                        "SchedulePreventivePruningDTO.executedDate: before plannedDate");
            }
        }
    }

    public static void validateTree(UUID tree) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(tree))) {
            throw TreePruningException.create(
                    "El árbol a intervenir es obligatorio.",
                    "SchedulePreventivePruningDTO.tree: null or default UUID");
        }
    }

    public static void validateQuadrille(UUID quadrille) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(quadrille))) {
            throw TreePruningException.create(
                    "La cuadrilla asignada es obligatoria.",
                    "SchedulePreventivePruningDTO.quadrille: null or default UUID");
        }
    }

    public static void validateType(UUID type) {
        if (UUIDHelper.getUUIDHelper().isDefaultUUID(
                UUIDHelper.getUUIDHelper().getDefault(type))) {
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
        if (!TextHelper.lengthIsValidWithTrim(photographicRecordPath, 1, 500)) {
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
        if (!TextHelper.lengthIsValidWithTrim(observations, 10, 500)) {
            throw TreePruningException.create(
                    "Las observaciones deben tener entre 10 y 500 caracteres.",
                    "SchedulePreventivePruningDTO.observations: length out of range [10, 500]");
        }
    }
}
