package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.quadrille.createquadrille.application.inputport.CreateQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.createquadrille.application.inputport.dto.CreateQuadrilleDTO;
import co.edu.uco.treepruning.features.quadrille.deletequadrille.application.inputport.DeleteQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.updatequadrille.application.inputport.UpdateQuadrilleInputPort;
import co.edu.uco.treepruning.features.quadrille.updatequadrille.application.inputport.dto.UpdateQuadrilleDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreateQuadrilleRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateQuadrilleRequest;
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

@Tag(name = "Cuadrillas", description = "Gestion de cuadrilla")
@RestController
@RequestMapping("/api/v1/quadrilles")
public class ManageQuadrilleController {

    private final CreateQuadrilleInputPort createQuadrilleInputPort;
    private final UpdateQuadrilleInputPort updateQuadrilleInputPort;
    private final DeleteQuadrilleInputPort deleteQuadrilleInputPort;
    private final MessageCatalogService catalog;

    public ManageQuadrilleController(
            CreateQuadrilleInputPort createQuadrilleInputPort,
            UpdateQuadrilleInputPort updateQuadrilleInputPort,
            DeleteQuadrilleInputPort deleteQuadrilleInputPort,
            MessageCatalogService catalog) {
        this.createQuadrilleInputPort = createQuadrilleInputPort;
        this.updateQuadrilleInputPort = updateQuadrilleInputPort;
        this.deleteQuadrilleInputPort = deleteQuadrilleInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar cuadrilla")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createQuadrille(
            @RequestBody CreateQuadrilleRequest request) {
        createQuadrilleInputPort.execute(new CreateQuadrilleDTO(request.quadrilleName(), request.manager()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.QUADRILLE.CREATED"), null));
    }

    @Operation(summary = "Actualizar cuadrilla")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateQuadrille(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateQuadrilleRequest request) {
        updateQuadrilleInputPort.execute(new UpdateQuadrilleDTO(id, request.quadrilleName(), request.manager()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.QUADRILLE.UPDATED"), null));
    }

    @Operation(summary = "Eliminar cuadrilla")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteQuadrille(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deleteQuadrilleInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.QUADRILLE.DELETED"), null));
    }
}
