package co.edu.uco.treepruning.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * properties so Spring Boot wires SQL Server instead — no code changes needed.
 *
 * Registration: META-INF/spring/org.springframework.boot.env.EnvironmentPostProcessor.imports
 */
public class DataSourceFallbackPostProcessor implements EnvironmentPostProcessor, Ordered {

    private static final Logger log = LoggerFactory.getLogger(DataSourceFallbackPostProcessor.class);

    /** Run early, but after application.properties are loaded. */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment env, SpringApplication app) {

        // ── Resolve PostgreSQL connection details ────────────────────────────
        String pgHost = resolve(env, "POSTGRES_HOST", "localhost");
        String pgPort = resolve(env, "POSTGRES_PORT", "5432");
        String pgDb   = resolve(env, "POSTGRES_DB",   "treepruning");
        String pgUser = resolve(env, "POSTGRES_USER", "");
        String pgPass = resolve(env, "POSTGRES_PASSWORD", "");

        String pgUrl  = "jdbc:postgresql://" + pgHost + ":" + pgPort + "/" + pgDb;

        if (isReachable(pgUrl, pgUser, pgPass, "org.postgresql.Driver")) {
            log.info("[DataSource] PostgreSQL disponible en {} — usando como datasource principal.", pgUrl);
            return; // Spring Boot auto-config se encarga del resto
        }

        log.warn("[DataSource] PostgreSQL NO disponible en {}. Activando fallback a SQL Server.", pgUrl);

        // ── Resolve SQL Server connection details ────────────────────────────
        String sqlHost   = resolve(env, "SQLSERVER_HOST",     "localhost");
        String sqlPort   = resolve(env, "SQLSERVER_PORT",     "1433");
        String sqlDb     = resolve(env, "SQLSERVER_DB",       "treepruning");
        String sqlUser   = resolve(env, "SQLSERVER_USER",     "sa");
        String sqlPass   = resolve(env, "SQLSERVER_PASSWORD", "");
        String sqlSchema = resolve(env, "SQLSERVER_SCHEMA",   "dbo");

        String sqlUrl = "jdbc:sqlserver://" + sqlHost + ":" + sqlPort
                + ";databaseName=" + sqlDb
                + ";encrypt=false;trustServerCertificate=true";

        if (!isReachable(sqlUrl, sqlUser, sqlPass,
                "com.microsoft.sqlserver.jdbc.SQLServerDriver")) {
            log.error("[DataSource] SQL Server tampoco está disponible en {}. "
                    + "El arranque continuará pero fallará al primer acceso a BD.", sqlUrl);
            return;
        }

        log.info("[DataSource] SQL Server disponible en {} — sobreescribiendo propiedades.", sqlUrl);

        // ── Override Spring Boot datasource + JPA properties ─────────────────
        Map<String, Object> overrides = new LinkedHashMap<>();

        // Datasource
        overrides.put("spring.datasource.url",                 sqlUrl);
        overrides.put("spring.datasource.username",            sqlUser);
        overrides.put("spring.datasource.password",            sqlPass);
        overrides.put("spring.datasource.driver-class-name",
                "com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // JPA / Hibernate
        overrides.put("spring.jpa.database-platform",
                "org.hibernate.dialect.SQLServerDialect");
        overrides.put("spring.jpa.properties.hibernate.dialect",
                "org.hibernate.dialect.SQLServerDialect");
        overrides.put("spring.jpa.properties.hibernate.default_schema", sqlSchema);

        // Highest priority source so it wins over application.properties
        env.getPropertySources().addFirst(
                new MapPropertySource("datasource-fallback-sqlserver", overrides));
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    private static String resolve(ConfigurableEnvironment env, String key, String defaultValue) {
        String value = env.getProperty(key);
        return (value != null && !value.isBlank()) ? value : defaultValue;
    }

    private static boolean isReachable(String url, String user, String password, String driverClass) {
        try {
            Class.forName(driverClass);
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                return conn.isValid(3);
            }
        } catch (Exception e) {
            log.debug("[DataSource] Prueba de conexión fallida para {}: {}", url, e.getMessage());
            return false;
        }
    }
}
