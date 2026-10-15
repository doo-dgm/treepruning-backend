package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;

public record UpdateProgrammingRequest(
        LocalDate initialDate,
        int frequencyMonths,
        int amount
) {
}
