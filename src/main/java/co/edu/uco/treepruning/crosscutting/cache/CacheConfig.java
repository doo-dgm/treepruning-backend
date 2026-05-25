package co.edu.uco.treepruning.crosscutting.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    // Caffeine en lugar de Redis para estos caches de catalogo y dominio.
    // Redis no es adecuado aqui: la serializacion Jackson 3.x de Spring Data
    // Redis 4.x tiene un mismatch de formato entre write y read que genera
    // errores 500. Ademas, estos datos son de una sola instancia y no necesitan
    // distribucion. Redis queda para rate limiting, idempotency keys y locks.
    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager();
        manager.setCaffeine(Caffeine.newBuilder()
                .maximumSize(500)
                .expireAfterWrite(30, TimeUnit.MINUTES));
        manager.setCacheNames(List.of(
                "messages", "statuses", "types", "sectors", "families"));
        return manager;
    }
}
