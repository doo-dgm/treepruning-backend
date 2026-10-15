package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;

public record CreateProgrammingRequest(
        LocalDate initialDate,
        int frequencyMonths,
        int amount
) {
}
