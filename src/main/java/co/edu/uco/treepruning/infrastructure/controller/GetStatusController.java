package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.GetStatusByFilterInputPort;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Estados", description = "Consulta de estados del ciclo de vida de una poda")
@RestController
@RequestMapping("/api/v1/statuses")
public class GetStatusController {

    private final GetStatusByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetStatusController(GetStatusByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar estados", description = "Retorna estados que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetStatusDTO>>> getByFilter(
            @Parameter(description = "Identificador unico del estado") @RequestParam(required = false) UUID id,
            @Parameter(description = "Nombre del estado (busqueda parcial)") @RequestParam(required = false) String name) {
        List<GetStatusDTO> results = inputPort.execute(new GetStatusDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.STATUS.LIST"), results));
    }

    @Operation(summary = "Obtener estado por ID", description = "Retorna el detalle de un estado dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetStatusDTO>> getById(
            @Parameter(description = "Identificador unico del estado") @PathVariable UUID id) {
        List<GetStatusDTO> results = inputPort.execute(new GetStatusDTO(id, TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Status", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.STATUS.GET"), results.get(0)));
    }
}
