package co.edu.uco.treepruning.crosscutting.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Escucha los topics CDC de Debezium (vía Redpanda) y evita el caché
 * Redis de los catálogos cuando hay cambios en las tablas fuente.
 *
 * Topics:  treepruning.public.family
 *          treepruning.public.type
 *          treepruning.public.status
 *          treepruning.public.sector
 */
@Component
public class CatalogCacheInvalidationListener {

    private static final Logger log = LoggerFactory.getLogger(CatalogCacheInvalidationListener.class);

    private final CacheManager cacheManager;

    public CatalogCacheInvalidationListener(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @KafkaListener(topics = "treepruning.public.family",  groupId = "cache-invalidation")
    public void onFamilyChange(String message) {
        evict("families");
        log.info("[CDC] Caché 'families' invalidado por cambio en public.family");
    }

    @KafkaListener(topics = "treepruning.public.type",    groupId = "cache-invalidation")
    public void onTypeChange(String message) {
        evict("types");
        log.info("[CDC] Caché 'types' invalidado por cambio en public.type");
    }

    @KafkaListener(topics = "treepruning.public.status",  groupId = "cache-invalidation")
    public void onStatusChange(String message) {
        evict("statuses");
        log.info("[CDC] Caché 'statuses' invalidado por cambio en public.status");
    }

    @KafkaListener(topics = "treepruning.public.sector",  groupId = "cache-invalidation")
    public void onSectorChange(String message) {
        evict("sectors");
        log.info("[CDC] Caché 'sectors' invalidado por cambio en public.sector");
    }

    private void evict(String cacheName) {
        var cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cache.clear();
        }
    }
}
