package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.family.createfamily.application.inputport.CreateFamilyInputPort;
import co.edu.uco.treepruning.features.family.createfamily.application.inputport.dto.CreateFamilyDTO;
import co.edu.uco.treepruning.features.family.deletefamily.application.inputport.DeleteFamilyInputPort;
import co.edu.uco.treepruning.features.family.updatefamily.application.inputport.UpdateFamilyInputPort;
import co.edu.uco.treepruning.features.family.updatefamily.application.inputport.dto.UpdateFamilyDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateFamilyRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateFamilyRequest;
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

@Tag(name = "Familias", description = "Gestion de familia de arboles")
@RestController
@RequestMapping("/api/v1/families")
public class ManageFamilyController {

    private final CreateFamilyInputPort createFamilyInputPort;
    private final UpdateFamilyInputPort updateFamilyInputPort;
    private final DeleteFamilyInputPort deleteFamilyInputPort;
    private final MessageCatalogService catalog;

    public ManageFamilyController(
            CreateFamilyInputPort createFamilyInputPort,
            UpdateFamilyInputPort updateFamilyInputPort,
            DeleteFamilyInputPort deleteFamilyInputPort,
            MessageCatalogService catalog) {
        this.createFamilyInputPort = createFamilyInputPort;
        this.updateFamilyInputPort = updateFamilyInputPort;
        this.deleteFamilyInputPort = deleteFamilyInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar familia de arboles")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createFamily(
            @RequestBody CreateFamilyRequest request) {
        createFamilyInputPort.execute(new CreateFamilyDTO(request.scientificName(), request.commonName()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.FAMILY.CREATED"), null));
    }

    @Operation(summary = "Actualizar familia de arboles")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateFamily(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateFamilyRequest request) {
        updateFamilyInputPort.execute(new UpdateFamilyDTO(id, request.scientificName(), request.commonName()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.FAMILY.UPDATED"), null));
    }

    @Operation(summary = "Eliminar familia de arboles")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteFamily(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteFamilyInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.FAMILY.DELETED"), null));
    }
}
