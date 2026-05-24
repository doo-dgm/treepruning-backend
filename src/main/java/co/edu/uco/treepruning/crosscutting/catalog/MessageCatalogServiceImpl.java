package co.edu.uco.treepruning.crosscutting.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class MessageCatalogServiceImpl implements MessageCatalogService {

    private static final Logger log = LoggerFactory.getLogger(MessageCatalogServiceImpl.class);

    private final WebClient strapiWebClient;

    // Self-reference via proxy: necesario para que @Cacheable funcione
    // cuando resolve(codigo, vars) delega a resolve(codigo).
    // @Lazy evita la dependencia circular en la inicializacion del contexto.
    @Lazy
    @Autowired
    private MessageCatalogService self;

    public MessageCatalogServiceImpl(WebClient strapiWebClient) {
        this.strapiWebClient = strapiWebClient;
    }

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
        return TemplateRenderer.render(self.resolve(codigo), vars);
    }
}
