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
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.GetStatusByFilterInputPort;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;

@RestController
@RequestMapping("/api/v1/statuses")
public class GetStatusController {

    private final GetStatusByFilterInputPort inputPort;

    public GetStatusController(GetStatusByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetStatusDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String name) {
        List<GetStatusDTO> results = inputPort.execute(new GetStatusDTO(id, name));
        return ResponseEntity.ok(ApiResponse.ok("Estados obtenidos exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetStatusDTO>> getById(@PathVariable UUID id) {
        List<GetStatusDTO> results = inputPort.execute(new GetStatusDTO(id, TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Status", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Estado obtenido exitosamente.", results.get(0)));
    }
}
