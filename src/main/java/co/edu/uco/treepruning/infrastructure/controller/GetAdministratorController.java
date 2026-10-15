package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.GetAdministratorByFilterInputPort;
import co.edu.uco.treepruning.features.administrator.getadministratorbyfilter.application.inputport.dto.GetAdministratorDTO;
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

@Tag(name = "Administradores", description = "Consulta de administrador")
@RestController
@RequestMapping("/api/v1/administrators")
public class GetAdministratorController {

    private final GetAdministratorByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetAdministratorController(GetAdministratorByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar administradors",
            description = "Retorna los registros de administrador que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetAdministratorDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "username") @RequestParam(required = false) String username,
            @Parameter(description = "email") @RequestParam(required = false) String email,
            @Parameter(description = "emailConfirmed") @RequestParam(required = false) boolean emailConfirmed,
            @Parameter(description = "phone") @RequestParam(required = false) String phone,
            @Parameter(description = "phoneConfirmed") @RequestParam(required = false) boolean phoneConfirmed) {
        List<GetAdministratorDTO> results = inputPort.execute(new GetAdministratorDTO(id, username, email, emailConfirmed, phone, phoneConfirmed));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.ADMINISTRATOR.LIST"), results));
    }

    @Operation(summary = "Obtener administrador por ID",
            description = "Retorna el detalle de un administrador. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetAdministratorDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetAdministratorDTO> results = inputPort.execute(new GetAdministratorDTO(id, TextHelper.getDefault(), TextHelper.getDefault(), false, TextHelper.getDefault(), false));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Administrator", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.ADMINISTRATOR.GET"), results.get(0)));
    }
}
