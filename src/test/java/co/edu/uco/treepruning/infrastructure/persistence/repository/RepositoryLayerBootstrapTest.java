package co.edu.uco.treepruning.infrastructure.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 * Arranca la capa de persistencia completa sin base de datos: construye el
 * EntityManagerFactory con el dialecto de PostgreSQL y le pide a Spring Data
 * que instancie cada repositorio JPA.
 *
 * Al crear el proxy de un repositorio, Spring Data compila todas sus consultas:
 * valida las cadenas JPQL de las anotaciones @Query contra el modelo de
 * entidades y resuelve los nombres de los metodos derivados. Si una consulta
 * referencia un campo o una ruta inexistente, este test falla.
 *
 * No abre ninguna conexion JDBC (allow_jdbc_metadata_access=false), asi que no
 * necesita Postgres levantado. Las operaciones CRUD contra datos reales se
 * verifican aparte, con la base de datos de desarrollo.
 */
@DisplayName("La capa de repositorios arranca y sus consultas son validas")
class RepositoryLayerBootstrapTest {

    private static final String ENTITY_PACKAGE =
            "co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.entity";

    private static LocalContainerEntityManagerFactoryBean emfBean;
    private static EntityManagerFactory entityManagerFactory;

    @BeforeAll
    static void buildEntityManagerFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "none");
        // Evita que Hibernate abra una conexion para inspeccionar la base de datos.
        properties.put("hibernate.boot.allow_jdbc_metadata_access", false);
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", false);

        emfBean = new LocalContainerEntityManagerFactoryBean();
        emfBean.setPersistenceUnitName("verificacion-repositorios");
        emfBean.setPackagesToScan(ENTITY_PACKAGE);
        emfBean.setDataSource(unusableDataSource());
        emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfBean.setJpaPropertyMap(properties);
        emfBean.afterPropertiesSet();

        entityManagerFactory = emfBean.getObject();
    }

    @AfterAll
    static void closeEntityManagerFactory() {
        if (emfBean != null) {
            emfBean.destroy();
        }
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(classes = {
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.AdministratorJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.CountryJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.DocumentJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.FamilyJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ManagerJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.MunicipalityJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.NotificationHistoryJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.NotificationTokenJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.OperatorJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PQRJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PersonJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ProgrammingJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.PruningToolJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.QuadrilleJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.RiskJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.SectorJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.StateJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.StatusJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.ToolJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TreeJPARepository.class,
        co.edu.uco.treepruning.infrastructure.persistence.repository.sql.jpa.TypeJPARepository.class
    })
    void cadaRepositorioCompilaSusConsultas(Class<?> repositoryInterface) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Object repository = new JpaRepositoryFactory(entityManager).getRepository(repositoryInterface);
            assertNotNull(repository);
        } finally {
            entityManager.close();
        }
    }

    /**
     * DataSource que falla si alguien intenta conectarse: deja en evidencia
     * cualquier acceso a JDBC durante el arranque en vez de ocultarlo.
     */
    private static DataSource unusableDataSource() {
        return (DataSource) java.lang.reflect.Proxy.newProxyInstance(
                RepositoryLayerBootstrapTest.class.getClassLoader(),
                new Class<?>[] { DataSource.class },
                (proxy, method, args) -> {
                    if ("getConnection".equals(method.getName())) {
                        throw new UnsupportedOperationException(
                                "El arranque de la capa de persistencia no debe abrir conexiones JDBC");
                    }
                    if ("toString".equals(method.getName())) {
                        return "unusableDataSource";
                    }
                    if ("hashCode".equals(method.getName())) {
                        return System.identityHashCode(proxy);
                    }
                    if ("equals".equals(method.getName())) {
                        return proxy == args[0];
                    }
                    if ("isWrapperFor".equals(method.getName())) {
                        return Boolean.FALSE;
                    }
                    return null;
                });
    }
}
