package co.edu.uco.treepruning.crosscutting.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParameterCatalogService {

    private static final Logger log = LoggerFactory.getLogger(ParameterCatalogService.class);

    private static final String STRAPI_URL =
            "https://cms.treepruning.org/api/parametros?pagination[pageSize]=100";

    private final Map<String, String> parameters = new HashMap<>();
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    public void load() {
        try {
            String json = restTemplate.getForObject(STRAPI_URL, String.class);
            JsonNode data = mapper.readTree(json).get("data");
            if (data != null && data.isArray()) {
                for (JsonNode item : data) {
                    String clave = item.get("clave").asText();
                    String valor = item.get("valor").asText();
                    parameters.put(clave, valor);
                }
            }
            log.info("[CONFIG] Parámetros cargados desde Strapi: {} entradas", parameters.size());
        } catch (Exception e) {
            log.warn("[CONFIG] No se pudo cargar el catálogo desde Strapi, usando valores por defecto. Error: {}", e.getMessage());
        }
    }

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
