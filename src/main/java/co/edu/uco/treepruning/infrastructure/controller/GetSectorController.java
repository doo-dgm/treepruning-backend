package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import java.util.UUID;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.GetSectorByFilterInputPort;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;

@RestController
@RequestMapping("/api/v1/sectors")
public class GetSectorController {

    private final GetSectorByFilterInputPort inputPort;

    public GetSectorController(GetSectorByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetSectorDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String name) {
        List<GetSectorDTO> results = inputPort.execute(
                new GetSectorDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok("Sectores obtenidos exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetSectorDTO>> getById(@PathVariable UUID id) {
        List<GetSectorDTO> results = inputPort.execute(
                new GetSectorDTO(id, TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Sector", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Sector obtenido exitosamente.", results.get(0)));
    }
}
