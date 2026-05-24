package co.edu.uco.treepruning.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.GetNotificationHistoryDTO;
import co.edu.uco.treepruning.features.notification.gethistory.application.inputport.dto.NotificationHistoryItemDTO;
import co.edu.uco.treepruning.features.notification.registertoken.application.inputport.dto.RegisterTokenDTO;
import co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.dto.UnregisterTokenDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.RegisterTokenRequest;
import org.springframework.security.oauth2.jwt.Jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.util.List;
import java.util.UUID;

@RestController
public class NotificactionController {
	
	private final co.edu.uco.treepruning.features.notification.registertoken.application.inputport.RegisterTokenInputPort registerTokenInputPort;
	private final co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.UnregisterTokenInputPort unregisterTokenInputPort;
	private final co.edu.uco.treepruning.features.notification.gethistory.application.inputport.GetNotificationHistoryInputPort historyInputPort;
	
	public NotificactionController(
	        co.edu.uco.treepruning.features.notification.registertoken.application.inputport.RegisterTokenInputPort registerTokenInputPort,
	        co.edu.uco.treepruning.features.notification.unregistertoken.application.inputport.UnregisterTokenInputPort unregisterTokenInputPort,
	        co.edu.uco.treepruning.features.notification.gethistory.application.inputport.GetNotificationHistoryInputPort historyInputPort) {
	    this.registerTokenInputPort = registerTokenInputPort;
	    this.unregisterTokenInputPort = unregisterTokenInputPort;
	    this.historyInputPort = historyInputPort;
	}
	
	@PostMapping("/token")
	public ResponseEntity<ApiResponse<Void>> registerToken(
	        @RequestBody RegisterTokenRequest request,
	        @AuthenticationPrincipal Jwt jwt) {

	    registerTokenInputPort.execute(
	        new RegisterTokenDTO(
	            UUID.fromString(jwt.getSubject()),
	            request.token()
	        )
	    );
	    return ResponseEntity
	        .status(HttpStatus.CREATED)
	        .body(ApiResponse.created("Token registrado exitosamente.", null));
	}

	@PostMapping("/token/unregister")
	public ResponseEntity<ApiResponse<Void>> unregisterToken(
	        @RequestBody RegisterTokenRequest request) {

	    unregisterTokenInputPort.execute(
	        new UnregisterTokenDTO(request.token())
	    );
	    return ResponseEntity
	        .ok(ApiResponse.ok("Token desregistrado exitosamente.", null));
	}

	@GetMapping("/history")
	public ResponseEntity<ApiResponse<List<NotificationHistoryItemDTO>>> getHistory(
	        @AuthenticationPrincipal Jwt jwt,
	        @RequestParam(defaultValue = "0")  int page,
	        @RequestParam(defaultValue = "20") int size) {

	    return ResponseEntity.ok(
	        ApiResponse.ok(
	            "Historial obtenido exitosamente.",
	            historyInputPort.execute(
	                new GetNotificationHistoryDTO(
	                    UUID.fromString(jwt.getSubject()),
	                    page,
	                    size
	                )
	            )
	        )
	    );
	}
}
