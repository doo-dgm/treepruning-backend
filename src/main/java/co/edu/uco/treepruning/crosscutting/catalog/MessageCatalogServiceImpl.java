package co.edu.uco.treepruning.crosscutting.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class MessageCatalogServiceImpl implements MessageCatalogService {

    private static final Logger log = LoggerFactory.getLogger(MessageCatalogServiceImpl.class);

    private final WebClient strapiWebClient;

    public MessageCatalogServiceImpl(WebClient strapiWebClient) {
        this.strapiWebClient = strapiWebClient;
    }

    /**
     * Resuelve el texto de un mensaje por su codigo.
     * El resultado se cachea en Caffeine durante 5 minutos.
     * Si Strapi no responde o el codigo no existe, devuelve el codigo literal
     * como fallback para que sea identificable en logs/cliente.
     */
    @Override
    @Cacheable(value = "messages", key = "#codigo")
    public String resolve(String codigo) {
        try {
            MensajeStrapiResponse response = strapiWebClient.get()
                    .uri("/api/mensajes?filters[codigo][$eq]={codigo}&filters[activo][$eq]=true", codigo)
                    .retrieve()
                    .bodyToMono(MensajeStrapiResponse.class)
                    .block();

            if (response != null) {
                List<MensajeStrapiResponse.MensajeData> data = response.getData();
                if (data != null && !data.isEmpty()) {
                    return data.get(0).getTexto();
                }
            }

            log.warn("[MSG-CATALOG] Codigo no encontrado en Strapi: {}", codigo);
            return codigo;

        } catch (Exception e) {
            log.error("[MSG-CATALOG] Error al consultar Strapi para codigo '{}': {}", codigo, e.getMessage());
            return codigo;
        }
    }

    @Override
    public String resolve(String codigo, Map<String, Object> vars) {
        return TemplateRenderer.render(resolve(codigo), vars);
    }
}
