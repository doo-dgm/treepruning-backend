package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

public record SchedulePreventivePruningRequest(

        @Schema(description = "UUIDs de los arboles a intervenir (1 a 50).", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "[\"550e8400-e29b-41d4-a716-446655440001\"]")
        List<UUID> trees,

        @Schema(description = "Fecha planeada (yyyy-MM-dd). Debe ser hoy o futura.", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "2025-06-15")
        LocalDate plannedDate,

        @Schema(description = "UUID de la cuadrilla asignada.", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "550e8400-e29b-41d4-a716-446655440002")
        UUID quadrille,

        @Schema(description = "Key(s) de MinIO de las fotos. Multiples keys separadas por coma sin espacios. Opcional.",
                example = "2026/05/userId/a.jpg,2026/05/userId/b.jpg",
                nullable = true)
        String photographicRecordPath,

        @Schema(description = "Observaciones libres. Opcional.", nullable = true,
                example = "Arbol con ramas sobre cableado electrico")
        String observations

) {
}
