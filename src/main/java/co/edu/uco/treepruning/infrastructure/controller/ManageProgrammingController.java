package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.programming.createprogramming.application.inputport.CreateProgrammingInputPort;
import co.edu.uco.treepruning.features.programming.createprogramming.application.inputport.dto.CreateProgrammingDTO;
import co.edu.uco.treepruning.features.programming.deleteprogramming.application.inputport.DeleteProgrammingInputPort;
import co.edu.uco.treepruning.features.programming.updateprogramming.application.inputport.UpdateProgrammingInputPort;
import co.edu.uco.treepruning.features.programming.updateprogramming.application.inputport.dto.UpdateProgrammingDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateProgrammingRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateProgrammingRequest;
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

@Tag(name = "Programaciones", description = "Gestion de programacion de poda")
@RestController
@RequestMapping("/api/v1/programmings")
public class ManageProgrammingController {

    private final CreateProgrammingInputPort createProgrammingInputPort;
    private final UpdateProgrammingInputPort updateProgrammingInputPort;
    private final DeleteProgrammingInputPort deleteProgrammingInputPort;
    private final MessageCatalogService catalog;

    public ManageProgrammingController(
            CreateProgrammingInputPort createProgrammingInputPort,
            UpdateProgrammingInputPort updateProgrammingInputPort,
            DeleteProgrammingInputPort deleteProgrammingInputPort,
            MessageCatalogService catalog) {
        this.createProgrammingInputPort = createProgrammingInputPort;
        this.updateProgrammingInputPort = updateProgrammingInputPort;
        this.deleteProgrammingInputPort = deleteProgrammingInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar programacion de poda")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createProgramming(
            @RequestBody CreateProgrammingRequest request) {
        createProgrammingInputPort.execute(new CreateProgrammingDTO(request.initialDate(), request.frequencyMonths(), request.amount()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.PROGRAMMING.CREATED"), null));
    }

    @Operation(summary = "Actualizar programacion de poda")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateProgramming(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateProgrammingRequest request) {
        updateProgrammingInputPort.execute(new UpdateProgrammingDTO(id, request.initialDate(), request.frequencyMonths(), request.amount()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PROGRAMMING.UPDATED"), null));
    }

    @Operation(summary = "Eliminar programacion de poda")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProgramming(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteProgrammingInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PROGRAMMING.DELETED"), null));
    }
}
