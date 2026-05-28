# Tree Pruning - Backend

API REST que sostiene el sistema de gestion de arbolado urbano de Rionegro.
Implementa los casos de uso de inventario, podas preventivas, PQR ciudadanas,
notificaciones y autenticacion.

Stack: Spring Boot 4.0.6 sobre Java 26 + PostgreSQL 16 (con PostGIS planeado
para fase 2 cuando se active el mapa interactivo) + Redis (cache distribuida) +
MinIO (object storage de fotos) + Keycloak (IAM) + Strapi (catalogo de mensajes
y parametros) + Debezium/Kafka (invalidacion de cache por CDC).

El diseno detallado (arquetipo, vistas, drivers arquitectonicos) esta en
[DESIGN.md](DESIGN.md). Este README es operativo.

---

## Estructura del proyecto

Arquitectura: Clean Architecture + Vertical Slices.

```
co.edu.uco.treepruning/
+-- initializer/                                    Clase main @SpringBootApplication
+-- crosscutting/                                   Codigo transversal
|   +-- cache/                                      Config de Caffeine y Redis
|   +-- catalog/                                    Lee mensajes desde Strapi (MessageCatalogService)
|   +-- config/                                     Lee parametros desde Strapi (ParameterCatalogService)
|   +-- event/                                      Eventos de aplicacion (post-commit)
|   +-- exception/                                  TreePruningException con codigos i18n
|   +-- helper/                                     Date/Text/UUID/Object/Sanitizer helpers
|   +-- pagination/                                 PageRequest, PageResult
|   +-- response/                                   ApiResponse + GlobalExceptionHandler
|   +-- util/                                       Constantes
+-- application/                                    Contratos base (InputPort, UseCase)
+-- features/                                       Slices verticales por caso de uso
|   +-- auth/login                                  Login con username/password contra Keycloak
|   +-- family/...                                  Catalogos de familias de arboles
|   +-- manager/...                                 Gestores del municipio
|   +-- notification/                               Notificaciones push (FCM)
|   |   +-- gethistory                              Historial de notificaciones del usuario
|   |   +-- registertoken                           Registrar device token FCM
|   |   +-- sendnotification                        Enviar notificacion
|   |   +-- unregistertoken                         Borrar device token
|   +-- person/...                                  Catalogo de personas
|   +-- pqr/...                                     PQR ciudadanas
|   +-- programming/...                             Programaciones periodicas de poda
|   +-- pruning/                                    Podas
|   |   +-- schedulepreventivepruning               Crear poda preventiva (multi-arbol)
|   |   +-- getpruningbyfilter                      Listar / consultar
|   |   +-- getpruningphotourl                      Generar presigned URL de la foto
|   +-- quadrille/...                               Cuadrillas
|   +-- sector/...                                  Sectores del municipio
|   +-- status/...                                  Estados de poda
|   +-- tree/...                                    Inventario de arboles (coordenadas DECIMAL; PostGIS fase 2)
|   +-- type/...                                    Tipos de poda
+-- infrastructure/                                 Adaptadores
    +-- controller/                                 REST controllers + Swagger annotations
    |   +-- request/                                Request DTOs (records)
    +-- externalservices/
    |   +-- notification/                           FirebaseConfig, FcmService, KeycloakAuthService, RecaptchaService
    +-- persistence/
    |   +-- repository/
    |       +-- (interfaces de repositorio)
    |       +-- adapter/sql/jpa/                    Implementacion JPA + mappers MapStruct
    |       +-- entity/                             Entidades JPA
    +-- security/                                   Spring Security + JWT (OAuth2 Resource Server)
    +-- storage/                                    MinIO: PhotoStoragePort + MinioPhotoStorageAdapter
```

Cada slice sigue el patron: `inputport` (contrato de entrada + DTO +
validator + interactor + mapper) + `usecase` (contrato de negocio + domain
+ impl + rules).

---

## Dependencias clave (pom.xml)

| Dependencia | Para que |
|---|---|
| `spring-boot-starter-web` | API REST con Spring MVC |
| `spring-boot-starter-data-jpa` + `postgresql` | Persistencia con JPA + Hibernate |
| `spring-boot-starter-security` + `spring-boot-starter-oauth2-resource-server` | Validar JWT emitidos por Keycloak |
| `spring-boot-starter-webflux` | `WebClient` reactivo para llamar a Strapi |
| `spring-boot-starter-cache` + `caffeine` | Cache en memoria local |
| `spring-boot-starter-data-redis` | Cache distribuida + rate limiting + idempotency keys |
| `spring-kafka` | Consumer de los eventos CDC publicados por Debezium |
| `io.minio:minio:8.5.17` | Cliente MinIO (S3 API) |
| `firebase-admin:9.9.0` | Envio de notificaciones push (FCM) |
| `springdoc-openapi-starter-webmvc-ui:3.0.3` | Swagger UI en `/swagger-ui/index.html` (linea oficial para Spring Boot 4 / Spring Framework 7) |
| `owasp-java-html-sanitizer` | Sanitizar texto libre (observaciones, descripciones) |
| `mapstruct:1.6.3` | Mappers generados en compile time |
| `lombok` | Reducir boilerplate en entidades |
| `spring-boot-starter-actuator` + `micrometer-registry-prometheus` | Health + metricas |

---

## Variables de entorno

Las inyecta Infisical. Para correr local, exportar manualmente o usar
`infisical run`.

| Variable | Default | Notas |
|---|---|---|
| `POSTGRES_HOST` | `pg1` | nombre del service en docker |
| `POSTGRES_DB` | `treepruning_dev` | `_dev` o `_prod` segun env |
| `POSTGRES_USER` | `postgres` | |
| `POSTGRES_PASSWORD` | - | obligatoria |
| `JPA_DDL_AUTO` | `validate` | `update` en dev, `validate` en prod |
| `JPA_SHOW_SQL` | `false` | `true` en dev |
| `JPA_FORMAT_SQL` | `false` | |
| `JPA_SCHEMA` | `public` | |
| `SERVER_PORT` | `8080` | |
| `STORAGE_MINIO_ENDPOINT` | `http://tp-minio:9000` | endpoint interno |
| `STORAGE_MINIO_PUBLIC_ENDPOINT` | `https://s3.treepruning.org` | endpoint para presigned URLs |
| `STORAGE_MINIO_BUCKET` | `evidencias-dev` | `_dev` o `_prod` segun env |
| `STORAGE_MINIO_ACCESS_KEY` | `MINIO_ROOT_USER` | |
| `STORAGE_MINIO_SECRET_KEY` | `MINIO_ROOT_PASSWORD` | |
| `STORAGE_MINIO_PRESIGNED_EXPIRY` | `900` | segundos (15 min) |
| `APP_ENVIRONMENT` | `local` | `dev` o `prod` |
| `SERVER_PUBLIC_URL` | _(vacio)_ | URL publica para el OpenAPI spec. Solo set en `backend-dev`. |
| `APP_SWAGGER_PUBLIC` | `false` | `true` solo en `backend-dev` -> Swagger sin token |
| `KEYCLOAK_ISSUER_URI` | - | obligatoria; ej: `https://auth.treepruning.org/realms/tree-pruning-dev` |
| `STRAPI_URL` | `http://tp-strapi:1337` | endpoint interno del CMS |
| `STRAPI_API_TOKEN` | - | token de lectura (Strapi -> Settings -> API Tokens) |
| `REDIS_HOST` | `tp-redis` | host del cache distribuido |
| `REDIS_PASSWORD` | - | obligatoria |
| `KAFKA_BOOTSTRAP_SERVERS` | `tp-redpanda:29092` | broker Kafka para CDC |

---

## Endpoints publicos

Base path: `/api/v1`. La URL real depende del environment:

- prod (via Kong): `https://api.treepruning.org/api/v1`
- dev (directo, sin Kong): `https://api-dev.treepruning.org/api/v1`

Swagger UI: `https://api-dev.treepruning.org/swagger-ui/index.html`.

| Metodo | Path | Funcion | Auth |
|--------|------|---------|------|
| POST | `/auth/login` | Login con username/password contra Keycloak | publico |
| GET | `/prunings` | Listar podas con filtros + paginacion | bearer |
| GET | `/prunings/{id}` | Detalle de una poda | bearer |
| POST | `/prunings` | Programar poda preventiva (JSON) | bearer |
| GET | `/prunings/{id}/photo-url` | Generar presigned URLs de las fotos (lista, TTL 15 min) | bearer |
| POST | `/photos` | Subir foto a MinIO (multipart, devuelve `path`) | bearer |
| POST | `/pqrs` | Registrar PQR ciudadana | publico (con reCAPTCHA) |
| GET | `/notifications/history` | Historial de notificaciones del usuario | bearer |
| POST | `/notifications/tokens` | Registrar device token FCM | bearer |
| DELETE | `/notifications/tokens/{token}` | Borrar device token | bearer |
| GET | `/trees`, `/quadrilles`, `/types`, `/statuses`, `/sectors`, `/families`, `/programmings`, `/persons`, `/managers` | Catalogos (paginados, con filtros) | bearer |

El swagger documenta cada uno con sus campos y ejemplos.

---

## Swagger UI

URL: `https://api-dev.treepruning.org/swagger-ui/index.html` (solo `dev`).

**Defensa en profundidad — Swagger NO se expone en prod:**

| Capa | Mecanismo | Estado en dev | Estado en prod |
|---|---|---|---|
| **Kong (gateway)** | Ruta `/swagger-ui` y `/api/v1/openapi*` | enrutado | NO enrutado |
| **Spring Security** | `app.swagger.public` flag → permitAll vs `hasRole(ADMIN)` | `true` → permitAll | unset → exige ADMIN |
| **OpenAPI spec** | `server.public.url` env var → URL del server en el spec | apunta a `api-dev.treepruning.org` | unset → spec sin server URL |

**Particularidades técnicas:**

- El path canonico `/v3/api-docs` esta **bloqueado por Cloudflare WAF** (reconnaissance pattern).
  Por eso se movio a `/api/v1/openapi` via `springdoc.api-docs.path=/api/v1/openapi`.
- `server.forward-headers-strategy=framework` para que Spring respete
  `X-Forwarded-Proto/Host` enviados por Kong/Traefik al generar URLs del spec.
- `OpenApiConfig.java` declara explicitamente el server URL (via `SERVER_PUBLIC_URL`)
  para evitar que springdoc autodetecte `http://api-dev.treepruning.org:8000`
  (mezcla protocolo HTTP interno + puerto de Kong) en lugar del HTTPS publico.

---

## Flujos clave

### Login

```
Frontend -> POST /api/v1/auth/login { username, password }
Backend  -> Keycloak (Direct Access Grant)
         -> { accessToken, refreshToken, expiresIn, roles, email }
```

El frontend guarda el `accessToken` en memoria + el `refreshToken` en
storage. Lo envia como `Authorization: Bearer ...` en los siguientes
requests. El backend valida el JWT con `spring-boot-starter-oauth2-
resource-server` contra el realm de Keycloak.

### Programar poda con fotos

Las fotos se suben primero (endpoint separado) y la poda guarda las keys
devueltas:

```
1. Por cada foto:
   POST /api/v1/photos (multipart, file)
   -> { data: { path: "2026/05/{userId}/uuid.jpg" }, message: ... }

2. Unir las keys con coma sin espacios (1 o varias):
   "2026/05/userId/abc.jpg,2026/05/userId/def.jpg"

3. POST /api/v1/prunings con JSON:
   {
     "trees": ["uuid-arbol-1", "uuid-arbol-2"],          // array, 1 a 50 arboles
     "plannedDate": "2026-06-15",                         // hoy o futura
     "quadrille": "uuid-cuadrilla",
     "photographicRecordPath": "2026/05/.../a.jpg,2026/05/.../b.jpg",
     "observations": "Texto libre opcional"
   }
   -> 201 Created  { data: { count: 2 }, message: ... }
```

> El backend resuelve automaticamente tipo (`Preventiva`) y estado (`Planeada`)
> desde Strapi (coleccion `parametros`) — el cliente NO los envia. El metodo
> esta anotado `@Transactional`: el lote completo es atomico (commit o rollback
> de las N podas).

### Ver foto de una poda

Cuando alguien quiere visualizar las fotos de una poda existente:

```
GET /api/v1/prunings/{id}/photo-urls
-> { data: { urls: ["https://s3.treepruning.org/...?X-Amz-...&Expires=900", ...] } }
```

El backend genera URLs prefirmadas con expiracion de 15 minutos (config en
`STORAGE_MINIO_PRESIGNED_EXPIRY`). El bucket es privado: sin la URL firmada
no se puede acceder.

### Notificaciones push (FCM)

```
1. Frontend solicita permiso de notificacion al navegador.
2. Firebase SDK -> obtiene device token.
3. POST /api/v1/notifications/tokens { token, userAgent }
   -> el backend persiste el token asociado al usuario autenticado.

4. Cuando ocurre un evento (poda asignada, PQR vencida...):
   - Backend publica evento de aplicacion (post-commit).
   - Listener busca los tokens del destinatario.
   - FcmService envia la notificacion via firebase-admin SDK.
   - Se persiste en notification_history para mostrar despues.
```

Si Firebase no esta configurado (`FIREBASE_CREDENTIALS_PATH` no definido),
`FcmService` se deshabilita con warning y no se envian notificaciones (el
resto del sistema sigue funcionando).

### Cache + invalidacion CDC

Las consultas a catalogos (`/types`, `/statuses`, `/families`, ...)
estan cacheadas con Caffeine + Redis. TTL por default 5 minutos.

Cuando un INSERT/UPDATE/DELETE ocurre sobre `treepruning_dev` o
`treepruning_prod`:

```
PostgreSQL WAL -> Debezium (Kafka Connect) -> Redpanda (Kafka)
                                                |
                                                v
Backend (Spring Kafka consumer): tabla afectada -> CacheManager.evict(...)
```

Resultado: si alguien hace `INSERT INTO types ...` desde psql, la cache se
invalida en milisegundos y el siguiente `GET /types` lee de la DB.

### Catalogos editoriales (Strapi)

Dos servicios crosscutting leen contenido del CMS al arrancar (con refresh
periodico opcional):

- `MessageCatalogService.resolve("SUCCESS.PRUNING.SCHEDULED")` ->
  texto traducido desde Strapi (`/api/mensajes`).
- `ParameterCatalogService.getValue("podas.horizonte-meses", "12")` ->
  valor desde Strapi (`/api/parametros`). El segundo argumento es default
  si la clave no existe (el backend funciona sin Strapi en bootstrap inicial).

Las excepciones (`TreePruningException`) usan el mismo sistema: lanzan un
codigo (`VALIDATION.PRUNING.TREES_REQUIRED`) que el `GlobalExceptionHandler`
resuelve contra Strapi al construir la respuesta. Esto permite cambiar el
texto de error desde el CMS sin redeployar.

Convencion de codigos: `<CATEGORIA>.<DOMINIO>.<DETALLE>` (ej:
`ERROR.PRUNING.TREE_NOT_FOUND`, `SUCCESS.SECTOR.LIST`, `VALIDATION.PRUNING.TREES_MAX`).

---

## Sistema de excepciones

`TreePruningException.fromCode(code, technicalCode, variables)` es el
mecanismo unico para errores controlados. Ejemplo:

```java
throw TreePruningException.fromCode(
    "VALIDATION.PRUNING.PHOTO_MAX_SIZE",
    "TECHNICAL.VALIDATION.PRUNING.PHOTO_MAX_SIZE",
    Map.of("size", bytes.length));
```

El `GlobalExceptionHandler` captura, loguea el `technicalCode` con su mensaje
resuelto + stacktrace, resuelve el `code` contra Strapi con las `variables`
interpoladas (ej: "La foto supera el tamano maximo permitido ({size} bytes)")
y devuelve:

```json
{
  "status": 400,
  "message": "La foto supera el tamano maximo permitido (6291456 bytes)",
  "data": null
}
```

> Nota: la respuesta NO expone el code del catalogo al cliente. Eso se queda
> en logs para diagnostico. El cliente solo recibe el mensaje localizado.

---

## Correr local

### Opcion A: con Docker (recomendado, todo el stack)

Levanta el stack completo del repo `treepruning-infra` (incluye pg1, redis,
keycloak, minio, strapi, etc.). El backend se construye desde su propio
Dockerfile.

### Opcion B: solo el backend, contra la VM

Para iterar rapido sin levantar todo localmente:

```bash
# Exportar las vars con Infisical (necesitas credenciales)
infisical login
infisical run --env=dev --projectId=... -- ./mvnw spring-boot:run
```

El backend correra en `http://localhost:8080` y se conectara a las DBs y
servicios de la VM Azure (pg1, MinIO, Strapi). Util para debuggear sin
reconstruir la imagen.

### Compilar y empaquetar

```bash
./mvnw -DskipTests clean package
java -jar target/tree-pruning-0.0.2-SNAPSHOT.jar
```

El maven wrapper esta versionado (`.mvn/wrapper/maven-wrapper.properties`).

### Tests

```bash
./mvnw test
```

(Cobertura actual minima; pendiente expansion.)

---

## Bruno collection

La carpeta `Dev/bruno/` (no versionada en este repo) contiene una coleccion
Bruno con requests de ejemplo para todos los endpoints:

```
bruno/
+-- auth/                Obtener Token (Password) + Refrescar Token
+-- catalogos/           18 requests (listar + por ID de cada catalogo)
+-- cms/                 Mensajes desde Strapi
+-- fotos/               Subir Foto (multipart)
+-- notificaciones/      Registrar token, historial
+-- podas/               Listar, por ID, programar, URLs de fotos
+-- pqrs/                Registrar PQR
+-- environments/
    +-- dev.bru          baseUrl https://api-dev.treepruning.org/api/v1
    +-- prod.bru         baseUrl https://api.treepruning.org/api/v1
```

Setup: instalar Bruno (`https://www.usebruno.com`), abrir `Dev/bruno/` como
collection, seleccionar el environment `dev` o `prod`, llenar `username` y
`password`, ejecutar primero "Obtener Token (Password)" y el resto de
requests heredan el token automaticamente.

---

## Despliegue

Push a `develop` -> CI construye `ghcr.io/.../tree-pruning-backend:dev` ->
dispatch a infra -> recrea `tp-backend-dev`.

Push a `main` -> mismo flujo con tag `:latest` -> recrea `tp-backend`.

Ambos pipelines corren tambien `sonar:sonar` contra `sonar.treepruning.org`
con projectKey `treepruning-backend` o `TreePruning-Backend-Dev`.

Detalles del workflow en `.github/workflows/backend.yml`.

---

## Configuracion en la VM

El container `tp-backend` corre con:

```yaml
image: ghcr.io/doo-dgm/tree-pruning-backend:latest
mem_limit: 1500m
mem_reservation: 768m
healthcheck:
  test: ["CMD-SHELL", "bash -c 'exec 3<>/dev/tcp/localhost/8080' || exit 1"]
  interval: 30s
  timeout: 5s
  retries: 3
  start_period: 90s
```

Las env vars vienen de Infisical (env `prod` para `tp-backend`, env `dev`
para `tp-backend-dev`).

---

## Ver tambien

- `DESIGN.md` - Diseno de Alto Nivel (arquetipo, vistas, drivers).
- `treepruning-infra/README.md` - Como esta montada la VM.
- `treepruning-frontend/README.md` - Cliente Vue 3.
