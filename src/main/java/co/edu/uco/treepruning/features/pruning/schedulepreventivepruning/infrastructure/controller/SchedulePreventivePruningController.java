package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.infrastructure.controller.request.SchedulePreventivePruningRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prunings")
public class SchedulePreventivePruningController {

    private final SchedulePreventivePruningInputPort schedulePreventivePruningInputPort;

    public SchedulePreventivePruningController(
            SchedulePreventivePruningInputPort schedulePreventivePruningInputPort) {
        this.schedulePreventivePruningInputPort = schedulePreventivePruningInputPort;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> schedule(
            @RequestBody SchedulePreventivePruningRequest request) {
        schedulePreventivePruningInputPort.execute(new SchedulePreventivePruningDTO(
                request.status(),
                request.plannedDate(),
                request.executedDate(),
                request.tree(),
                request.quadrille(),
                request.type(),
                request.photographicRecordPath(),
                request.observations()
        ));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created("Poda preventiva programada exitosamente.", null));
    }
}
