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
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.GetProgrammingByFilterInputPort;
import co.edu.uco.treepruning.features.programming.getprogrammingbyfilter.application.inputport.dto.GetProgrammingDTO;

@RestController
@RequestMapping("/api/v1/programmings")
public class GetProgrammingController {

    private final GetProgrammingByFilterInputPort inputPort;

    public GetProgrammingController(GetProgrammingByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetProgrammingDTO>>> getByFilter(
            @RequestParam(required = false) UUID id) {
        List<GetProgrammingDTO> results = inputPort.execute(
                new GetProgrammingDTO(id, null, 0, 0));
        return ResponseEntity.ok(ApiResponse.ok("Programaciones obtenidas exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetProgrammingDTO>> getById(@PathVariable UUID id) {
        List<GetProgrammingDTO> results = inputPort.execute(
                new GetProgrammingDTO(id, null, 0, 0));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Programming", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Programacion obtenida exitosamente.", results.get(0)));
    }
}
