package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.inputport.AssignQuadrilleToPruningInputPort;
import co.edu.uco.treepruning.features.pruning.assignquadrilletopruning.application.inputport.dto.AssignQuadrilleToPruningDTO;
import co.edu.uco.treepruning.features.pruning.deletepruning.application.inputport.DeletePruningInputPort;
import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.inputport.RegisterPruningExecutionInputPort;
import co.edu.uco.treepruning.features.pruning.registerpruningexecution.application.inputport.dto.RegisterPruningExecutionDTO;
import co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.inputport.ScheduleCorrectivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulecorrectivepruning.application.inputport.dto.ScheduleCorrectivePruningDTO;
import co.edu.uco.treepruning.features.pruning.updatepruning.application.inputport.UpdatePruningInputPort;
import co.edu.uco.treepruning.features.pruning.updatepruning.application.inputport.dto.UpdatePruningDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.AssignQuadrilleToPruningRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.RegisterPruningExecutionRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.ScheduleCorrectivePruningRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdatePruningRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Podas", description = "Gestion de poda")
@RestController
@RequestMapping("/api/v1/prunings")
public class ManagePruningController {

    private final UpdatePruningInputPort updatePruningInputPort;
    private final DeletePruningInputPort deletePruningInputPort;
    private final ScheduleCorrectivePruningInputPort scheduleCorrectivePruningInputPort;
    private final RegisterPruningExecutionInputPort registerPruningExecutionInputPort;
    private final AssignQuadrilleToPruningInputPort assignQuadrilleToPruningInputPort;
    private final MessageCatalogService catalog;

    public ManagePruningController(
            UpdatePruningInputPort updatePruningInputPort,
            DeletePruningInputPort deletePruningInputPort,
            ScheduleCorrectivePruningInputPort scheduleCorrectivePruningInputPort,
            RegisterPruningExecutionInputPort registerPruningExecutionInputPort,
            AssignQuadrilleToPruningInputPort assignQuadrilleToPruningInputPort,
            MessageCatalogService catalog) {
        this.updatePruningInputPort = updatePruningInputPort;
        this.deletePruningInputPort = deletePruningInputPort;
        this.scheduleCorrectivePruningInputPort = scheduleCorrectivePruningInputPort;
        this.registerPruningExecutionInputPort = registerPruningExecutionInputPort;
        this.assignQuadrilleToPruningInputPort = assignQuadrilleToPruningInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Actualizar poda")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updatePruning(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdatePruningRequest request) {
        updatePruningInputPort.execute(new UpdatePruningDTO(id, request.status(), request.plannedDate(), request.executedDate(), request.tree(), request.quadrille(), request.type(), request.pqr(), request.photographicRecordPath(), request.observations()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNING.UPDATED"), null));
    }

    @Operation(summary = "Eliminar poda")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePruning(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deletePruningInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNING.DELETED"), null));
    }

    @Operation(summary = "Programar una poda correctiva a partir de una PQR")
    @PostMapping("/corrective")
    public ResponseEntity<ApiResponse<Void>> scheduleCorrectivePruning(
            @RequestBody ScheduleCorrectivePruningRequest request) {
        scheduleCorrectivePruningInputPort.execute(new ScheduleCorrectivePruningDTO(request.pqr(), request.tree(), request.plannedDate(), request.quadrille(), request.type()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNING.UPDATED"), null));
    }

    @Operation(summary = "Registrar la ejecucion de una poda")
    @PostMapping("/{id}/execution")
    public ResponseEntity<ApiResponse<Void>> registerPruningExecution(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody RegisterPruningExecutionRequest request) {
        registerPruningExecutionInputPort.execute(new RegisterPruningExecutionDTO(id, request.executedDate(), request.photographicRecordPath(), request.observations()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNING.UPDATED"), null));
    }

    @Operation(summary = "Asignar una cuadrilla a una poda")
    @PatchMapping("/{id}/quadrille")
    public ResponseEntity<ApiResponse<Void>> assignQuadrilleToPruning(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody AssignQuadrilleToPruningRequest request) {
        assignQuadrilleToPruningInputPort.execute(new AssignQuadrilleToPruningDTO(id, request.quadrille()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PRUNING.UPDATED"), null));
    }
}
