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
 * properties so Spring Boot wires MySQL instead — no code changes needed.
 *
 * El probe usa connectTimeout=2&socketTimeout=2 para evitar un race condition
 * en el que pg1 está en proceso de shutdown: el kernel todavía acepta el TCP
 * handshake pero el proceso PostgreSQL no responde — sin timeout explícito el
 * probe puede bloquearse indefinidamente y considerar pg1 como "disponible".
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

        // connectTimeout=2 : aborta el TCP handshake si pg1 no responde en 2s.
        // socketTimeout=2  : aborta la lectura si pg1 acepta la conexión pero no
        //                    envía el greeting del protocolo (p.ej. proceso frozen/paused).
        // Ambos parámetros son específicos del driver PostgreSQL JDBC y no se
        // propagan al datasource real que configura Spring Boot después.
        String pgProbeUrl = "jdbc:postgresql://" + pgHost + ":" + pgPort + "/" + pgDb
                + "?connectTimeout=2&socketTimeout=2";

        if (isReachable(pgProbeUrl, pgUser, pgPass, "org.postgresql.Driver")) {
            log.info("[DataSource] PostgreSQL disponible en {}:{}/{} — usando como datasource principal.",
                    pgHost, pgPort, pgDb);
            return; // Spring Boot auto-config se encarga del resto
        }

        log.warn("[DataSource] PostgreSQL NO disponible en {}. Activando fallback a MySQL.",
                pgProbeUrl);

        // ── Resolve MySQL connection details ─────────────────────────────────
        String mysqlHost = resolve(env, "MYSQL_HOST",     "localhost");
        String mysqlPort = resolve(env, "MYSQL_PORT",     "3306");
        String mysqlDb   = resolve(env, "MYSQL_DB",       "treepruning");
        String mysqlUser = resolve(env, "MYSQL_USER",     "");
        String mysqlPass = resolve(env, "MYSQL_PASSWORD", "");

        // useSSL=false: entorno interno sin TLS entre containers.
        // allowPublicKeyRetrieval=true: necesario con mysql-connector-j 8+ y autenticación caching_sha2.
        // serverTimezone=UTC: evita ambigüedades con LocalDate/LocalDateTime en Hibernate.
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        if (!isReachable(mysqlUrl, mysqlUser, mysqlPass, "com.mysql.cj.jdbc.Driver")) {
            log.error("[DataSource] MySQL tampoco está disponible en {}. "
                    + "El arranque continuará pero fallará al primer acceso a BD.", mysqlUrl);
            return;
        }

        log.info("[DataSource] MySQL disponible en {} — sobreescribiendo propiedades.", mysqlUrl);

        // ── Override Spring Boot datasource + JPA properties ─────────────────
        Map<String, Object> overrides = new LinkedHashMap<>();

        // Datasource
        overrides.put("spring.datasource.url",               mysqlUrl);
        overrides.put("spring.datasource.username",          mysqlUser);
        overrides.put("spring.datasource.password",          mysqlPass);
        overrides.put("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");

        // JPA / Hibernate
        // MySQLDialect mapea UUID → CHAR(36), boolean → BIT(1), compatible con
        // el schema que genera el JDBC Sink de Debezium en MySQL.
        overrides.put("spring.jpa.database-platform",
                "org.hibernate.dialect.MySQLDialect");
        overrides.put("spring.jpa.properties.hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");

        // IMPORTANTE: application.properties define default_schema=public (válido
        // en PostgreSQL). En MySQL "schema" y "database" son sinónimos, y anteponer
        // "public." a cada tabla haría que Hibernate busque una BD llamada "public"
        // que no existe. Sobreescribir a vacío elimina el prefijo.
        overrides.put("spring.jpa.properties.hibernate.default_schema", "");

        // En fallback usamos "update" en lugar de "validate":
        // Debezium no replica tablas vacías (sin filas no genera eventos → el
        // JDBC Sink nunca las crea en MySQL). Con "update" Hibernate crea
        // automáticamente las tablas faltantes al arrancar en MySQL.
        // No usamos "create" para no borrar datos que sí replicó el CDC.
        overrides.put("spring.jpa.hibernate.ddl-auto", "update");

        // Highest priority source so it wins over application.properties and env vars
        env.getPropertySources().addFirst(
                new MapPropertySource("datasource-fallback-mysql", overrides));
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
                return conn.isValid(2);
            }
        } catch (Exception e) {
            log.debug("[DataSource] Prueba de conexión fallida para {}: {}", url, e.getMessage());
            return false;
        }
    }
}
