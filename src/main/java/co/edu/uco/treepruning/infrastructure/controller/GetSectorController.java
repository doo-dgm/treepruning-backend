package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.GetSectorByFilterInputPort;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Sectores", description = "Consulta de sectores geograficos del municipio")
@RestController
@RequestMapping("/api/v1/sectors")
public class GetSectorController {

    private final GetSectorByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetSectorController(GetSectorByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar sectores", description = "Retorna sectores que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetSectorDTO>>> getByFilter(
            @Parameter(description = "Identificador unico del sector") @RequestParam(required = false) UUID id,
            @Parameter(description = "Nombre del sector (busqueda parcial)") @RequestParam(required = false) String name) {
        List<GetSectorDTO> results = inputPort.execute(new GetSectorDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.SECTOR.LIST"), results));
    }

    @Operation(summary = "Obtener sector por ID", description = "Retorna el detalle de un sector dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetSectorDTO>> getById(
            @Parameter(description = "Identificador unico del sector") @PathVariable UUID id) {
        List<GetSectorDTO> results = inputPort.execute(new GetSectorDTO(id, TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Sector", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.SECTOR.GET"), results.get(0)));
    }
}
