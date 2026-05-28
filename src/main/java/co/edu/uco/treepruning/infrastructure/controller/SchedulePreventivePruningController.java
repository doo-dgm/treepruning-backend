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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// Nota: io.swagger.v3.oas.annotations.responses.ApiResponse comparte nombre
// con nuestra clase ApiResponse del paquete crosscutting.response, por eso
// se usa fully-qualified mas abajo. No es ruido evitable.

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
        description = "Crea una poda preventiva por cada arbol del lote (1 a 50). " +
                "Tipo y estado se resuelven en el backend, no se envian. " +
                "Para fotos: subir primero a POST /photos y usar la key (o keys separadas por coma) en photographicRecordPath."
    )
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "201",
                description  = "Podas creadas. data.count = numero de podas registradas."),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "400",
                description  = "Validacion fallida (arboles vacios, fecha pasada, foto > 5MB, etc.).",
                content      = @Content),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "401",
                description  = "JWT ausente o invalido.",
                content      = @Content),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "403",
                description  = "Rol sin permiso (requiere MANAGER o ADMIN).",
                content      = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Map<String, Object>>> schedule(
            @Parameter(description = "Datos del lote de podas a programar")
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
