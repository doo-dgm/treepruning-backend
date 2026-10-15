package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record ScheduleCorrectivePruningRequest(
        UUID pqr,
        UUID tree,
        LocalDate plannedDate,
        UUID quadrille,
        UUID type
) {
}
