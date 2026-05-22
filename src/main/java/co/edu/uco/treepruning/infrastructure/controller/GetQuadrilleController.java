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
import co.edu.uco.treepruning.features.manager.getmanagerbyfilter.application.inputport.dto.GetManagerDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.GetQuadrilleByFilterInputPort;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;

@RestController
@RequestMapping("/api/v1/quadrilles")
public class GetQuadrilleController {

    private final GetQuadrilleByFilterInputPort inputPort;

    public GetQuadrilleController(GetQuadrilleByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetQuadrilleDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String quadrilleName,
            @RequestParam(required = false) UUID managerId) {
        List<GetQuadrilleDTO> results = inputPort.execute(
                new GetQuadrilleDTO(id, quadrilleName, new GetManagerDTO(managerId)));
        return ResponseEntity.ok(ApiResponse.ok("Cuadrillas obtenidas exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetQuadrilleDTO>> getById(@PathVariable UUID id) {
        List<GetQuadrilleDTO> results = inputPort.execute(new GetQuadrilleDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Quadrille", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Cuadrilla obtenida exitosamente.", results.get(0)));
    }
}
