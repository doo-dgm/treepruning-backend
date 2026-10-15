package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.GetStateByFilterInputPort;
import co.edu.uco.treepruning.features.state.getstatebyfilter.application.inputport.dto.GetStateDTO;
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

@Tag(name = "Departamentos", description = "Consulta de departamento")
@RestController
@RequestMapping("/api/v1/states")
public class GetStateController {

    private final GetStateByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetStateController(GetStateByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar departamentos",
            description = "Retorna los registros de departamento que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetStateDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "name") @RequestParam(required = false) String name,
            @Parameter(description = "country") @RequestParam(required = false) UUID country) {
        List<GetStateDTO> results = inputPort.execute(new GetStateDTO(id, name, country));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.STATE.LIST"), results));
    }

    @Operation(summary = "Obtener departamento por ID",
            description = "Retorna el detalle de un departamento. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetStateDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetStateDTO> results = inputPort.execute(new GetStateDTO(id, TextHelper.getDefault(), UUIDHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("State", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.STATE.GET"), results.get(0)));
    }
}
