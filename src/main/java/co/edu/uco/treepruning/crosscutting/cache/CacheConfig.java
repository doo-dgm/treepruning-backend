package co.edu.uco.treepruning.crosscutting.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.Map;

@Configuration
public class CacheConfig {

    @Bean("cacheManager")
    @Primary
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        StringRedisSerializer keySerializer = new StringRedisSerializer();

        // messages: String puro de Strapi — sin JSON, legible en redis-cli, TTL 5 min
        RedisCacheConfiguration messagesConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(SerializationPair.fromSerializer(keySerializer))
                .serializeValuesWith(SerializationPair.fromSerializer(keySerializer))
                .entryTtl(Duration.ofMinutes(5));

        // dominio: JSON con type info para clases final y concretas (EVERYTHING).
        // ConstructorDetector.USE_PROPERTIES_BASED + flag -parameters en pom permiten
        // reconstruir domain classes (all-args constructor, sin no-arg) sin @JsonCreator.
        ObjectMapper mapper = new ObjectMapper()
                .setConstructorDetector(ConstructorDetector.USE_PROPERTIES_BASED)
                .activateDefaultTyping(
                        BasicPolymorphicTypeValidator.builder()
                                .allowIfSubType("co.edu.uco.treepruning")
                                .allowIfSubType("java.util")
                                .allowIfSubType("java.lang")
                                .build(),
                        ObjectMapper.DefaultTyping.EVERYTHING);

        RedisCacheConfiguration domainConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(SerializationPair.fromSerializer(keySerializer))
                .serializeValuesWith(SerializationPair.fromSerializer(
                        new GenericJackson2JsonRedisSerializer(mapper)))
                .entryTtl(Duration.ofMinutes(30));

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(domainConfig)
                .withInitialCacheConfigurations(Map.of(
                        "messages", messagesConfig,
                        "statuses", domainConfig,
                        "types",    domainConfig,
                        "sectors",  domainConfig,
                        "families", domainConfig
                ))
                .build();
    }
}
