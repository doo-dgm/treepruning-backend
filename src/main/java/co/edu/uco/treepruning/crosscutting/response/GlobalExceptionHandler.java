package co.edu.uco.treepruning.crosscutting.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(TreePruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleTreePruningException(
            TreePruningException ex) {
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ApiResponse.error(
                        ex.getHttpStatus(), ex.getUserMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(
            Exception ex) {
        log.error("[500] Error inesperado: {}", ex.getMessage(), ex);
        return ResponseEntity
                .status(500)
                .body(ApiResponse.error(500,
                        "Ocurrió un error inesperado. " +
                        "Por favor intente más tarde."));
    }
}