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
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.GetTreeByFilterInputPort;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Arboles", description = "Consulta del inventario de arboles urbanos del municipio")
@RestController
@RequestMapping("/api/v1/trees")
public class GetTreeController {

    private final GetTreeByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetTreeController(GetTreeByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar arboles", description = "Retorna arboles que coincidan con los filtros opcionales de familia botanica o sector.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTreeDTO>>> getByFilter(
            @Parameter(description = "Identificador unico del arbol") @RequestParam(required = false) UUID id,
            @Parameter(description = "Identificador de la familia botanica") @RequestParam(required = false) UUID familyId,
            @Parameter(description = "Identificador del sector geografico") @RequestParam(required = false) UUID sectorId) {
        List<GetTreeDTO> results = inputPort.execute(
                new GetTreeDTO(id, null, null, new GetFamilyDTO(familyId), new GetSectorDTO(sectorId), null));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TREE.LIST"), results));
    }

    @Operation(summary = "Obtener arbol por ID", description = "Retorna el detalle de un arbol dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetTreeDTO>> getById(
            @Parameter(description = "Identificador unico del arbol") @PathVariable UUID id) {
        List<GetTreeDTO> results = inputPort.execute(new GetTreeDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Tree", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TREE.GET"), results.get(0)));
    }
}
