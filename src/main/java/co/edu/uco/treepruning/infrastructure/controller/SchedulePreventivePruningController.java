package co.edu.uco.treepruning.infrastructure.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.SchedulePreventivePruningRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Podas", description = "Gestion y consulta de podas preventivas del arbolado urbano")
@RestController
@RequestMapping("/api/v1/prunings")
public class SchedulePreventivePruningController {

    private final SchedulePreventivePruningInputPort schedulePreventivePruningInputPort;
    private final MessageCatalogService catalog;

    public SchedulePreventivePruningController(
            SchedulePreventivePruningInputPort schedulePreventivePruningInputPort,
            MessageCatalogService catalog) {
        this.schedulePreventivePruningInputPort = schedulePreventivePruningInputPort;
        this.catalog = catalog;
    }

    @Operation(
        summary = "Programar podas preventivas",
        description = """
            Registra una poda preventiva por cada arbol de la lista. \
            El tipo ('Preventiva') y el estado ('Planeada') se resuelven automaticamente desde la BD; \
            el cliente NO los envia.

            **Flujo para adjuntar fotos:**
            1. Subir cada imagen a `POST /api/v1/photos` (multipart). Cada llamada retorna una key.
            2. Para una foto: usar la key directamente en `photographicRecordPath`.
            3. Para varias fotos: concatenar las keys separadas por coma sin espacios: \
            `2026/05/userId/a.jpg,2026/05/userId/b.jpg`.
            4. Sin fotos: omitir el campo o enviarlo como `null`."""
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Map<String, Object>>> schedule(
            @Parameter(description = "Datos de las podas en formato JSON")
            @RequestBody SchedulePreventivePruningRequest request) {

        int created = schedulePreventivePruningInputPort.execute(new SchedulePreventivePruningDTO(
                request.trees(),
                request.plannedDate(),
                request.quadrille(),
                request.photographicRecordPath(),
                request.observations()
        ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(
                        catalog.resolve("SUCCESS.PRUNING.SCHEDULED"),
                        Map.of("count", created)));
    }
}
