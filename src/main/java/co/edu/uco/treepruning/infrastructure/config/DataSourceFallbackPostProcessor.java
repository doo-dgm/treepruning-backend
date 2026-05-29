package co.edu.uco.treepruning.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Probes PostgreSQL before Spring's auto-configuration runs.
 * If PostgreSQL is unreachable, overrides all datasource and JPA dialect
 * properties so Spring Boot wires MySQL instead — no code changes needed.
 *
 * Usa System.out en lugar de SLF4J porque este processor corre antes de que
 * el sistema de logging de Spring Boot este inicializado. Los mensajes SLF4J
 * emitidos aqui se pierden silenciosamente.
 *
 * El probe usa connectTimeout=2 y socketTimeout=2 para evitar un race condition
 * en el que pg1 esta en proceso de shutdown: el kernel todavia acepta el TCP
 * handshake pero el proceso PostgreSQL no responde.
 *
 * Registration: META-INF/spring/org.springframework.boot.env.EnvironmentPostProcessor.imports
 */
public class DataSourceFallbackPostProcessor implements EnvironmentPostProcessor, Ordered {

    private static final String PREFIX = "[DataSource] ";

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment env, SpringApplication app) {

        String enabled = env.getProperty("DATASOURCE_FALLBACK_ENABLED");
        if ("false".equalsIgnoreCase(enabled)) {
            System.out.println(PREFIX + "Fallback MySQL deshabilitado por DATASOURCE_FALLBACK_ENABLED=false.");
            return;
        }

        String pgHost = resolve(env, "POSTGRES_HOST", "localhost");
        String pgPort = resolve(env, "POSTGRES_PORT", "5432");
        String pgDb   = resolve(env, "POSTGRES_DB",   "treepruning");
        String pgUser = resolve(env, "POSTGRES_USER", "");
        String pgPass = resolve(env, "POSTGRES_PASSWORD", "");

        String pgUrl = "jdbc:postgresql://" + pgHost + ":" + pgPort + "/" + pgDb
                + "?connectTimeout=2&socketTimeout=2";

        System.out.println(PREFIX + "Probando PostgreSQL en " + pgHost + ":" + pgPort + "/" + pgDb);

        if (isReachable(pgUrl, pgUser, pgPass, "org.postgresql.Driver")) {
            System.out.println(PREFIX + "PostgreSQL disponible — usando como datasource principal.");
            return;
        }

        System.out.println(PREFIX + "PostgreSQL NO disponible. Activando fallback a MySQL.");

        String sqlHost = resolve(env, "MYSQL_HOST",     "localhost");
        String sqlPort = resolve(env, "MYSQL_PORT",     "3306");
        String sqlDb   = resolve(env, "MYSQL_DB",       "treepruning");
        String sqlUser = resolve(env, "MYSQL_USER",     "");
        String sqlPass = resolve(env, "MYSQL_PASSWORD", "");

        String sqlUrl = "jdbc:mysql://" + sqlHost + ":" + sqlPort + "/" + sqlDb
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
                + "&connectTimeout=2000&socketTimeout=2000";

        System.out.println(PREFIX + "Probando MySQL en " + sqlHost + ":" + sqlPort + "/" + sqlDb);

        if (!isReachable(sqlUrl, sqlUser, sqlPass, "com.mysql.cj.jdbc.Driver")) {
            System.err.println(PREFIX + "MySQL tampoco disponible. URL: " + sqlUrl);
            return;
        }

        System.out.println(PREFIX + "MySQL disponible — sobreescribiendo propiedades datasource.");

        Map<String, Object> overrides = new LinkedHashMap<>();
        overrides.put("spring.datasource.url",               sqlUrl);
        overrides.put("spring.datasource.username",          sqlUser);
        overrides.put("spring.datasource.password",          sqlPass);
        overrides.put("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");
        overrides.put("spring.jpa.database-platform",              "org.hibernate.dialect.MySQLDialect");
        overrides.put("spring.jpa.properties.hibernate.dialect",   "org.hibernate.dialect.MySQLDialect");
        overrides.put("spring.jpa.properties.hibernate.default_schema", "");
        overrides.put("spring.jpa.hibernate.ddl-auto", "create");
        // Hibernate 6 usa BINARY(16) para UUID en MySQL por defecto.
        // CHAR hace que los UUIDs se almacenen como cadenas legibles (ej. '928a61fa-c790-...')
        // igual que en PostgreSQL y que el formato que genera pg_dump --inserts.
        overrides.put("spring.jpa.properties.hibernate.type.preferred_uuid_jdbc_type", "CHAR");

        env.getPropertySources().addFirst(
                new MapPropertySource("datasource-fallback-mysql", overrides));

        System.out.println(PREFIX + "Propiedades datasource sobreescritas a MySQL correctamente.");
    }

    private static String resolve(ConfigurableEnvironment env, String key, String defaultValue) {
        String value = env.getProperty(key);
        return (value != null && !value.isBlank()) ? value : defaultValue;
    }

    private static boolean isReachable(String url, String user, String password, String driverClass) {
        try {
            Class.forName(driverClass);
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                return conn.isValid(2);
            }
        } catch (Exception e) {
            System.err.println(PREFIX + "Probe fallida para " + url + ": " + e.getMessage());
            return false;
        }
    }
}
