package co.edu.uco.treepruning.crosscutting.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.edu.uco.treepruning.crosscutting.catalog.StrapiCatalogProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Carga parametros de configuracion desde el content-type "parametros" de Strapi.
 * Ejemplo: podas.horizonte-meses -> "12"
 *
 * Si Strapi no responde o el content-type no existe, se usan los valores por
 * defecto definidos en cada llamada a getIntValue / getValue.
 */
@Service
public class ParameterCatalogService {

    private static final Logger log = LoggerFactory.getLogger(ParameterCatalogService.class);

    private final StrapiCatalogProperties strapiProps;
    private final Map<String, String> parameters = new HashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();

    public ParameterCatalogService(StrapiCatalogProperties strapiProps) {
        this.strapiProps = strapiProps;
    }

    @PostConstruct
    public void load() {
        try {
            String url = strapiProps.getUrl() + "/api/parametros?pagination[pageSize]=100";

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + strapiProps.getToken());
            HttpEntity<String> entity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                    url, HttpMethod.GET, entity, String.class);

            String json = response.getBody();
            if (json == null) {
                log.warn("[CONFIG] Strapi devolvio cuerpo vacio para parametros, usando defaults");
                return;
            }

            JsonNode data = mapper.readTree(json).get("data");
            if (data != null && data.isArray()) {
                for (JsonNode item : data) {
                    String clave = item.path("clave").asText(null);
                    String valor = item.path("valor").asText(null);
                    if (clave != null && valor != null) {
                        parameters.put(clave, valor);
                    }
                }
            }
            log.info("[CONFIG] Parametros cargados desde Strapi: {} entradas", parameters.size());

        } catch (Exception e) {
            log.warn("[CONFIG] No se pudo cargar parametros desde Strapi, usando valores por defecto. Error: {}",
                    e.getMessage());
        }
    }

    /**
     * Retorna el valor del parametro o {@code null} si no existe.
     * Usar cuando el caller necesite manejar explicitamente la ausencia
     * (por ejemplo, lanzando una excepcion semantica del dominio).
     */
    public String getValue(String clave) {
        return parameters.get(clave);
    }

    /**
     * Retorna el valor del parametro o {@code defaultValue} si no existe.
     * Usar para parametros con un fallback razonable (por ejemplo, TTL en
     * segundos, tamano de pagina, etc.).
     */
    public String getValue(String clave, String defaultValue) {
        return parameters.getOrDefault(clave, defaultValue);
    }

    public int getIntValue(String clave, int defaultValue) {
        try {
            return Integer.parseInt(parameters.getOrDefault(clave, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
