package co.edu.uco.treepruning.infrastructure.controller;


import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.RegisterTokenInputPort;
import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.dto.RegisterTokenDTO;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.UnregisterTokenInputPort;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.dto.UnregisterTokenDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.GetNotificationHistoryInputPort;
import co.edu.uco.treepruning.infrastructure.controller.request.RegisterTokenRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final RegisterTokenInputPort   registerTokenInputPort;
    private final UnregisterTokenInputPort unregisterTokenInputPort;
    private final GetNotificationHistoryInputPort historyInputPort;

    public NotificationController(
            RegisterTokenInputPort registerTokenInputPort,
            UnregisterTokenInputPort unregisterTokenInputPort,
            GetNotificationHistoryInputPort historyInputPort) {
        this.registerTokenInputPort   = registerTokenInputPort;
        this.unregisterTokenInputPort = unregisterTokenInputPort;
        this.historyInputPort         = historyInputPort;
    }

    @PostMapping("/token")
    public ResponseEntity<ApiResponse<Void>> registerToken(
            @RequestBody RegisterTokenRequest request,
            @AuthenticationPrincipal Jwt jwt) {

        UUID userId = UUID.fromString(jwt.getSubject());

        registerTokenInputPort.execute(new RegisterTokenDTO(
                userId,
                request.token()
        ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created("Token registrado exitosamente.", null));
    }

    @PostMapping("/token/unregister")
    public ResponseEntity<ApiResponse<Void>> unregisterToken(
            @RequestBody RegisterTokenRequest request) {

        unregisterTokenInputPort.execute(new UnregisterTokenDTO(
                request.token()
        ));

        return ResponseEntity
                .ok(ApiResponse.ok("Token desregistrado exitosamente.", null));
    }

    @GetMapping("/history")
    public ResponseEntity<ApiResponse<List<?>>> getHistory(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "20") int size) {

        UUID userId = UUID.fromString(jwt.getSubject());

        return ResponseEntity
                .ok(ApiResponse.ok("Historial obtenido exitosamente.",
                        historyInputPort.execute(userId, page, size)));
    }
}