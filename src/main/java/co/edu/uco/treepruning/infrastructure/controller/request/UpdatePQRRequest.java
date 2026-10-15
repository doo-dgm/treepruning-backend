package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record UpdatePQRRequest(
        LocalDate date,
        UUID status,
        UUID risk,
        UUID sector,
        UUID person,
        String photographicRecordPath
) {
}
