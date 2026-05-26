package co.edu.uco.treepruning.infrastructure.externalservices.notification;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.features.auth.login.application.inputport.dto.LoginResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KeycloakAuthService {
	
	private static final Logger log = LoggerFactory.getLogger(KeycloakAuthService.class);
	
	@Value("${kc.issuer-uri}")
	private String issuerUri;

	@Value("${kc.client-id}")  // ← ajusta al nombre que tengas en application.properties
	private String clientId;

    private final RestTemplate restTemplate = new RestTemplate();

    public LoginResponseDTO login(String username, String password) {
    	String tokenUrl = issuerUri + "/protocol/openid-connect/token";
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("client_id",  clientId);
        body.add("username",   username);
        body.add("password",   password);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                tokenUrl,
                new HttpEntity<>(body, headers),
                Map.class
            );

            Map<?, ?> data = response.getBody();
            if (data == null) {
                throw TreePruningException.create(
                    "Error al autenticar: respuesta vacia del servidor.",
                    "KeycloakAuthService: response body is null");
            }
            return new LoginResponseDTO(
                (String) data.get("access_token"),
                (String) data.get("refresh_token"),
                (Integer) data.get("expires_in")
            );
        } catch (HttpClientErrorException e) {
            log.warn("KeycloakAuthService — login fallido: {}", e.getMessage());
            throw TreePruningException.create(
                "Usuario o contraseña incorrectos.",
                e.getMessage()
            );
        }
    }
}