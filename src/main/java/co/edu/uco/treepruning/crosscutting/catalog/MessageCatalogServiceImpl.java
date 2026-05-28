package co.edu.uco.treepruning.crosscutting.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MessageCatalogServiceImpl implements MessageCatalogService {

    private static final Logger log = LoggerFactory.getLogger(MessageCatalogServiceImpl.class);

    /** Locales soportados por Strapi. Cualquier otro cae a "es". */
    private static final Set<String> SUPPORTED_LOCALES = Set.of("es", "en");
    private static final String DEFAULT_LOCALE = "es";

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

    // ── Sin locale (backward-compat) ─────────────────────────────────────────

    @Override
    @Cacheable(value = "messages", key = "#codigo")
    public String resolve(String codigo) {
        return fetchFromStrapi(codigo, DEFAULT_LOCALE);
    }

    @Override
    public String resolve(String codigo, Map<String, Object> vars) {
        return TemplateRenderer.render(self.resolve(codigo), vars);
    }

    // ── Con locale ───────────────────────────────────────────────────────────

    @Override
    @Cacheable(value = "messages", key = "#codigo + ':' + #locale")
    public String resolve(String codigo, String locale) {
        // Strapi tiene el contenido en español bajo el locale regional es-CO (default),
        // no bajo "es". Para no depender de ese detalle de configuracion, cualquier
        // locale distinto de "en" usa la consulta sin ?locale= para que Strapi
        // devuelva su locale por defecto (que contiene el texto en español).
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
     * Consulta Strapi filtrando por codigo y locale.
     * Si Strapi no encuentra traduccion en el locale pedido, devuelve el codigo
     * como fallback (el frontend lo mostrara tal cual, que es mejor que silencio).
     */
    private String fetchFromStrapi(String codigo, String locale) {
        try {
            MensajeStrapiResponse response = strapiWebClient.get()
                    .uri("/api/mensajes?filters[codigo][$eq]={codigo}&filters[activo][$eq]=true&locale={locale}",
                            codigo, locale)
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
