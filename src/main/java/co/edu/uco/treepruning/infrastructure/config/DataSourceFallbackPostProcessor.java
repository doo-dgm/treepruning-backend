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
 * el sistema de logging de Spring Boot esté inicializado. Los mensajes SLF4J
 * emitidos aquí se pierden silenciosamente.
 *
 * El probe usa connectTimeout=2&socketTimeout=2 para evitar un race condition
 * en el que pg1 está en proceso de shutdown: el kernel todavía acepta el TCP
 * handshake pero el proceso PostgreSQL no responde.
 *
 * Registration: META-INF/spring/org.springframework.boot.env.EnvironmentPostProcessor.imports
 */
public class DataSourceFallbackPostProcessor implements EnvironmentPostProcessor, Ordered {

    private static final String PREFIX = "[DataSource] ";

    /** Run early, but after application.properties are loaded. */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment env, SpringApplication app) {

        // ── Allow disabling the fallback entirely (e.g. dev environment without MySQL) ──
        String enabled = env.getProperty("DATASOURCE_FALLBACK_ENABLED");
        if ("false".equalsIgnoreCase(enabled)) {
<<<<<<< Updated upstream
            log.info("[DataSource] Fallback MySQL deshabilitado por DATASOURCE_FALLBACK_ENABLED=false.");
=======
            System.out.println(PREFIX + "Fallback MySQL deshabilitado por DATASOURCE_FALLBACK_ENABLED=false.");
>>>>>>> Stashed changes
            return;
        }

        // ── Resolve PostgreSQL connection details ────────────────────────────
        String pgHost = resolve(env, "POSTGRES_HOST", "localhost");
        String pgPort = resolve(env, "POSTGRES_PORT", "5432");
        String pgDb   = resolve(env, "POSTGRES_DB",   "treepruning");
        String pgUser = resolve(env, "POSTGRES_USER", "");
        String pgPass = resolve(env, "POSTGRES_PASSWORD", "");

        // connectTimeout=2: aborta el TCP handshake si pg1 no responde en 2s.
        // socketTimeout=2:  aborta si pg1 acepta la conexión pero no envía el
        //                   greeting del protocolo (p.ej. proceso frozen/paused).
        String pgUrl = "jdbc:postgresql://" + pgHost + ":" + pgPort + "/" + pgDb
                + "?connectTimeout=2&socketTimeout=2";

        System.out.println(PREFIX + "Probando PostgreSQL en " + pgHost + ":" + pgPort + "/" + pgDb);

        if (isReachable(pgUrl, pgUser, pgPass, "org.postgresql.Driver")) {
            System.out.println(PREFIX + "PostgreSQL disponible — usando como datasource principal.");
            return;
        }

        System.out.println(PREFIX + "PostgreSQL NO disponible. Activando fallback a MySQL.");

        // ── Resolve MySQL connection details ─────────────────────────────────
        String sqlHost = resolve(env, "MYSQL_HOST",     "localhost");
        String sqlPort = resolve(env, "MYSQL_PORT",     "3306");
        String sqlDb   = resolve(env, "MYSQL_DB",       "treepruning");
        String sqlUser = resolve(env, "MYSQL_USER",     "");
        String sqlPass = resolve(env, "MYSQL_PASSWORD", "");

        // useSSL=false: entorno interno sin TLS entre containers.
        // allowPublicKeyRetrieval=true: necesario con mysql-connector-j 8+ y caching_sha2.
        // serverTimezone=UTC: evita ambigüedades con LocalDate/LocalDateTime.
        // connectTimeout/socketTimeout en ms (parámetro MySQL JDBC).
        String sqlUrl = "jdbc:mysql://" + sqlHost + ":" + sqlPort + "/" + sqlDb
<<<<<<< Updated upstream
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&connectTimeout=2000&socketTimeout=2000";
=======
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
                + "&connectTimeout=2000&socketTimeout=2000";

        System.out.println(PREFIX + "Probando MySQL en " + sqlHost + ":" + sqlPort + "/" + sqlDb);
>>>>>>> Stashed changes

        if (!isReachable(sqlUrl, sqlUser, sqlPass, "com.mysql.cj.jdbc.Driver")) {
            System.err.println(PREFIX + "MySQL tampoco disponible en " + sqlUrl
                    + ". El arranque continuará pero fallará al primer acceso a BD.");
            return;
        }

        System.out.println(PREFIX + "MySQL disponible — sobreescribiendo propiedades datasource.");

        // ── Override Spring Boot datasource + JPA properties ─────────────────
        Map<String, Object> overrides = new LinkedHashMap<>();

        overrides.put("spring.datasource.url",               sqlUrl);
        overrides.put("spring.datasource.username",          sqlUser);
        overrides.put("spring.datasource.password",          sqlPass);
        overrides.put("spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver");

        // MySQLDialect mapea UUID → CHAR(36), boolean → BIT(1).
        overrides.put("spring.jpa.database-platform",              "org.hibernate.dialect.MySQLDialect");
        overrides.put("spring.jpa.properties.hibernate.dialect",   "org.hibernate.dialect.MySQLDialect");

        // En MySQL "schema" y "database" son sinónimos; anteponer "public." rompería
        // la resolución de tablas. Sobreescribir a vacío elimina el prefijo.
        overrides.put("spring.jpa.properties.hibernate.default_schema", "");

        // "update" en fallback: Debezium no replica tablas vacías → el JDBC Sink
        // no las crea en MySQL → Hibernate las crea al arrancar con "update".
        overrides.put("spring.jpa.hibernate.ddl-auto", "update");

        // Highest priority — wins over application.properties and env vars.
        env.getPropertySources().addFirst(
                new MapPropertySource("datasource-fallback-mysql", overrides));

        System.out.println(PREFIX + "Propiedades datasource sobreescritas a MySQL correctamente.");
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
            System.err.println(PREFIX + "Probe fallida para " + url + ": " + e.getMessage());
            return false;
        }
    }
}
