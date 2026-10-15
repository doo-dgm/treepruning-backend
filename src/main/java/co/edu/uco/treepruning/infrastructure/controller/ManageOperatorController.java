package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.operator.createoperator.application.inputport.CreateOperatorInputPort;
import co.edu.uco.treepruning.features.operator.createoperator.application.inputport.dto.CreateOperatorDTO;
import co.edu.uco.treepruning.features.operator.deleteoperator.application.inputport.DeleteOperatorInputPort;
import co.edu.uco.treepruning.features.operator.updateoperator.application.inputport.UpdateOperatorInputPort;
import co.edu.uco.treepruning.features.operator.updateoperator.application.inputport.dto.UpdateOperatorDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateOperatorRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateOperatorRequest;
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

@Tag(name = "Operarios", description = "Gestion de operario")
@RestController
@RequestMapping("/api/v1/operators")
public class ManageOperatorController {

    private final CreateOperatorInputPort createOperatorInputPort;
    private final UpdateOperatorInputPort updateOperatorInputPort;
    private final DeleteOperatorInputPort deleteOperatorInputPort;
    private final MessageCatalogService catalog;

    public ManageOperatorController(
            CreateOperatorInputPort createOperatorInputPort,
            UpdateOperatorInputPort updateOperatorInputPort,
            DeleteOperatorInputPort deleteOperatorInputPort,
            MessageCatalogService catalog) {
        this.createOperatorInputPort = createOperatorInputPort;
        this.updateOperatorInputPort = updateOperatorInputPort;
        this.deleteOperatorInputPort = deleteOperatorInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar operario")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createOperator(
            @RequestBody CreateOperatorRequest request) {
        createOperatorInputPort.execute(new CreateOperatorDTO(request.person(), request.quadrille()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.OPERATOR.CREATED"), null));
    }

    @Operation(summary = "Actualizar operario")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateOperator(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateOperatorRequest request) {
        updateOperatorInputPort.execute(new UpdateOperatorDTO(id, request.person(), request.quadrille()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.OPERATOR.UPDATED"), null));
    }

    @Operation(summary = "Eliminar operario")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOperator(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteOperatorInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.OPERATOR.DELETED"), null));
    }
}
