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
import co.edu.uco.treepruning.features.family.getfamilybyfilter.application.inputport.dto.GetFamilyDTO;
import co.edu.uco.treepruning.features.sector.getsectorbyfilter.application.inputport.dto.GetSectorDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.GetTreeByFilterInputPort;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;

@RestController
@RequestMapping("/api/v1/trees")
public class GetTreeController {

    private final GetTreeByFilterInputPort inputPort;

    public GetTreeController(GetTreeByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetTreeDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) UUID familyId,
            @RequestParam(required = false) UUID sectorId) {
        List<GetTreeDTO> results = inputPort.execute(
                new GetTreeDTO(id, null, null, new GetFamilyDTO(familyId), new GetSectorDTO(sectorId), null));
        return ResponseEntity.ok(ApiResponse.ok("Árboles obtenidos exitosamente.", results));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetTreeDTO>> getById(@PathVariable UUID id) {
        List<GetTreeDTO> results = inputPort.execute(new GetTreeDTO(id));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Tree", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Árbol obtenido exitosamente.", results.get(0)));
    }
}
