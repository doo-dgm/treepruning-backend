package co.edu.uco.treepruning.infrastructure.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.SchedulePreventivePruningRequest;

@RestController
@RequestMapping("/api/v1/prunings")
public class SchedulePreventivePruningController {

    private final SchedulePreventivePruningInputPort schedulePreventivePruningInputPort;

    public SchedulePreventivePruningController(
            SchedulePreventivePruningInputPort schedulePreventivePruningInputPort) {
        this.schedulePreventivePruningInputPort = schedulePreventivePruningInputPort;
    }

    /**
     * Programa una poda preventiva. La fotografía (campo {@code photo}) es
     * opcional: si se envía, se sube a MinIO y se persiste su key en la entidad.
     *
     * Petición esperada (multipart/form-data):
     *   - parte "data" (application/json): {@link SchedulePreventivePruningRequest}
     *   - parte "photo" (image/jpeg|png|webp, opcional): archivo de evidencia
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Void>> schedule(
            @RequestPart("data") SchedulePreventivePruningRequest request,
            @RequestPart(value = "photo", required = false) MultipartFile photo) {

        byte[] photoBytes = null;
        String contentType = null;
        String originalFilename = null;
        if (photo != null && !photo.isEmpty()) {
            try {
                photoBytes = photo.getBytes();
            } catch (IOException e) {
                throw TreePruningException.create(
                        "No se pudo leer la fotografía enviada.",
                        "Multipart read failed: " + e.getMessage());
            }
            contentType = photo.getContentType();
            originalFilename = photo.getOriginalFilename();
        }

        schedulePreventivePruningInputPort.execute(new SchedulePreventivePruningDTO(
                request.status(),
                request.plannedDate(),
                request.executedDate(),
                request.tree(),
                request.quadrille(),
                request.type(),
                null,
                request.observations(),
                photoBytes,
                contentType,
                originalFilename
        ));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created("Poda preventiva programada exitosamente.", null));
    }
}
