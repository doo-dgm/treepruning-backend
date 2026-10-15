package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.document.updatedocument.application.inputport.UpdateDocumentInputPort;
import co.edu.uco.treepruning.features.document.updatedocument.application.inputport.dto.UpdateDocumentDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdateDocumentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Documentos", description = "Gestion de tipo de documento")
@RestController
@RequestMapping("/api/v1/documents")
public class ManageDocumentController {

    private final UpdateDocumentInputPort updateDocumentInputPort;
    private final MessageCatalogService catalog;

    public ManageDocumentController(
            UpdateDocumentInputPort updateDocumentInputPort,
            MessageCatalogService catalog) {
        this.updateDocumentInputPort = updateDocumentInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Actualizar tipo de documento")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateDocument(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdateDocumentRequest request) {
        updateDocumentInputPort.execute(new UpdateDocumentDTO(id, request.name(), request.code()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.DOCUMENT.UPDATED"), null));
    }
}
