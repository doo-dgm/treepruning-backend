package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.inputport.AssignPQRRiskInputPort;
import co.edu.uco.treepruning.features.pqr.assignpqrrisk.application.inputport.dto.AssignPQRRiskDTO;
import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.inputport.ChangePQRStatusInputPort;
import co.edu.uco.treepruning.features.pqr.changepqrstatus.application.inputport.dto.ChangePQRStatusDTO;
import co.edu.uco.treepruning.features.pqr.deletepqr.application.inputport.DeletePQRInputPort;
import co.edu.uco.treepruning.features.pqr.updatepqr.application.inputport.UpdatePQRInputPort;
import co.edu.uco.treepruning.features.pqr.updatepqr.application.inputport.dto.UpdatePQRDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.AssignPQRRiskRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.ChangePQRStatusRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdatePQRRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PQRs", description = "Gestion de PQR")
@RestController
@RequestMapping("/api/v1/pqrs")
public class ManagePQRController {

    private final UpdatePQRInputPort updatePQRInputPort;
    private final DeletePQRInputPort deletePQRInputPort;
    private final ChangePQRStatusInputPort changePQRStatusInputPort;
    private final AssignPQRRiskInputPort assignPQRRiskInputPort;
    private final MessageCatalogService catalog;

    public ManagePQRController(
            UpdatePQRInputPort updatePQRInputPort,
            DeletePQRInputPort deletePQRInputPort,
            ChangePQRStatusInputPort changePQRStatusInputPort,
            AssignPQRRiskInputPort assignPQRRiskInputPort,
            MessageCatalogService catalog) {
        this.updatePQRInputPort = updatePQRInputPort;
        this.deletePQRInputPort = deletePQRInputPort;
        this.changePQRStatusInputPort = changePQRStatusInputPort;
        this.assignPQRRiskInputPort = assignPQRRiskInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Actualizar PQR")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updatePQR(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdatePQRRequest request) {
        updatePQRInputPort.execute(new UpdatePQRDTO(id, request.date(), request.status(), request.risk(), request.sector(), request.person(), request.photographicRecordPath()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PQR.UPDATED"), null));
    }

    @Operation(summary = "Eliminar PQR")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePQR(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deletePQRInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PQR.DELETED"), null));
    }

    @Operation(summary = "Cambiar el estado de una PQR")
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Void>> changePQRStatus(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody ChangePQRStatusRequest request) {
        changePQRStatusInputPort.execute(new ChangePQRStatusDTO(id, request.status()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PQR.UPDATED"), null));
    }

    @Operation(summary = "Asignar el riesgo de una PQR")
    @PatchMapping("/{id}/risk")
    public ResponseEntity<ApiResponse<Void>> assignPQRRisk(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody AssignPQRRiskRequest request) {
        assignPQRRiskInputPort.execute(new AssignPQRRiskDTO(id, request.risk()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PQR.UPDATED"), null));
    }
}
