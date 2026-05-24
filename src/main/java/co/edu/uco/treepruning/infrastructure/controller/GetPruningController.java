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

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.pagination.PageResult;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.crosscutting.util.CrossCuttingConstants;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.GetPruningByFilterInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningbyfilter.application.inputport.dto.GetPruningDTO;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.GetPruningPhotoUrlInputPort;
import co.edu.uco.treepruning.features.pruning.getpruningphotourl.application.inputport.dto.PruningPhotoUrlDTO;
import co.edu.uco.treepruning.features.quadrille.getquadrillebyfilter.application.inputport.dto.GetQuadrilleDTO;
import co.edu.uco.treepruning.features.status.getstatusbyfilter.application.inputport.dto.GetStatusDTO;
import co.edu.uco.treepruning.features.tree.gettreebyfilter.application.inputport.dto.GetTreeDTO;
import co.edu.uco.treepruning.features.type.gettypebyfilter.application.inputport.dto.GetTypeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Podas", description = "Gestion y consulta de podas preventivas del arbolado urbano")
@RestController
@RequestMapping("/api/v1/prunings")
public class GetPruningController {

    private final GetPruningByFilterInputPort inputPort;
    private final GetPruningPhotoUrlInputPort getPhotoUrlInputPort;
    private final MessageCatalogService catalog;

    public GetPruningController(
            GetPruningByFilterInputPort inputPort,
            GetPruningPhotoUrlInputPort getPhotoUrlInputPort,
            MessageCatalogService catalog) {
        this.inputPort = inputPort;
        this.getPhotoUrlInputPort = getPhotoUrlInputPort;
        this.catalog = catalog;
    }

    @Operation(
        summary = "Listar podas con filtros",
        description = "Retorna una lista paginada de podas. Todos los filtros son opcionales y se combinan con AND. "
            + "El campo 'page' es base-0 (primera pagina = 0). El maximo de elementos por pagina es 100."
    )
    @GetMapping
    public ResponseEntity<ApiResponse<PageResult<GetPruningDTO>>> getByFilter(
            @Parameter(description = "Identificador unico de la poda") @RequestParam(required = false) UUID id,
            @Parameter(description = "Identificador del estado de la poda") @RequestParam(required = false) UUID statusId,
            @Parameter(description = "Identificador del arbol intervenido") @RequestParam(required = false) UUID treeId,
            @Parameter(description = "Identificador de la cuadrilla asignada") @RequestParam(required = false) UUID quadrilleId,
            @Parameter(description = "Identificador del tipo de poda") @RequestParam(required = false) UUID typeId,
            @Parameter(description = "Fecha programada en formato ISO-8601 (yyyy-MM-dd)") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate plannedDate,
            @Parameter(description = "Numero de pagina base-0 (default: 0)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Elementos por pagina (default: 20, max: 100)") @RequestParam(defaultValue = "" + CrossCuttingConstants.DEFAULT_PAGE_SIZE) int size) {

        PageResult<GetPruningDTO> result = inputPort.execute(
                new GetPruningDTO(id,
                        new GetStatusDTO(statusId),
                        plannedDate, null,
                        new GetTreeDTO(treeId),
                        new GetQuadrilleDTO(quadrilleId),
                        new GetTypeDTO(typeId),
                        null, null, null, page, size));

        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.PRUNING.LIST"), result));
    }

    @Operation(summary = "Obtener poda por ID", description = "Retorna el detalle de una poda dado su identificador. Retorna 404 si no existe.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPruningDTO>> getById(
            @Parameter(description = "Identificador unico de la poda") @PathVariable UUID id) {
        PageResult<GetPruningDTO> result = inputPort.execute(new GetPruningDTO(id));

        if (result.content().isEmpty()) {
            throw ResourceNotFoundException.create("Pruning", id);
        }
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.PRUNING.GET"), result.content().get(0)));
    }

    @Operation(
        summary = "Obtener URL de evidencia fotografica",
        description = "Genera y retorna una URL prefirmada de corta duracion para descargar la fotografia de evidencia de la poda. "
            + "Retorna 404 si la poda no existe o no tiene fotografia registrada."
    )
    @GetMapping("/{id}/photo-url")
    public ResponseEntity<ApiResponse<PruningPhotoUrlDTO>> getPhotoUrl(
            @Parameter(description = "Identificador unico de la poda") @PathVariable UUID id) {
        PruningPhotoUrlDTO dto = getPhotoUrlInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("USER.SUCCESS.PRUNING.PHOTO_URL"), dto));
    }
}
