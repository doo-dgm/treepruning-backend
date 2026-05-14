package co.edu.uco.treepruning.features.pqr.submitpqr.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.SubmitPQRInputPort;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.dto.SubmitPQRDTO;
import co.edu.uco.treepruning.features.pqr.submitpqr.infrastructure.controller.request.SubmitPQRRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pqrs")
public class SubmitPQRController {

    private final SubmitPQRInputPort submitPQRInputPort;

    public SubmitPQRController(SubmitPQRInputPort submitPQRInputPort) {
        this.submitPQRInputPort = submitPQRInputPort;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> submit(@RequestBody SubmitPQRRequest request) {
        submitPQRInputPort.execute(new SubmitPQRDTO(
                request.date(),
                request.status(),
                request.sector(),
                request.risk(),
                request.person(),
                request.photographicRecordPath()
        ));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created("PQR registrada exitosamente.", null));
    }
}
