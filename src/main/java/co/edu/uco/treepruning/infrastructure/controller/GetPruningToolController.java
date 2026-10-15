package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.GetPruningToolByFilterInputPort;
import co.edu.uco.treepruning.features.pruningtool.getpruningtoolbyfilter.application.inputport.dto.GetPruningToolDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Herramientas de poda", description = "Consulta de herramienta usada en una poda")
@RestController
@RequestMapping("/api/v1/pruning-tools")
public class GetPruningToolController {

    private final GetPruningToolByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetPruningToolController(GetPruningToolByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar herramienta usada en una podas",
            description = "Retorna los registros de herramienta usada en una poda que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetPruningToolDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "pruning") @RequestParam(required = false) UUID pruning,
            @Parameter(description = "tool") @RequestParam(required = false) UUID tool) {
        List<GetPruningToolDTO> results = inputPort.execute(new GetPruningToolDTO(id, pruning, tool));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNINGTOOL.LIST"), results));
    }

    @Operation(summary = "Obtener herramienta usada en una poda por ID",
            description = "Retorna el detalle de un herramienta usada en una poda. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPruningToolDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetPruningToolDTO> results = inputPort.execute(new GetPruningToolDTO(id, UUIDHelper.getDefault(), UUIDHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("PruningTool", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNINGTOOL.GET"), results.get(0)));
    }
}
