package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.GetRiskByFilterInputPort;
import co.edu.uco.treepruning.features.risk.getriskbyfilter.application.inputport.dto.GetRiskDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Riesgos", description = "Consulta de riesgo")
@RestController
@RequestMapping("/api/v1/risks")
public class GetRiskController {

    private final GetRiskByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetRiskController(GetRiskByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar riesgos",
            description = "Retorna los registros de riesgo que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetRiskDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "name") @RequestParam(required = false) String name) {
        List<GetRiskDTO> results = inputPort.execute(new GetRiskDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.RISK.LIST"), results));
    }
}
