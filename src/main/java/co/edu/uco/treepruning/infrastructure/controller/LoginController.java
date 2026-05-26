package co.edu.uco.treepruning.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.auth.login.application.inputport.LoginInputPort;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginRequestDTO;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginResponseDTO;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final LoginInputPort loginInputPort;

    public LoginController(LoginInputPort loginInputPort) {
        this.loginInputPort = loginInputPort;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(
            @RequestBody LoginRequestDTO request) {

        LoginResponseDTO result = loginInputPort.execute(request);

        return ResponseEntity.ok(
            ApiResponse.ok("Sesión iniciada exitosamente.", result)
        );
    }
}
