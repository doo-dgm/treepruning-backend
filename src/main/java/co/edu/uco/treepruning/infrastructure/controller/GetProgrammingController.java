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
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.GetProgrammingByFilterInputPort;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Programaciones", description = "Consulta de programaciones de poda registradas en el sistema")
@RestController
@RequestMapping("/api/v1/programmings")
public class GetProgrammingController {

    private final GetProgrammingByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetProgrammingController(GetProgrammingByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar programaciones", description = "Retorna todas las programaciones de poda. Filtra opcionalmente por ID.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetProgrammingDTO>>> getByFilter(
            @Parameter(description = "Identificador unico de la programacion") @RequestParam(required = false) UUID id) {
        List<GetProgrammingDTO> results = inputPort.execute(
                new GetProgrammingDTO(id, null, 0, 0));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.PROGRAMMING.LIST"), results));
    }

    @Operation(summary = "Obtener programacion por ID", description = "Retorna el detalle de una programacion dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetProgrammingDTO>> getById(
            @Parameter(description = "Identificador unico de la programacion") @PathVariable UUID id) {
        List<GetProgrammingDTO> results = inputPort.execute(
                new GetProgrammingDTO(id, null, 0, 0));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Programming", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.PROGRAMMING.GET"), results.get(0)));
    }
}
