package co.edu.uco.treepruning.features.pqr.submitpqr.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.UUID;

public record SubmitPQRRequest(
        LocalDate date,
        UUID status,
        UUID risk,
        UUID sector,
        UUID person,
        String photographicRecordPath) {
}
