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
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.GetTypeByFilterInputPort;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Tipos de poda", description = "Consulta de tipos de intervencion de poda disponibles")
@RestController
@RequestMapping("/api/v1/types")
public class GetTypeController {

    private final GetTypeByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetTypeController(GetTypeByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar tipos de poda", description = "Retorna tipos de poda que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTypeDTO>>> getByFilter(
            @Parameter(description = "Identificador unico del tipo de poda") @RequestParam(required = false) UUID id,
            @Parameter(description = "Nombre del tipo (busqueda parcial)") @RequestParam(required = false) String name) {
        List<GetTypeDTO> results = inputPort.execute(new GetTypeDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TYPE.LIST"), results));
    }

    @Operation(summary = "Obtener tipo de poda por ID", description = "Retorna el detalle de un tipo de poda dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetTypeDTO>> getById(
            @Parameter(description = "Identificador unico del tipo de poda") @PathVariable UUID id) {
        List<GetTypeDTO> results = inputPort.execute(new GetTypeDTO(id, null));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Type", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.TYPE.GET"), results.get(0)));
    }
}
