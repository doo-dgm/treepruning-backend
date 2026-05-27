package co.edu.uco.treepruning.infrastructure.security;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private static final String ROLE_ADMIN   = "ADMIN";
    private static final String ROLE_MANAGER = "MANAGER";
    private static final String ROLE_PERSON  = "PERSON";

    private final MessageCatalogService catalog;
    // ObjectMapper no se inyecta via constructor porque la coexistencia de
    // spring-boot-starter-web y spring-boot-starter-webflux impide que Spring
    // Boot auto-configure un unico bean ObjectMapper sin ambiguedad.
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // "openapi-gen", "dev" y "local" abren /v3/api-docs sin auth para que el
    // springdoc-openapi-maven-plugin pueda capturar el spec en CI.
    // En prod requiere ADMIN. Valor leido desde APP_ENVIRONMENT (Infisical).
    @Value("${app.environment:local}")
    private String appEnvironment;

    public SecurityConfig(MessageCatalogService catalog) {
        this.catalog = catalog;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // --- Respuestas 401 / 403 en formato ApiResponse ---
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((request, response, authEx) -> {
                    response.setStatus(401);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    String message = catalog.resolve("ERROR.AUTH.UNAUTHORIZED");
                    MAPPER.writeValue(response.getWriter(), ApiResponse.error(401, message));
                })
                .accessDeniedHandler((request, response, denyEx) -> {
                    response.setStatus(403);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    String message = catalog.resolve("ERROR.AUTH.FORBIDDEN");
                    MAPPER.writeValue(response.getWriter(), ApiResponse.error(403, message));
                }))

            // --- Reglas de autorizacion por endpoint ---
            .authorizeHttpRequests(auth -> {
                // API-docs (JSON): abierto en openapi-gen/dev/local para el
                // springdoc-openapi-maven-plugin en CI. En prod requiere ADMIN.
                // Nota: Swagger UI HTML no existe (dependencia -webmvc, sin -ui).
                boolean isOpenEnv = List.of("openapi-gen", "dev", "local").contains(appEnvironment);
                if (isOpenEnv) {
                    auth.requestMatchers("/v3/api-docs/**").permitAll();
                } else {
                    auth.requestMatchers("/v3/api-docs/**").hasRole(ROLE_ADMIN);
                }

                auth
                    // Actuator: solo ADMIN en todos los entornos
                    .requestMatchers("/actuator/**").hasRole(ROLE_ADMIN)

                    // PQR: PERSON puede radicar, MANAGER y ADMIN tambien
                    .requestMatchers(HttpMethod.POST, "/api/v1/pqrs").hasAnyRole(ROLE_PERSON, ROLE_MANAGER, ROLE_ADMIN)

                    // Catalogos que PERSON necesita para llenar el formulario de PQR
                    .requestMatchers(HttpMethod.GET, "/api/v1/sectors/**").hasAnyRole(ROLE_PERSON, ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers(HttpMethod.GET, "/api/v1/statuses/**").hasAnyRole(ROLE_PERSON, ROLE_MANAGER, ROLE_ADMIN)

                    // Subida de fotos de evidencia: solo MANAGER y ADMIN
                    .requestMatchers(HttpMethod.POST, "/api/v1/photos").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)

                    // Gestion interna del arbolado: MANAGER y ADMIN
                    .requestMatchers("/api/v1/prunings/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/trees/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/quadrilles/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/persons/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/families/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/managers/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/types/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)
                    .requestMatchers("/api/v1/programmings/**").hasAnyRole(ROLE_MANAGER, ROLE_ADMIN)

                    // Login: endpoint publico, no requiere autenticacion
                    .requestMatchers("/api/v1/auth/login").permitAll()

                    // Cualquier otro endpoint: autenticado (al menos con token valido)
                    .anyRequest().authenticated();
            })
            
      

            // --- JWT Resource Server: valida tokens emitidos por Keycloak ---
            .oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwt ->
                    jwt.jwtAuthenticationConverter(keycloakJwtConverter())));

        return http.build();
    }

    /**
     * JwtDecoder con carga lazy del JWK set.
     * Deriva la URL de las claves publicas a partir del issuer URI:
     *   {kc.issuer-uri}/protocol/openid-connect/certs
     * No bloquea el arranque si Keycloak tarda en estar disponible.
     */
    @Bean
    public JwtDecoder jwtDecoder(@Value("${kc.issuer-uri}") String issuerUri) {
        String jwkSetUri = issuerUri + "/protocol/openid-connect/certs";
        NimbusJwtDecoder decoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
        decoder.setJwtValidator(JwtValidators.createDefaultWithIssuer(issuerUri));
        return decoder;
    }

    /**
     * Convierte los roles de realm de Keycloak en GrantedAuthority de Spring.
     * KeycloakRolesConverter lee realm_access.roles y agrega el prefijo ROLE_.
     */
    @Bean
    public JwtAuthenticationConverter keycloakJwtConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new KeycloakRolesConverter());
        return converter;
    }
}
