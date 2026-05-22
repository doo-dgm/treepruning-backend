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
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.GetManagerByFilterInputPort;
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;

@RestController
@RequestMapping("/api/v1/managers")
public class GetManagerController {

    private final GetManagerByFilterInputPort inputPort;

    public GetManagerController(GetManagerByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetManagerDTO>>> getByFilter(
            @RequestParam(required = false) UUID id) {
        List<GetManagerDTO> results = inputPort.execute(new GetManagerDTO(id));
        return ResponseEntity.ok(ApiResponse.ok("Cuadrilleros obtenidos exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetManagerDTO>> getById(@PathVariable UUID id) {
        List<GetManagerDTO> results = inputPort.execute(new GetManagerDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Manager", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Cuadrillero obtenido exitosamente.", results.get(0)));
    }
}
