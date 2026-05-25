package co.edu.uco.treepruning.infrastructure.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.SchedulePreventivePruningInputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.SchedulePreventivePruningRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Podas", description = "Gestion y consulta de podas preventivas del arbolado urbano")
@RestController
@RequestMapping("/api/v1/prunings")
public class SchedulePreventivePruningController {

    private final SchedulePreventivePruningInputPort schedulePreventivePruningInputPort;
    private final MessageCatalogService catalog;

    public SchedulePreventivePruningController(
            SchedulePreventivePruningInputPort schedulePreventivePruningInputPort,
            MessageCatalogService catalog) {
        this.schedulePreventivePruningInputPort = schedulePreventivePruningInputPort;
        this.catalog = catalog;
    }

    @Operation(
        summary = "Programar poda preventiva",
        description = "Registra una nueva poda preventiva en el sistema. "
            + "La parte 'data' contiene el JSON con los datos de la poda; "
            + "la parte 'photo' (opcional) es la imagen de evidencia (JPEG, PNG o WebP, max 5 MB)."
    )
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Void>> schedule(
            @Parameter(description = "Datos de la poda en formato JSON") @RequestPart("data") SchedulePreventivePruningRequest request,
            @Parameter(description = "Imagen de evidencia fotografica (JPEG, PNG o WebP, max 5 MB)") @RequestPart(value = "photo", required = false) MultipartFile photo) {

        byte[] photoBytes = null;
        String contentType = null;
        String originalFilename = null;
        if (photo != null && !photo.isEmpty()) {
            try {
                photoBytes = photo.getBytes();
            } catch (IOException e) {
                throw TreePruningException.fromCode(
                        "USER.ERROR.PRUNING.PHOTO_READ_FAILED",
                        "TECHNICAL.ERROR.PRUNING.PHOTO_READ_FAILED",
                        Map.of("error", e.getMessage() != null ? e.getMessage() : "unknown"));
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
                .body(ApiResponse.created(catalog.resolve("USER.SUCCESS.PRUNING.SCHEDULED"), null));
    }
}
