package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.DateHelper;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.GetPQRByFilterInputPort;
import co.edu.uco.treepruning.features.pqr.getpqrbyfilter.application.inputport.dto.GetPQRDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PQRs", description = "Consulta de PQR")
@RestController
@RequestMapping("/api/v1/pqrs")
public class GetPQRController {

    private final GetPQRByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetPQRController(GetPQRByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar PQRs",
            description = "Retorna los registros de PQR que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetPQRDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "date") @RequestParam(required = false) LocalDate date,
            @Parameter(description = "status") @RequestParam(required = false) UUID status,
            @Parameter(description = "risk") @RequestParam(required = false) UUID risk,
            @Parameter(description = "sector") @RequestParam(required = false) UUID sector,
            @Parameter(description = "person") @RequestParam(required = false) UUID person,
            @Parameter(description = "photographicRecordPath") @RequestParam(required = false) String photographicRecordPath) {
        List<GetPQRDTO> results = inputPort.execute(new GetPQRDTO(id, date, status, risk, sector, person, photographicRecordPath));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PQR.LIST"), results));
    }

    @Operation(summary = "Obtener PQR por ID",
            description = "Retorna el detalle de un PQR. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPQRDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetPQRDTO> results = inputPort.execute(new GetPQRDTO(id, DateHelper.getDefault(), UUIDHelper.getDefault(), UUIDHelper.getDefault(), UUIDHelper.getDefault(), UUIDHelper.getDefault(), TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("PQR", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PQR.GET"), results.get(0)));
    }
}
