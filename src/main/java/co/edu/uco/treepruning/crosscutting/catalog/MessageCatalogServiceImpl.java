package co.edu.uco.treepruning.crosscutting.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    // cuando los metodos con vars delegan a los metodos sin vars.
    // @Lazy evita la dependencia circular en la inicializacion del contexto.
    private final MessageCatalogService self;

    public MessageCatalogServiceImpl(WebClient strapiWebClient,
            @Lazy MessageCatalogService self) {
        this.strapiWebClient = strapiWebClient;
        this.self = self;
    }

    // ── Sin locale (default = es-CO, el locale base de Strapi) ──────────────

    @Override
    @Cacheable(value = "messages", key = "#codigo")
    public String resolve(String codigo) {
        // Sin ?locale= → Strapi devuelve su locale por defecto (es-CO = español)
        return fetchFromStrapi(codigo, null);
    }

    @Override
    public String resolve(String codigo, Map<String, Object> vars) {
        return TemplateRenderer.render(self.resolve(codigo), vars);
    }

    // ── Con locale ───────────────────────────────────────────────────────────

    @Override
    @Cacheable(value = "messages", key = "#codigo + ':' + #locale")
    public String resolve(String codigo, String locale) {
        // Para cualquier locale distinto de "en" reutilizamos la consulta sin
        // ?locale= porque el contenido español vive bajo es-CO (locale default
        // de Strapi), no bajo "es". Pasar ?locale=es devolveria vacio.
        if (!"en".equals(locale)) {
            return self.resolve(codigo);
        }
        return fetchFromStrapi(codigo, "en");
    }

    @Override
    public String resolve(String codigo, Map<String, Object> vars, String locale) {
        return TemplateRenderer.render(self.resolve(codigo, locale), vars);
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    /**
     * Consulta Strapi por codigo.
     * Si locale es null → no agrega ?locale= (Strapi devuelve el default es-CO).
     * Si locale es "en" → agrega &locale=en para obtener la traduccion en ingles.
     * Fallback: devuelve el codigo literal si Strapi no responde o no encuentra.
     */
    private String fetchFromStrapi(String codigo, String locale) {
        try {
            String uri = (locale != null)
                    ? "/api/mensajes?filters[codigo][$eq]={codigo}&filters[activo][$eq]=true&locale={locale}"
                    : "/api/mensajes?filters[codigo][$eq]={codigo}&filters[activo][$eq]=true";

            MensajeStrapiResponse response = (locale != null)
                    ? strapiWebClient.get()
                            .uri(uri, codigo, locale)
                            .retrieve()
                            .bodyToMono(MensajeStrapiResponse.class)
                            .block()
                    : strapiWebClient.get()
                            .uri(uri, codigo)
                            .retrieve()
                            .bodyToMono(MensajeStrapiResponse.class)
                            .block();

            if (response != null) {
                List<MensajeStrapiResponse.MensajeData> data = response.getData();
                if (data != null && !data.isEmpty()) {
                    return data.get(0).getTexto();
                }
            }

            log.warn("[MSG-CATALOG] Codigo '{}' no encontrado en Strapi (locale={})", codigo, locale);
            return codigo;

        } catch (Exception e) {
            log.error("[MSG-CATALOG] Error al consultar Strapi para codigo '{}' (locale={}): {}",
                    codigo, locale, e.getMessage());
            return codigo;
        }
    }
}
