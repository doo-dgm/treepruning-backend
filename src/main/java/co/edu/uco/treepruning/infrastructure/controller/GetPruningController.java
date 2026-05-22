package co.edu.uco.treepruning.infrastructure.controller;

import java.time.LocalDate;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.GetPruningByFilterInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;

@RestController
@RequestMapping("/api/v1/prunings")
public class GetPruningController {

    private final GetPruningByFilterInputPort inputPort;

    public GetPruningController(GetPruningByFilterInputPort inputPort) {
        this.inputPort = inputPort;
    }

    /**
     * Returns a paginated list of prunings matching the given filters.
     *
     * @param page zero-based page index (default: 0)
     * @param size elements per page (default: 20, max: 100)
     */
    @GetMapping
    public ResponseEntity<ApiResponse<PageResult<GetPruningDTO>>> getByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) UUID statusId,
            @RequestParam(required = false) UUID treeId,
            @RequestParam(required = false) UUID quadrilleId,
            @RequestParam(required = false) UUID typeId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate plannedDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "" + CrossCuttingConstants.DEFAULT_PAGE_SIZE) int size) {

        PageResult<GetPruningDTO> result = inputPort.execute(
                new GetPruningDTO(id,
                        new GetStatusDTO(statusId),
                        plannedDate, null,
                        new GetTreeDTO(treeId),
                        new GetQuadrilleDTO(quadrilleId),
                        new GetTypeDTO(typeId),
                        null, null, null, page, size));

        return ResponseEntity.ok(ApiResponse.ok("Podas obtenidas exitosamente.", result));
    }

    /**
     * Returns a single pruning by its identifier.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPruningDTO>> getById(@PathVariable UUID id) {
        PageResult<GetPruningDTO> result = inputPort.execute(new GetPruningDTO(id));

        if (result.content().isEmpty()) {
            throw ResourceNotFoundException.create("Pruning", id);
        }
        return ResponseEntity.ok(ApiResponse.ok("Poda obtenida exitosamente.", result.content().get(0)));
    }
}
