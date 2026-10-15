package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.administrator.createadministrator.application.inputport.CreateAdministratorInputPort;
import co.edu.uco.treepruning.features.administrator.createadministrator.application.inputport.dto.CreateAdministratorDTO;
import co.edu.uco.treepruning.features.administrator.deleteadministrator.application.inputport.DeleteAdministratorInputPort;
import co.edu.uco.treepruning.features.administrator.updateadministrator.application.inputport.UpdateAdministratorInputPort;
import co.edu.uco.treepruning.features.administrator.updateadministrator.application.inputport.dto.UpdateAdministratorDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateAdministratorRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateAdministratorRequest;
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

@Tag(name = "Administradores", description = "Gestion de administrador")
@RestController
@RequestMapping("/api/v1/administrators")
public class ManageAdministratorController {

    private final CreateAdministratorInputPort createAdministratorInputPort;
    private final UpdateAdministratorInputPort updateAdministratorInputPort;
    private final DeleteAdministratorInputPort deleteAdministratorInputPort;
    private final MessageCatalogService catalog;

    public ManageAdministratorController(
            CreateAdministratorInputPort createAdministratorInputPort,
            UpdateAdministratorInputPort updateAdministratorInputPort,
            DeleteAdministratorInputPort deleteAdministratorInputPort,
            MessageCatalogService catalog) {
        this.createAdministratorInputPort = createAdministratorInputPort;
        this.updateAdministratorInputPort = updateAdministratorInputPort;
        this.deleteAdministratorInputPort = deleteAdministratorInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar administrador")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createAdministrator(
            @RequestBody CreateAdministratorRequest request) {
        createAdministratorInputPort.execute(new CreateAdministratorDTO(request.username(), request.email(), request.emailConfirmed(), request.phone(), request.phoneConfirmed()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.ADMINISTRATOR.CREATED"), null));
    }

    @Operation(summary = "Actualizar administrador")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateAdministrator(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateAdministratorRequest request) {
        updateAdministratorInputPort.execute(new UpdateAdministratorDTO(id, request.username(), request.email(), request.emailConfirmed(), request.phone(), request.phoneConfirmed()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.ADMINISTRATOR.UPDATED"), null));
    }

    @Operation(summary = "Eliminar administrador")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAdministrator(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteAdministratorInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.ADMINISTRATOR.DELETED"), null));
    }
}
