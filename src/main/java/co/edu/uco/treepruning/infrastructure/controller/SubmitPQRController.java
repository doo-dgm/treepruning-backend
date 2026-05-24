package co.edu.uco.treepruning.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.SubmitPQRInputPort;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.inputport.dto.SubmitPQRDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.SubmitPQRRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "PQRs", description = "Registro de Peticiones, Quejas y Reclamos relacionadas con el arbolado urbano")
@RestController
@RequestMapping("/api/v1/pqrs")
public class SubmitPQRController {

    private final SubmitPQRInputPort submitPQRInputPort;
    private final MessageCatalogService catalog;

    public SubmitPQRController(SubmitPQRInputPort submitPQRInputPort, MessageCatalogService catalog) {
        this.submitPQRInputPort = submitPQRInputPort;
        this.catalog = catalog;
    }

    @Operation(
        summary = "Registrar PQR",
        description = "Crea una nueva Peticion, Queja o Reclamo relacionada con el estado del arbolado urbano del municipio."
    )
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
                .body(ApiResponse.created(catalog.resolve("USER.SUCCESS.PQR.CREATED"), null));
    }
}
