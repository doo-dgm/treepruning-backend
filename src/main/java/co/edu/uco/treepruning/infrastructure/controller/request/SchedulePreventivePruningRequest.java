package co.edu.uco.treepruning.infrastructure.controller.request;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

public record SchedulePreventivePruningRequest(

        @Schema(
            description = "Lista de UUIDs de los arboles a intervenir (1 a 50).",
            example = "[\"550e8400-e29b-41d4-a716-446655440001\"]"
        )
        List<UUID> trees,

        @Schema(description = "Fecha programada de la poda (yyyy-MM-dd)", example = "2025-06-15")
        LocalDate plannedDate,

        @Schema(description = "UUID de la cuadrilla asignada", example = "550e8400-e29b-41d4-a716-446655440002")
        UUID quadrille,

        @Schema(
            description = "Keys de MinIO de las fotos de evidencia, obtenidas subiendo cada imagen a POST /api/v1/photos. "
                + "Una foto: '2026/05/{userId}/uuid.jpg'. "
                + "Varias fotos: separar con coma sin espacios: '2026/05/{userId}/a.jpg,2026/05/{userId}/b.jpg'. "
                + "Null o ausente si no hay fotos.",
            example = "2026/05/550e8400-e29b-41d4-a716-446655440000/3f2504e0-4f89-11d3-9a0c-0305e82c3301.jpg",
            nullable = true
        )
        String photographicRecordPath,

        @Schema(description = "Observaciones libres sobre la poda. Null o ausente si no aplica.", nullable = true)
        String observations

) {
}
