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
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.GetManagerByFilterInputPort;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Gestores", description = "Consulta de gestores responsables de cuadrillas de poda")
@RestController
@RequestMapping("/api/v1/managers")
public class GetManagerController {

    private final GetManagerByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetManagerController(GetManagerByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar gestores", description = "Retorna todos los gestores registrados. Filtra opcionalmente por ID.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetManagerDTO>>> getByFilter(
            @Parameter(description = "Identificador unico del gestor") @RequestParam(required = false) UUID id) {
        List<GetManagerDTO> results = inputPort.execute(new GetManagerDTO(id));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.MANAGER.LIST"), results));
    }

    @Operation(summary = "Obtener gestor por ID", description = "Retorna el detalle de un gestor dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetManagerDTO>> getById(
            @Parameter(description = "Identificador unico del gestor") @PathVariable UUID id) {
        List<GetManagerDTO> results = inputPort.execute(new GetManagerDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Manager", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.MANAGER.GET"), results.get(0)));
    }
}
