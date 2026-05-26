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
import io.swagger.v3.oas.annotations.tags.Tag;

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
        description = "Sube una imagen (JPEG, PNG o WebP, max 5 MB) a MinIO y "
            + "devuelve la ruta interna. Usar la ruta en photographicRecordPath "
            + "al programar la poda."
    )
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Map<String, String>>> upload(
            @RequestPart("file") MultipartFile file,
            @AuthenticationPrincipal Jwt jwt) {

        byte[] bytes;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            throw TreePruningException.fromCode(
                    "USER.ERROR.PRUNING.PHOTO_READ_FAILED",
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
