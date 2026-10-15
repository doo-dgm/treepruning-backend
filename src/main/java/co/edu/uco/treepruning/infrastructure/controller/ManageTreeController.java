package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.tree.createtree.application.inputport.CreateTreeInputPort;
import co.edu.uco.treepruning.features.tree.createtree.application.inputport.dto.CreateTreeDTO;
import co.edu.uco.treepruning.features.tree.deletetree.application.inputport.DeleteTreeInputPort;
import co.edu.uco.treepruning.features.tree.updatetree.application.inputport.UpdateTreeInputPort;
import co.edu.uco.treepruning.features.tree.updatetree.application.inputport.dto.UpdateTreeDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateTreeRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateTreeRequest;
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

@Tag(name = "Arboles", description = "Gestion de arbol")
@RestController
@RequestMapping("/api/v1/trees")
public class ManageTreeController {

    private final CreateTreeInputPort createTreeInputPort;
    private final UpdateTreeInputPort updateTreeInputPort;
    private final DeleteTreeInputPort deleteTreeInputPort;
    private final MessageCatalogService catalog;

    public ManageTreeController(
            CreateTreeInputPort createTreeInputPort,
            UpdateTreeInputPort updateTreeInputPort,
            DeleteTreeInputPort deleteTreeInputPort,
            MessageCatalogService catalog) {
        this.createTreeInputPort = createTreeInputPort;
        this.updateTreeInputPort = updateTreeInputPort;
        this.deleteTreeInputPort = deleteTreeInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar arbol")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createTree(
            @RequestBody CreateTreeRequest request) {
        createTreeInputPort.execute(new CreateTreeDTO(request.longitude(), request.latitude(), request.family(), request.sector(), request.programming()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.TREE.CREATED"), null));
    }

    @Operation(summary = "Actualizar arbol")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateTree(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateTreeRequest request) {
        updateTreeInputPort.execute(new UpdateTreeDTO(id, request.longitude(), request.latitude(), request.family(), request.sector(), request.programming()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TREE.UPDATED"), null));
    }

    @Operation(summary = "Eliminar arbol")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTree(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteTreeInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TREE.DELETED"), null));
    }
}
