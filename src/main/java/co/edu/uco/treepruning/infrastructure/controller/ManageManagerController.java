package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.manager.createmanager.application.inputport.CreateManagerInputPort;
import co.edu.uco.treepruning.features.manager.createmanager.application.inputport.dto.CreateManagerDTO;
import co.edu.uco.treepruning.features.manager.deletemanager.application.inputport.DeleteManagerInputPort;
import co.edu.uco.treepruning.features.manager.updatemanager.application.inputport.UpdateManagerInputPort;
import co.edu.uco.treepruning.features.manager.updatemanager.application.inputport.dto.UpdateManagerDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateManagerRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateManagerRequest;
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

@Tag(name = "Encargados", description = "Gestion de encargado")
@RestController
@RequestMapping("/api/v1/managers")
public class ManageManagerController {

    private final CreateManagerInputPort createManagerInputPort;
    private final UpdateManagerInputPort updateManagerInputPort;
    private final DeleteManagerInputPort deleteManagerInputPort;
    private final MessageCatalogService catalog;

    public ManageManagerController(
            CreateManagerInputPort createManagerInputPort,
            UpdateManagerInputPort updateManagerInputPort,
            DeleteManagerInputPort deleteManagerInputPort,
            MessageCatalogService catalog) {
        this.createManagerInputPort = createManagerInputPort;
        this.updateManagerInputPort = updateManagerInputPort;
        this.deleteManagerInputPort = deleteManagerInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar encargado")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createManager(
            @RequestBody CreateManagerRequest request) {
        createManagerInputPort.execute(new CreateManagerDTO(request.person()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.MANAGER.CREATED"), null));
    }

    @Operation(summary = "Actualizar encargado")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateManager(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateManagerRequest request) {
        updateManagerInputPort.execute(new UpdateManagerDTO(id, request.person()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.MANAGER.UPDATED"), null));
    }

    @Operation(summary = "Eliminar encargado")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteManager(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteManagerInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.MANAGER.DELETED"), null));
    }
}
