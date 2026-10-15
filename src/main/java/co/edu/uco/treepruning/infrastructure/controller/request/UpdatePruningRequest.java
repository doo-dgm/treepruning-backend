package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record UpdatePruningRequest(
        UUID status,
        LocalDate plannedDate,
        LocalDate executedDate,
        UUID tree,
        UUID quadrille,
        UUID type,
        UUID pqr,
        String photographicRecordPath,
        String observations
) {
}
