package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.GetOperatorByFilterInputPort;
import co.edu.uco.treepruning.features.operator.getoperatorbyfilter.application.inputport.dto.GetOperatorDTO;
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

@Tag(name = "Operarios", description = "Consulta de operario")
@RestController
@RequestMapping("/api/v1/operators")
public class GetOperatorController {

    private final GetOperatorByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetOperatorController(GetOperatorByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar operarios",
            description = "Retorna los registros de operario que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetOperatorDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "person") @RequestParam(required = false) UUID person,
            @Parameter(description = "quadrille") @RequestParam(required = false) UUID quadrille) {
        List<GetOperatorDTO> results = inputPort.execute(new GetOperatorDTO(id, person, quadrille));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.OPERATOR.LIST"), results));
    }

    @Operation(summary = "Obtener operario por ID",
            description = "Retorna el detalle de un operario. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetOperatorDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetOperatorDTO> results = inputPort.execute(new GetOperatorDTO(id, UUIDHelper.getDefault(), UUIDHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Operator", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.OPERATOR.GET"), results.get(0)));
    }
}
