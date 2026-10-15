package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;

public record RegisterPruningExecutionRequest(
        LocalDate executedDate,
        String photographicRecordPath,
        String observations
) {
}
