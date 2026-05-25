package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.GetQuadrilleByFilterInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cuadrillas", description = "Consulta de cuadrillas de trabajo asignadas a podas")
@RestController
@RequestMapping("/api/v1/quadrilles")
public class GetQuadrilleController {

    private final GetQuadrilleByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetQuadrilleController(GetQuadrilleByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar cuadrillas", description = "Retorna cuadrillas que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetQuadrilleDTO>>> getByFilter(
            @Parameter(description = "Identificador unico de la cuadrilla") @RequestParam(required = false) UUID id,
            @Parameter(description = "Nombre de la cuadrilla (busqueda parcial)") @RequestParam(required = false) String quadrilleName,
            @Parameter(description = "Identificador del gestor responsable") @RequestParam(required = false) UUID managerId) {
        List<GetQuadrilleDTO> results = inputPort.execute(
                new GetQuadrilleDTO(id, quadrilleName, new GetManagerDTO(managerId)));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.QUADRILLE.LIST"), results));
    }

    @Operation(summary = "Obtener cuadrilla por ID", description = "Retorna el detalle de una cuadrilla dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetQuadrilleDTO>> getById(
            @Parameter(description = "Identificador unico de la cuadrilla") @PathVariable UUID id) {
        List<GetQuadrilleDTO> results = inputPort.execute(new GetQuadrilleDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Quadrille", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.QUADRILLE.GET"), results.get(0)));
    }
}
