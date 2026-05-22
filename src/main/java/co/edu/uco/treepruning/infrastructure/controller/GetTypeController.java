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
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.GetTypeByFilterInputPort;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;

@RestController
@RequestMapping("/api/v1/types")
public class GetTypeController {

    private final GetTypeByFilterInputPort inputPort;

    public GetTypeController(GetTypeByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTypeDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String name) {
        List<GetTypeDTO> results = inputPort.execute(new GetTypeDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok("Tipos de poda obtenidos exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetTypeDTO>> getById(@PathVariable UUID id) {
        List<GetTypeDTO> results = inputPort.execute(new GetTypeDTO(id, null));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Type", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Tipo de poda obtenido exitosamente.", results.get(0)));
    }
}
