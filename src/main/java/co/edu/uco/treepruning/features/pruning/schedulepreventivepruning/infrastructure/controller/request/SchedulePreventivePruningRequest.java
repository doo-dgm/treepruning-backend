package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record SchedulePreventivePruningRequest(
        UUID status,
        LocalDate plannedDate,
        LocalDate executedDate,
        UUID tree,
        UUID quadrille,
        UUID type,
        String photographicRecordPath,
        String observations) {
}
