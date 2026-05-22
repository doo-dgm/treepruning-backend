package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.GetPersonByFilterInputPort;
import co.edu.uco.treepruning.features.person.getpersonbyfilter.application.inputport.dto.GetPersonDTO;

@RestController
@RequestMapping("/api/v1/persons")
public class GetPersonController {

    private final GetPersonByFilterInputPort inputPort;

    public GetPersonController(GetPersonByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetPersonDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String firstLastName) {
        List<GetPersonDTO> results = inputPort.execute(
                new GetPersonDTO(id, firstName, null, firstLastName, null, null, null, null, null, null, 0));
        return ResponseEntity.ok(ApiResponse.ok("Personas obtenidas exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPersonDTO>> getById(@PathVariable UUID id) {
        List<GetPersonDTO> results = inputPort.execute(new GetPersonDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Person", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Persona obtenida exitosamente.", results.get(0)));
    }
}
