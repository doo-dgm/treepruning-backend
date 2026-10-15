package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.inputport.CreatePruningToolInputPort;
import co.edu.uco.treepruning.features.pruningtool.createpruningtool.application.inputport.dto.CreatePruningToolDTO;
import co.edu.uco.treepruning.features.pruningtool.deletepruningtool.application.inputport.DeletePruningToolInputPort;
import co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.inputport.UpdatePruningToolInputPort;
import co.edu.uco.treepruning.features.pruningtool.updatepruningtool.application.inputport.dto.UpdatePruningToolDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreatePruningToolRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdatePruningToolRequest;
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

@Tag(name = "Herramientas de poda", description = "Gestion de herramienta usada en una poda")
@RestController
@RequestMapping("/api/v1/pruning-tools")
public class ManagePruningToolController {

    private final CreatePruningToolInputPort createPruningToolInputPort;
    private final UpdatePruningToolInputPort updatePruningToolInputPort;
    private final DeletePruningToolInputPort deletePruningToolInputPort;
    private final MessageCatalogService catalog;

    public ManagePruningToolController(
            CreatePruningToolInputPort createPruningToolInputPort,
            UpdatePruningToolInputPort updatePruningToolInputPort,
            DeletePruningToolInputPort deletePruningToolInputPort,
            MessageCatalogService catalog) {
        this.createPruningToolInputPort = createPruningToolInputPort;
        this.updatePruningToolInputPort = updatePruningToolInputPort;
        this.deletePruningToolInputPort = deletePruningToolInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar herramienta usada en una poda")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createPruningTool(
            @RequestBody CreatePruningToolRequest request) {
        createPruningToolInputPort.execute(new CreatePruningToolDTO(request.pruning(), request.tool()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.PRUNINGTOOL.CREATED"), null));
    }

    @Operation(summary = "Actualizar herramienta usada en una poda")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updatePruningTool(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdatePruningToolRequest request) {
        updatePruningToolInputPort.execute(new UpdatePruningToolDTO(id, request.pruning(), request.tool()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNINGTOOL.UPDATED"), null));
    }

    @Operation(summary = "Eliminar herramienta usada en una poda")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePruningTool(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deletePruningToolInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNINGTOOL.DELETED"), null));
    }
}
