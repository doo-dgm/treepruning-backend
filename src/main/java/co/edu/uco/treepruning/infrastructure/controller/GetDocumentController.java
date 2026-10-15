package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.helper.TextHelper;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.GetDocumentByFilterInputPort;
import co.edu.uco.treepruning.features.document.getdocumentbyfilter.application.inputport.dto.GetDocumentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Documentos", description = "Consulta de tipo de documento")
@RestController
@RequestMapping("/api/v1/documents")
public class GetDocumentController {

    private final GetDocumentByFilterInputPort inputPort;
    private final MessageCatalogService catalog;

    public GetDocumentController(GetDocumentByFilterInputPort inputPort, MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Listar tipo de documentos",
            description = "Retorna los registros de tipo de documento que coincidan con los filtros opcionales.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<GetDocumentDTO>>> getByFilter(
            @Parameter(description = "id") @RequestParam(required = false) UUID id,
            @Parameter(description = "name") @RequestParam(required = false) String name,
            @Parameter(description = "code") @RequestParam(required = false) String code) {
        List<GetDocumentDTO> results = inputPort.execute(new GetDocumentDTO(id, name, code));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.DOCUMENT.LIST"), results));
    }

    @Operation(summary = "Obtener tipo de documento por ID",
            description = "Retorna el detalle de un tipo de documento. Responde 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetDocumentDTO>> getById(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        List<GetDocumentDTO> results = inputPort.execute(new GetDocumentDTO(id, TextHelper.getDefault(), TextHelper.getDefault()));
        if (results.isEmpty()) {
            throw ResourceNotFoundException.create("Document", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.DOCUMENT.GET"), results.get(0)));
    }
}
