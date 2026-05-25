package co.edu.uco.treepruning.crosscutting.catalog;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableCaching
@EnableConfigurationProperties(StrapiCatalogProperties.class)
public class StrapiCatalogConfig {

    @Bean
    public WebClient strapiWebClient(StrapiCatalogProperties props) {
        return WebClient.builder()
                .baseUrl(props.getUrl())
                .defaultHeader("Authorization", "Bearer " + props.getToken())
                .build();
    }
}
