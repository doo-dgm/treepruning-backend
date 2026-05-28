package co.edu.uco.treepruning.crosscutting.response;

import java.util.Map;
import java.util.Set;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final Set<String> SUPPORTED_LOCALES = Set.of("es", "en");
    private static final String DEFAULT_LOCALE = "es";

    private final MessageCatalogService catalog;

    public GlobalExceptionHandler(MessageCatalogService catalog) {
        this.catalog = catalog;
    }

    @ExceptionHandler(TreePruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleTreePruningException(
            TreePruningException ex, HttpServletRequest request) {

        String locale = resolveLocale(request);

        // Log tecnico (siempre en es para los logs del servidor)
        if (ex.getTechnicalCode() != null) {
            Map<String, Object> vars = ex.getVariables() != null ? ex.getVariables() : Map.of();
            String techMsg = catalog.resolve(ex.getTechnicalCode(), vars);
            log.warn("[{}] {} | {}", ex.getHttpStatus(), ex.getTechnicalCode(), techMsg);
        }

        // Mensaje al usuario en el idioma que pide el cliente
        String message;
        if (ex.getCode() != null) {
            message = (ex.getVariables() != null)
                    ? catalog.resolve(ex.getCode(), ex.getVariables(), locale)
                    : catalog.resolve(ex.getCode(), locale);
        } else {
            // Backward-compat: excepcion con mensaje hardcoded (sin codigo de catalogo)
            message = ex.getUserMessage();
        }

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ApiResponse.error(ex.getHttpStatus(), message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(
            Exception ex, HttpServletRequest request) {

        String locale = resolveLocale(request);
        String techMsg = catalog.resolve("TECHNICAL.ERROR.GENERIC.INTERNAL");
        log.error("[500] {} | {}", "TECHNICAL.ERROR.GENERIC.INTERNAL", techMsg, ex);
        String message = catalog.resolve("ERROR.GENERIC.INTERNAL", locale);
        return ResponseEntity
                .status(500)
                .body(ApiResponse.error(500, message));
    }

    /**
     * Extrae el idioma del header Accept-Language.
     * Solo acepta los 2 primeros caracteres (ej: "en-US" → "en").
     * Si el idioma no esta soportado, devuelve el locale por defecto.
     */
    private String resolveLocale(HttpServletRequest request) {
        String header = request.getHeader("Accept-Language");
        if (header == null || header.isBlank()) return DEFAULT_LOCALE;
        // Tomar solo el tag primario ("en-US,en;q=0.9" → "en")
        String lang = header.split("[,;\\-]")[0].trim().toLowerCase();
        return SUPPORTED_LOCALES.contains(lang) ? lang : DEFAULT_LOCALE;
    }
}
