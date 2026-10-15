package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.tool.createtool.application.inputport.CreateToolInputPort;
import co.edu.uco.treepruning.features.tool.createtool.application.inputport.dto.CreateToolDTO;
import co.edu.uco.treepruning.features.tool.deletetool.application.inputport.DeleteToolInputPort;
import co.edu.uco.treepruning.features.tool.updatetool.application.inputport.UpdateToolInputPort;
import co.edu.uco.treepruning.features.tool.updatetool.application.inputport.dto.UpdateToolDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateToolRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateToolRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Herramientas", description = "Gestion de herramienta")
@RestController
@RequestMapping("/api/v1/tools")
public class ManageToolController {

    private final CreateToolInputPort createToolInputPort;
    private final UpdateToolInputPort updateToolInputPort;
    private final DeleteToolInputPort deleteToolInputPort;
    private final MessageCatalogService catalog;

    public ManageToolController(
            CreateToolInputPort createToolInputPort,
            UpdateToolInputPort updateToolInputPort,
            DeleteToolInputPort deleteToolInputPort,
            MessageCatalogService catalog) {
        this.createToolInputPort = createToolInputPort;
        this.updateToolInputPort = updateToolInputPort;
        this.deleteToolInputPort = deleteToolInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar herramienta")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createTool(
            @RequestBody CreateToolRequest request) {
        createToolInputPort.execute(new CreateToolDTO(request.name(), request.description()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.TOOL.CREATED"), null));
    }

    @Operation(summary = "Actualizar herramienta")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateTool(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateToolRequest request) {
        updateToolInputPort.execute(new UpdateToolDTO(id, request.name(), request.description()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TOOL.UPDATED"), null));
    }

    @Operation(summary = "Eliminar herramienta")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTool(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteToolInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TOOL.DELETED"), null));
    }
}
