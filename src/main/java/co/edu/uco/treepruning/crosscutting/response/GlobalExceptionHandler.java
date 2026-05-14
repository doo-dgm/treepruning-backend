package co.edu.uco.treepruning.crosscutting.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PlannedDateNotValidForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.PruningTypeNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.QuadrilleNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.StatusNotFoundForPruningException;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.rules.TreeNotFoundForPruningException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TreeNotFoundForPruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleTreeNotFound(
            TreeNotFoundForPruningException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(404, ex.getUserMessage()));
    }

    @ExceptionHandler(QuadrilleNotFoundForPruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleQuadrilleNotFound(
            QuadrilleNotFoundForPruningException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(404, ex.getUserMessage()));
    }

    @ExceptionHandler(PruningTypeNotFoundForPruningException.class)
    public ResponseEntity<ApiResponse<Void>> handlePruningTypeNotFound(
            PruningTypeNotFoundForPruningException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(404, ex.getUserMessage()));
    }

    @ExceptionHandler(StatusNotFoundForPruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleStatusNotFound(
            StatusNotFoundForPruningException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(404, ex.getUserMessage()));
    }

    @ExceptionHandler(PlannedDateNotValidForPruningException.class)
    public ResponseEntity<ApiResponse<Void>> handlePlannedDateNotValid(
            PlannedDateNotValidForPruningException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(400, ex.getUserMessage()));
    }

    @ExceptionHandler(TreePruningException.class)
    public ResponseEntity<ApiResponse<Void>> handleTreePruningException(
            TreePruningException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(400, ex.getUserMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(
            Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error(500,
                        "Ocurrió un error inesperado. Por favor intente más tarde."));
    }
}
