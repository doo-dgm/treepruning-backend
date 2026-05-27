package co.edu.uco.treepruning.infrastructure.config;

import java.util.List;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion global de OpenAPI / Swagger UI.
 *
 * Define metadata de la API (titulo, version, contacto) y registra el esquema
 * de seguridad bearer-jwt para que Swagger UI muestre el boton "Authorize"
 * y permita probar endpoints autenticados pegando el token de Keycloak.
 */
@Configuration
public class OpenApiConfig {

    private static final String BEARER_SCHEME_NAME = "bearerAuth";

    /**
     * Server URL publico que se incluye en el spec. Se setea via env var
     * SERVER_PUBLIC_URL (por ejemplo, https://api-dev.treepruning.org en dev).
     * Si no esta definido, springdoc autodetecta desde el request, lo que en
     * la cadena Cloudflare -> Traefik -> Kong puede dar el puerto/protocolo
     * incorrectos. En prod este valor NO se setea (Swagger no se expone alla).
     */
    @Value("${server.public.url:}")
    private String serverPublicUrl;

    @Bean
    public OpenAPI treePruningOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        // Solo definimos servers explicitos si la variable esta presente.
        // En prod queda vacia y Swagger no se enruta publicamente (Kong no lo
        // expone), por lo que la ausencia del server es coherente.
        if (serverPublicUrl != null && !serverPublicUrl.isBlank()) {
            openAPI.servers(List.of(
                    new Server().url(serverPublicUrl).description("Dev (vis Kong)")
            ));
        }
        return openAPI
                .info(new Info()
                        .title("Tree Pruning API")
                        .version("1.0.0")
                        .description("API REST del sistema de gestion de podas preventivas del " +
                                "arbolado urbano de Rionegro. Autenticacion vis JWT emitido por Keycloak.")
                        .contact(new Contact()
                                .name("Equipo Tree Pruning - UCO")))
                .addSecurityItem(new SecurityRequirement().addList(BEARER_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(BEARER_SCHEME_NAME, new SecurityScheme()
                                .name(BEARER_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Pegar el access_token de Keycloak. Sin prefijo 'Bearer '.")));
    }
}
