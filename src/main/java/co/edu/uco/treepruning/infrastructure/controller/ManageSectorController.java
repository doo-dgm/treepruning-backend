package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.sector.createsector.application.inputport.CreateSectorInputPort;
import co.edu.uco.treepruning.features.sector.createsector.application.inputport.dto.CreateSectorDTO;
import co.edu.uco.treepruning.features.sector.deletesector.application.inputport.DeleteSectorInputPort;
import co.edu.uco.treepruning.features.sector.updatesector.application.inputport.UpdateSectorInputPort;
import co.edu.uco.treepruning.features.sector.updatesector.application.inputport.dto.UpdateSectorDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateSectorRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateSectorRequest;
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

@Tag(name = "Sectores", description = "Gestion de sector")
@RestController
@RequestMapping("/api/v1/sectors")
public class ManageSectorController {

    private final CreateSectorInputPort createSectorInputPort;
    private final UpdateSectorInputPort updateSectorInputPort;
    private final DeleteSectorInputPort deleteSectorInputPort;
    private final MessageCatalogService catalog;

    public ManageSectorController(
            CreateSectorInputPort createSectorInputPort,
            UpdateSectorInputPort updateSectorInputPort,
            DeleteSectorInputPort deleteSectorInputPort,
            MessageCatalogService catalog) {
        this.createSectorInputPort = createSectorInputPort;
        this.updateSectorInputPort = updateSectorInputPort;
        this.deleteSectorInputPort = deleteSectorInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar sector")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createSector(
            @RequestBody CreateSectorRequest request) {
        createSectorInputPort.execute(new CreateSectorDTO(request.name(), request.municipality()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.SECTOR.CREATED"), null));
    }

    @Operation(summary = "Actualizar sector")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateSector(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateSectorRequest request) {
        updateSectorInputPort.execute(new UpdateSectorDTO(id, request.name(), request.municipality()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.SECTOR.UPDATED"), null));
    }

    @Operation(summary = "Eliminar sector")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSector(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteSectorInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.SECTOR.DELETED"), null));
    }
}
