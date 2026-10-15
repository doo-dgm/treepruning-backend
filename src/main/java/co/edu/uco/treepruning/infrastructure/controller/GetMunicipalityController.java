package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.GetMunicipalityByFilterInputPort;
import co.edu.uco.treepruning.features.municipality.getmunicipalitybyfilter.application.inputport.dto.GetMunicipalityDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Municipios", description = "Consulta de municipio")
@RestController
@RequestMapping("/api/v1/municipalities")
public class GetMunicipalityController {

    private final GetMunicipalityByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetMunicipalityController(GetMunicipalityByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar municipios",
            description = "Retorna los registros de municipio que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetMunicipalityDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "name") @RequestParam(required = false) String name,
            @Parameter(description = "state") @RequestParam(required = false) UUID state) {
        List<GetMunicipalityDTO> results = inputPort.execute(new GetMunicipalityDTO(id, name, state));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.MUNICIPALITY.LIST"), results));
    }

    @Operation(summary = "Obtener municipio por ID",
            description = "Retorna el detalle de un municipio. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetMunicipalityDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetMunicipalityDTO> results = inputPort.execute(new GetMunicipalityDTO(id, TextHelper.getDefault(), UUIDHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Municipality", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.MUNICIPALITY.GET"), results.get(0)));
    }
}
