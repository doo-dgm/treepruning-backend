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
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.GetFamilyByFilterInputPort;
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;

@RestController
@RequestMapping("/api/v1/families")
public class GetFamilyController {

    private final GetFamilyByFilterInputPort inputPort;

    public GetFamilyController(GetFamilyByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetFamilyDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String commonName,
            @RequestParam(required = false) String scientificName) {
        List<GetFamilyDTO> results = inputPort.execute(
                new GetFamilyDTO(id, commonName, scientificName));
        return ResponseEntity.ok(ApiResponse.ok("Familias obtenidas exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetFamilyDTO>> getById(@PathVariable UUID id) {
        List<GetFamilyDTO> results = inputPort.execute(new GetFamilyDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Family", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Familia obtenida exitosamente.", results.get(0)));
    }
}
