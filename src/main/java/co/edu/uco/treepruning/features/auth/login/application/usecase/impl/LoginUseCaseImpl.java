package co.edu.uco.treepruning.features.auth.login.application.usecase.impl;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginResponseDTO;
import co.edu.uco.treepruning.features.auth.login.application.usecase.LoginUseCase;
import co.edu.uco.treepruning.features.auth.login.application.usecase.domain.LoginDomain;
import co.edu.uco.treepruning.infrastructure.externalservices.notification.KeycloakAuthService;
import co.edu.uco.treepruning.infrastructure.externalservices.notification.RecaptchaService;

@Service
public class LoginUseCaseImpl implements LoginUseCase {

    private static final Logger log = LoggerFactory.getLogger(LoginUseCaseImpl.class);

    private final RecaptchaService    recaptchaService;
    private final KeycloakAuthService keycloakAuthService;

    public LoginUseCaseImpl(
            RecaptchaService recaptchaService,
            KeycloakAuthService keycloakAuthService) {
        this.recaptchaService    = recaptchaService;
        this.keycloakAuthService = keycloakAuthService;
    }

    @Override
    public LoginResponseDTO execute(LoginDomain domain) {
        log.info("LoginUseCaseImpl — attempt for user: {}", domain.getUsername());


        if (!domain.getRecaptchaToken().isBlank()) {
            boolean valid = recaptchaService.validate(domain.getRecaptchaToken());
            if (!valid) {
                throw TreePruningException.create(
                    "Verificación de seguridad fallida.",
                    "reCAPTCHA score too low or invalid token"
                );
            }
        }

        LoginResponseDTO response = keycloakAuthService.login(
            domain.getUsername(),
            domain.getPassword()
        );

        log.info("LoginUseCaseImpl — login successful for user: {}", domain.getUsername());
        return response;
    }
}