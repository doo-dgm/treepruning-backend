package co.edu.uco.treepruning.crosscutting.response;

import java.util.Map;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final MessageCatalogService catalog;

    public GlobalExceptionHandler(MessageCatalogService catalog) {
        this.catalog = catalog;
    }

    @ExceptionHandler(TreePruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleTreePruningException(TreePruningException ex) {

        // Log the technical context when a catalog code is available
        if (ex.getTechnicalCode() != null) {
            Map<String, Object> vars = ex.getVariables() != null ? ex.getVariables() : Map.of();
            String techMsg = catalog.resolve(ex.getTechnicalCode(), vars);
            log.warn("[{}] {} | {}", ex.getHttpStatus(), ex.getTechnicalCode(), techMsg);
        }

        // Resolve user-facing message
        String message;
        if (ex.getCode() != null) {
            // Resolve text from Strapi catalog
            message = (ex.getVariables() != null)
                    ? catalog.resolve(ex.getCode(), ex.getVariables())
                    : catalog.resolve(ex.getCode());
        } else {
            // Backward-compat path -- hardcoded message
            message = ex.getUserMessage();
        }

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ApiResponse.error(ex.getHttpStatus(), message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        String techMsg = catalog.resolve("TECHNICAL.ERROR.GENERIC.INTERNAL");
        log.error("[500] {} | {}", "TECHNICAL.ERROR.GENERIC.INTERNAL", techMsg, ex);
        String message = catalog.resolve("ERROR.GENERIC.INTERNAL");
        return ResponseEntity
                .status(500)
                .body(ApiResponse.error(500, message));
    }
}
