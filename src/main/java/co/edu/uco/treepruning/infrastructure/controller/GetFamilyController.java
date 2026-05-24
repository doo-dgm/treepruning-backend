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
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.GetFamilyByFilterInputPort;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Familias botanicas", description = "Consulta de familias botanicas registradas en el sistema")
@RestController
@RequestMapping("/api/v1/families")
public class GetFamilyController {

    private final GetFamilyByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetFamilyController(GetFamilyByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar familias botanicas", description = "Retorna todas las familias botanicas que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetFamilyDTO>>> getByFilter(
            @Parameter(description = "Identificador unico de la familia") @RequestParam(required = false) UUID id,
            @Parameter(description = "Nombre comun (busqueda parcial)") @RequestParam(required = false) String commonName,
            @Parameter(description = "Nombre cientifico (busqueda parcial)") @RequestParam(required = false) String scientificName) {
        List<GetFamilyDTO> results = inputPort.execute(
                new GetFamilyDTO(id, commonName, scientificName));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.FAMILY.LIST"), results));
    }

    @Operation(summary = "Obtener familia botanica por ID", description = "Retorna el detalle de una familia botanica dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetFamilyDTO>> getById(
            @Parameter(description = "Identificador unico de la familia") @PathVariable UUID id) {
        List<GetFamilyDTO> results = inputPort.execute(new GetFamilyDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Family", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.FAMILY.GET"), results.get(0)));
    }
}
