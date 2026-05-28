package co.edu.uco.treepruning.infrastructure.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.validator.SchedulePreventivePruningDTOValidator;
import co.edu.uco.treepruning.infrastructure.storage.PhotoStoragePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// Nota: io.swagger.v3.oas.annotations.responses.ApiResponse comparte nombre
// con nuestra clase ApiResponse del paquete crosscutting.response, por eso
// se usa fully-qualified mas abajo.

@Tag(name = "Fotos", description = "Subida de evidencia fotografica de podas")
@RestController
@RequestMapping("/api/v1/photos")
public class UploadPruningPhotoController {

    private final PhotoStoragePort photoStorage;

    public UploadPruningPhotoController(PhotoStoragePort photoStorage) {
        this.photoStorage = photoStorage;
    }

    @Operation(
        summary = "Subir foto de evidencia",
        description = "Sube una imagen (JPEG/PNG/WebP, max 5 MB) a MinIO. " +
                "El path retornado lleva el userId del JWT (aislamiento por usuario) " +
                "y se usa en el campo photographicRecordPath al programar la poda."
    )
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "200",
                description  = "Foto almacenada. data.path = key MinIO."),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "400",
                description  = "Archivo invalido (vacio, > 5MB o formato no permitido).",
                content      = @Content),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "401",
                description  = "JWT ausente o invalido.",
                content      = @Content),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
                responseCode = "403",
                description  = "Rol sin permiso (requiere MANAGER o ADMIN).",
                content      = @Content)
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Map<String, String>>> upload(
            @RequestPart("file") MultipartFile file,
            @AuthenticationPrincipal Jwt jwt) {

        byte[] bytes;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            throw TreePruningException.fromCode(
                    "ERROR.PRUNING.PHOTO_READ_FAILED",
                    "TECHNICAL.ERROR.PRUNING.PHOTO_READ_FAILED",
                    Map.of("error", e.getMessage() != null ? e.getMessage() : "unknown"));
        }

        SchedulePreventivePruningDTOValidator.validatePhoto(bytes, file.getContentType());

        String userId = jwt != null ? jwt.getSubject() : "anonymous";
        String path   = photoStorage.upload(bytes, file.getContentType(), file.getOriginalFilename(), userId);

        return ResponseEntity.ok(
                ApiResponse.ok("Foto subida correctamente.", Map.of("path", path)));
    }
}
