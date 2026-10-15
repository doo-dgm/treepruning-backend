package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.GetToolByFilterInputPort;
import co.edu.uco.treepruning.features.tool.gettoolbyfilter.application.inputport.dto.GetToolDTO;
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

@Tag(name = "Herramientas", description = "Consulta de herramienta")
@RestController
@RequestMapping("/api/v1/tools")
public class GetToolController {

    private final GetToolByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetToolController(GetToolByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar herramientas",
            description = "Retorna los registros de herramienta que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetToolDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "name") @RequestParam(required = false) String name,
            @Parameter(description = "description") @RequestParam(required = false) String description) {
        List<GetToolDTO> results = inputPort.execute(new GetToolDTO(id, name, description));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TOOL.LIST"), results));
    }

    @Operation(summary = "Obtener herramienta por ID",
            description = "Retorna el detalle de un herramienta. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetToolDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetToolDTO> results = inputPort.execute(new GetToolDTO(id, TextHelper.getDefault(), TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Tool", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TOOL.GET"), results.get(0)));
    }
}
