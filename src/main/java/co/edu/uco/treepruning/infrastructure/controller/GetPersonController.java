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
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.GetPersonByFilterInputPort;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Personas", description = "Consulta de personas registradas en el sistema")
@RestController
@RequestMapping("/api/v1/persons")
public class GetPersonController {

    private final GetPersonByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetPersonController(GetPersonByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar personas", description = "Retorna personas que coincidan con los filtros opcionales de nombre o apellido.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetPersonDTO>>> getByFilter(
            @Parameter(description = "Identificador unico de la persona") @RequestParam(required = false) UUID id,
            @Parameter(description = "Primer nombre (busqueda parcial)") @RequestParam(required = false) String firstName,
            @Parameter(description = "Primer apellido (busqueda parcial)") @RequestParam(required = false) String firstLastName) {
        List<GetPersonDTO> results = inputPort.execute(
                new GetPersonDTO(id, firstName, null, firstLastName, null, null, null, null, null, null, 0));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PERSON.LIST"), results));
    }

    @Operation(summary = "Obtener persona por ID", description = "Retorna el detalle de una persona dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPersonDTO>> getById(
            @Parameter(description = "Identificador unico de la persona") @PathVariable UUID id) {
        List<GetPersonDTO> results = inputPort.execute(new GetPersonDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Person", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PERSON.GET"), results.get(0)));
    }
}
