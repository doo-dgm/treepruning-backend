# Documento de Arquitectura de Software (DAS)
## Tree Pruning — Sistema de Gestión de Arbolado Urbano

**Proyecto:** Tree Pruning  
**Universidad:** Universidad Católica de Oriente (UCO)  
**Curso:** Software 2  
**Municipio:** Rionegro, Antioquia, Colombia  

---

<a id="sec-cc"></a>
## Control de Cambios y Revisiones

| Versión | Fecha | Tipo | Descripción | Autor |
|---|---|---|---|---|
| 1.0 | 2024-08-01 | Creación | Versión inicial del documento | Equipo Tree Pruning |
| 2.0 | 2025-01-15 | Revisión | Actualización plataforma tecnológica: Azure VM, Traefik, Infisical | Equipo Tree Pruning |
| 2.1 | 2025-05-15 | Actualización | Ajuste de bloques de construcción: Bootstrap 5.3+, Java 26, Eclipse IDE, Infisical reemplaza Vault | Equipo Tree Pruning |
| 2.2 | 2025-05-18 | Actualización | Ampliación de restricciones técnicas: prácticas de diseño, marco metodológico, DevOps, código limpio, patrones de diseño y prácticas de desarrollo | Equipo Tree Pruning |
| 2.3 | 2026-05-18 | Alineación | Alineación con la plantilla institucional del DAS (UCO): se agregan secciones de Justificación Alternativa de Solución, Estilos y Patrones Arquitectónicos, Modelo de Mapeo de Contextos, Modelos Anémico/Enriquecido, Especificación de Requisitos de Software (RU/RF/RNF/RI/RN), Project Canvas, Caja de Producto, Mapa de Historias, Tallaje, Release Plan, Trade-off de Atributos de Calidad y Costo del Proyecto | Equipo Tree Pruning |
| 2.4 | 2026-05-18 | Integración | Integración de Historias de Usuario asociadas a Funcionalidades Críticas, Caracterización detallada del Modelo de Dominio (21 objetos con atributos, combinaciones únicas, responsabilidades y muestreos), Especificación detallada de Casos de Uso de los módulos PQR (CU-12 a CU-14) y Reportes (CU-15 a CU-18), Anexos A (Matriz de Tiempos), B (Matriz de Permisos por Rol) y C (Disponibilidad y SLA). Adición de placeholders de imágenes para todos los diagramas requeridos por la plantilla | Equipo Tree Pruning |
| 3.5 | 2026-05-18 | Numeración profunda | Aplicación completa de numeración jerárquica a todas las sub-sub-secciones restantes: 6 Características de atributos de calidad (3.3.1.1, 3.3.2.1-2, 3.3.3.1-2, 3.3.4.1), 13 sub-secciones de Vista Funcional (10.1.2.1-3 Modelado de Dominio, 10.1.5.1-5 Requisitos, 10.1.6.1-5 Casos de Uso), 8 sub-secciones de Incepción Ágil (10.2.2.1-2 Visión, 10.2.5.1-2 Lo Que Sí/No, 10.2.9.1-2 Tamaño, 10.2.11.1-2 Costo), promoción de las etiquetas bold de los Estilos Arquitectónicos a sub-secciones numeradas (8.2.1.1-3, 8.2.2.1-3, 8.2.3.1-3 con Nombre/Problema/Solución), y numeración del Anexo C (C.1 a C.4). Todas las anclas HTML existentes se mantienen intactas | Equipo Tree Pruning |
| 3.4 | 2026-05-18 | Estructura interna del dominio | Refinamiento de la Caracterización Detallada de Objetos de Dominio (sección 10.3.2): los 20 objetos del dominio reciben numeración jerárquica (10.3.2.1 País hasta 10.3.2.20 PodaHerramienta), y dentro de cada objeto las cuatro partes internas (Atributos, Combinaciones únicas, Responsabilidades y políticas, Muestreo de datos) pasan de texto en negrita a sub-secciones reales mediante encabezados H6, lo que mejora la navegación visual y permite identificar rápidamente cada parte de la caracterización de un objeto específico (ej. cuando se quiere consultar solo las responsabilidades y políticas de Familia) | Equipo Tree Pruning |
| 3.3 | 2026-05-18 | Numeración jerárquica | Adición de numeración jerárquica completa a todas las sub-secciones de las Vistas de Arquitectura (sección 10): 10.1.1 a 10.1.6 (Vista Funcional), 10.2.1 a 10.2.11 (Incepción Ágil), 10.3.1 a 10.3.3 (Vista Lógica), 10.4.1 a 10.4.4 (Vista de Despliegue), 10.5.1 a 10.5.3 (Vista de Procesos), 10.6.1 (Vista Física). También se agrega numeración consistente a la Línea Base Arquitectónica (8.1.1, 8.1.2 para Componentes; 8.2.1, 8.2.2, 8.2.3 para Estilos eliminando el prefijo redundante "Estilo X:"). Total: 33 sub-secciones numeradas jerárquicamente, con TOC sincronizado | Equipo Tree Pruning |
| 3.2 | 2026-05-18 | Generalización Paquetes Backend | Refinamiento del Diagrama de Paquetes del Backend (sección 10.4.3): la estructura pasa de un listado exhaustivo con todos los archivos concretos (~140 líneas con nombres específicos como `CountryEntityMapper`, `PQRJPAEntity`, etc.) a una representación general con placeholders `<domain-object>` y `<transaction>` que comunica el patrón aplicable a cualquier feature, alineado con el diagrama UML que el equipo construye en StarUML. Se mantiene la tabla de responsabilidades por paquete, el flujo de una solicitud y la justificación de la decisión arquitectónica | Equipo Tree Pruning |
| 3.1 | 2026-05-18 | Diagrama de Componentes Frontend | Adición del Diagrama de Componentes del Frontend (nueva sección 10.4.2) que faltaba según la plantilla del DAS, que pide diagrama de componentes para cada componente principal del sistema. Se documenta la SPA Vue.js 3 con sus dependencias hacia Vue Router 4, Pinia, Axios (con interceptores JWT), Bootstrap 5.3+, Google Maps Platform SDK, Firebase Cloud Messaging SDK y Vue I18n, incluyendo las relaciones clave entre componentes y el flujo de empaquetado vía GitHub Actions → GHCR → nginx. Renumeración de anclas: sec-10-4-2 ahora apunta a Componentes Frontend, Paquetes Backend pasa a sec-10-4-3 y Paquetes Frontend (que no tenía ancla) recibe sec-10-4-4. TOC actualizado | Equipo Tree Pruning |
| 3.0 | 2026-05-18 | Diagrama de Paquetes Backend | Actualización del Diagrama de Paquetes del Backend (sección 10.4.2) para reflejar la estructura real implementada por el equipo. La organización pasa de una estructura plana de Clean Architecture (`domain` / `application` / `infrastructure`) a una organización híbrida de **Vertical Slice + Clean Architecture**, donde cada caso de uso es un slice vertical completo dentro del paquete `features/<módulo>/<caso-de-uso>` con su propio inputport, DTO, validador, interactor, use case, dominio y reglas de negocio. Se documenta la estructura interna estándar de cada feature (con ejemplos `getfamilybyfilter` simple y `schedulepreventivepruning` con reglas de negocio), la responsabilidad de cada paquete y el flujo de una solicitud a través de las capas | Equipo Tree Pruning |
| 2.9 | 2026-05-18 | Alineación plantilla | Adición de definiciones conceptuales al inicio de 7 sub-secciones según lo solicitado por la plantilla del DAS ("Defina en términos comprensibles qué es..."): Propósito (visión explícita), 8.2 (estilos y patrones), Glosario de términos, Diagrama de clases, Diagrama de componentes, Diagrama de paquetes, Diagrama de secuencia | Equipo Tree Pruning |
| 2.8 | 2026-05-18 | Restructuración | Aclaración conceptual de Restricciones Técnicas vs Decisiones de Diseño. La sección 3.1.1 se reduce a las dos restricciones REALES impuestas por el curso (Java 26 + Spring Boot 3.3+ y CI/CD con GitHub Actions). El resto de tecnologías del stack (PostgreSQL 16 + PostGIS, Vue.js 3 + Bootstrap 5.3+, Azure VM + Docker Compose, Traefik, Infisical, Eclipse IDE y Layered N-Capas con Clean Architecture) se documentan como decisiones de diseño en la sección 9.1, con justificación detallada por cada una incluyendo alternativas consideradas, criterios de evaluación y razón de la elección | Equipo Tree Pruning |
| 2.7 | 2026-05-18 | Navegación | Expansión de la Tabla de Contenido para incluir todas las subsecciones (3.1.1–3.4.1, 8.1.1–8.2.3 y 10.1.1–10.6.1) con sus respectivas anclas HTML, mejorando la navegación dentro de las vistas de arquitectura | Equipo Tree Pruning |
| 2.6 | 2026-05-18 | Detalle | Ampliación de la Caracterización Detallada de Objetos de Dominio (sección 10.3): cada uno de los 20 objetos de dominio pasa de un resumen en formato párrafo a una especificación completa con tablas de atributos (tipo, longitudes, obligatoriedad, sensibilidad, calculado, filtro, listar, ordenable, visible), combinaciones únicas, responsabilidades con políticas asociadas (POL-01 a POL-N por objeto) y muestreos de datos representativos | Equipo Tree Pruning |
| 2.5 | 2026-05-18 | Refinamiento | Reubicación de la Caracterización Detallada de Objetos de Dominio desde el modelado de dominio (10.1.5) a la Vista Lógica (10.3), donde corresponde estructuralmente al diseño de clases, persistencia y base de datos. Adición de Tabla de Contenido navegable con anclas HTML al inicio del documento y enlaces "Volver al inicio" al final de cada sección principal | Equipo Tree Pruning |

---

<a id="toc"></a>

## Tabla de Contenido

Esta tabla de contenido permite navegar el documento haciendo clic en cualquier sección. Al final de cada sección principal hay un enlace que regresa aquí.

- [Control de Cambios](#sec-cc)
- [2. Propósito del Proyecto](#sec-2)
- [3. Motivadores de la Arquitectura](#sec-3)
  - [3.1 Restricciones Técnicas](#sec-3-1)
    - [3.1.1 Restricciones de Plataforma Tecnológica](#sec-3-1-1)
    - [3.1.2 Restricciones de Ingeniería de Software](#sec-3-1-2)
  - [3.2 Restricciones de Negocio](#sec-3-2)
    - [3.2.1 Restricciones Humanas](#sec-3-2-1)
    - [3.2.2 Restricciones Legales/Normativas](#sec-3-2-2)
    - [3.2.3 Restricciones de Presupuesto/Costos](#sec-3-2-3)
    - [3.2.4 Restricciones de Tiempo](#sec-3-2-4)
    - [3.2.5 Restricciones de Alcance](#sec-3-2-5)
    - [3.2.6 Restricciones Operativas](#sec-3-2-6)
  - [3.3 Atributos de Calidad](#sec-3-3)
    - [3.3.1 Rendimiento](#sec-3-3-1)
    - [3.3.2 Confiabilidad](#sec-3-3-2)
    - [3.3.3 Seguridad](#sec-3-3-3)
    - [3.3.4 Disponibilidad](#sec-3-3-4)
    - [3.3.5 Escalabilidad](#sec-3-3-5)
    - [3.3.6 Trazabilidad](#sec-3-3-6)
    - [3.3.7 Usabilidad](#sec-3-3-7)
  - [3.4 Funcionalidades Críticas](#sec-3-4)
    - [3.4.1 Historias de Usuario asociadas a las Funcionalidades Críticas](#sec-3-4-1)
- [4. Tácticas y Estrategias](#sec-4)
  - [4.1 Tácticas para Rendimiento](#sec-4-1)
  - [4.2 Tácticas para Confiabilidad](#sec-4-2)
  - [4.3 Tácticas para Seguridad](#sec-4-3)
  - [4.4 Tácticas para Disponibilidad](#sec-4-4)
  - [4.5 Tácticas para Escalabilidad](#sec-4-5)
  - [4.6 Tácticas para Trazabilidad](#sec-4-6)
  - [4.7 Tácticas para Usabilidad](#sec-4-7)
- [5. Modelo de Contexto](#sec-5)
- [6. Arquetipo de Solución/Referencia](#sec-6)
- [7. Arquitectura de Solución/Referencia](#sec-7)
- [8. Línea Base Arquitectónica](#sec-8)
  - [8.1 Línea Base de Componentes](#sec-8-1)
    - [8.1.1 Componente: Frontend Tree Pruning](#sec-8-1-1)
    - [8.1.2 Componente: Backend Tree Pruning](#sec-8-1-2)
  - [8.2 Estilos y Patrones Arquitectónicos Adoptados](#sec-8-2)
    - [8.2.1 Layered N-Capas (Arquitectura en Capas)](#sec-8-2-1)
    - [8.2.2 Event-Driven (Eventos de Dominio)](#sec-8-2-2)
    - [8.2.3 Microservicios de Soporte (Management Layer)](#sec-8-2-3)
- [9. Justificación Alternativa de Solución](#sec-9)
  - [9.1 Justificación](#sec-9-1)
  - [9.2 Ventajas](#sec-9-2)
  - [9.3 Desventajas](#sec-9-3)
- [10. Vistas de Arquitectura del Sistema](#sec-10)
  - [10.1 Vista Funcional / Vista de Escenarios / Vista de Casos de Uso](#sec-10-1)
    - [10.1.1 Modelo de Procesos del Negocio](#sec-10-1-1)
    - [10.1.2 Modelado de Dominio (Contextos Acotados, Mapeo, Modelos por Contexto)](#sec-10-1-2)
    - [10.1.3 Flujo de Eventos / Event Storming](#sec-10-1-3)
    - [10.1.4 Glosario de Términos del Negocio](#sec-10-1-4)
    - [10.1.5 Especificación de Requisitos de Software (RU, RF, RNF, RI, RN)](#sec-10-1-5)
    - [10.1.6 Casos de Uso (Contexto, Diagramas por Módulo, Especificaciones)](#sec-10-1-6)
  - [10.2 Incepción Ágil](#sec-10-2)
    - [10.2.1 Por Qué Estamos Aquí](#sec-10-2-1)
    - [10.2.2 Visión / Elevator Pitch (Visión, Project Canvas)](#sec-10-2-2)
    - [10.2.3 Mapa de Impacto](#sec-10-2-3)
    - [10.2.4 Caja de Producto](#sec-10-2-4)
    - [10.2.5 Lo Que Sí, Lo Que No (Mapa de Historias, Product Backlog Item)](#sec-10-2-5)
    - [10.2.6 La Comunidad](#sec-10-2-6)
    - [10.2.7 La Solución](#sec-10-2-7)
    - [10.2.8 Los Riesgos / Los Miedos](#sec-10-2-8)
    - [10.2.9 Tamaño / Talla de Historias de Usuario (Tallaje, Release Plan)](#sec-10-2-9)
    - [10.2.10 Trade-off de Atributos de Calidad](#sec-10-2-10)
    - [10.2.11 Cuánto Cuesta (Definiciones, Coste detallado)](#sec-10-2-11)
  - [10.3 Vista Lógica](#sec-10-3)
    - [10.3.1 Diagrama de Clases — Dominio Principal](#sec-10-3-1)
    - [10.3.2 Caracterización Detallada de Objetos de Dominio (20 entidades)](#sec-10-3-2)
    - [10.3.3 Diagrama de Objetos](#sec-10-3-3)
  - [10.4 Vista de Despliegue / Vista de Implementación](#sec-10-4)
    - [10.4.1 Diagrama de Componentes — Backend](#sec-10-4-1)
    - [10.4.2 Diagrama de Componentes — Frontend](#sec-10-4-2)
    - [10.4.3 Diagrama de Paquetes — Backend](#sec-10-4-3)
    - [10.4.4 Diagrama de Paquetes — Frontend](#sec-10-4-4)
  - [10.5 Vista de Procesos](#sec-10-5)
    - [10.5.1 Diagrama de Secuencia — Backend (Transacción general)](#sec-10-5-1)
    - [10.5.2 Diagrama de Secuencia — Frontend (Transacción general)](#sec-10-5-2)
    - [10.5.3 Diagrama de Colaboración — Registro de Poda Ejecutada](#sec-10-5-3)
  - [10.6 Vista Física / Vista de Implantación](#sec-10-6)
    - [10.6.1 Diagrama de Despliegue](#sec-10-6-1)
- [11. Anexos](#sec-11)
  - [Anexo A — Matriz de Tiempos por Operación](#sec-anexo-a)
  - [Anexo B — Matriz de Permisos por Rol](#sec-anexo-b)
  - [Anexo C — Disponibilidad y SLA](#sec-anexo-c)
- [12. Índice de Imágenes Requeridas](#sec-12)

<a id="sec-2"></a>
## 2. Propósito del Proyecto

El propósito del proyecto define de forma clara y comprensible la **visión** que orienta el desarrollo del sistema: el problema concreto que se va a resolver, los beneficios que se obtendrán, y el resultado esperado para los usuarios y el cliente. Esta declaración es el punto de partida que alinea al equipo de desarrollo, al cliente municipal y a los demás interesados en torno a un mismo objetivo, y sirve de referencia para validar que las decisiones de diseño contribuyen al cumplimiento de dicha visión.

Tree Pruning es un sistema web para la gestión integral del arbolado urbano del municipio de Rionegro, Antioquia. El municipio enfrenta actualmente una gestión manual de podas en Excel y Word, sin trazabilidad de intervenciones, sin georreferenciación del inventario y sin canales formales para PQR ciudadanas sobre el estado del arbolado.

Esta situación genera riesgos de accidentes por caída de árboles sobre personas, vehículos e infraestructura, expone al municipio a responsabilidad legal por omisión, e impide la toma de decisiones fundamentadas sobre intervenciones preventivas.

Tree Pruning digitaliza y centraliza la planificación de podas, el inventario georreferenciado de árboles, la gestión de cuadrillas operativas y las PQR ciudadanas, para que el municipio pueda prevenir accidentes, cumplir la normativa ambiental y dar respuesta oportuna a la comunidad.

**Visión del producto:**

> *Para la Administración municipal de Rionegro y empresas de servicios que necesitan optimizar la planificación y ejecución de podas en el espacio público, enfrentando actualmente falta de control, Tree Pruning es un aplicativo web que previene accidentes por caída de árboles sobre personas, vehículos e infraestructura, eliminando la exposición legal del municipio. A diferencia de procesos manuales en Excel y Word, soluciones del mercado como TreePlotter CANOPY y ArboMap, así como herramientas generales, nuestro producto ofrece gestión integral enfocada en el inventario de árboles, planificación de podas, PQR ciudadanas y cuadrillas de poda para Rionegro.*

El sistema atiende a tres actores: **Administrador del sistema**, **Encargado de cuadrilla** y **Ciudadano**, cada uno con acceso restringido mediante RBAC a los módulos correspondientes a su rol.

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-3"></a>
## 3. Motivadores de la Arquitectura

Los motivadores de la arquitectura son el conjunto de restricciones, atributos de calidad y funcionalidades críticas que condicionan las decisiones de diseño del sistema. Para Tree Pruning se identificaron motivadores en tres dimensiones: restricciones técnicas, restricciones de negocio y atributos de calidad priorizados.

<a id="sec-3-1"></a>
### 3.1 Restricciones Técnicas

Las restricciones técnicas son condiciones impuestas por el entorno tecnológico que limitan las alternativas de diseño disponibles y guían hacia soluciones específicas. Se organizan en dos grupos: restricciones de plataforma tecnológica, que definen el stack y la infraestructura del sistema, y restricciones de ingeniería de software, que establecen las prácticas, patrones y metodologías obligatorias durante el desarrollo.

<a id="sec-3-1-1"></a>
#### 3.1.1 Restricciones de Plataforma Tecnológica

A diferencia de una decisión de diseño, una restricción de plataforma tecnológica es una condición **impuesta externamente** (por el cliente, el contexto académico, una normativa o un proveedor) que el equipo no puede cambiar y que debe asumir como punto de partida del diseño. Para Tree Pruning se identifican dos restricciones de plataforma tecnológica derivadas del contexto académico del curso Software 2 de la Universidad Católica de Oriente:

| Código | Descripción | Origen | Impacto en el diseño |
|---|---|---|---|
| **RT-001** | El sistema debe desarrollarse en Java 26 con Spring Boot 3.3+ | Requerimiento académico del curso Software 2 (UCO) | Condiciona el stack del Backend y la elección del JDK en el Dockerfile (`eclipse-temurin:26-jdk-alpine`). Restringe el uso de plugins de Maven y librerías que aún no soporten Java 26. |
| **RT-002** | El código fuente debe mantenerse en repositorio Git con pipelines de Integración Continua y Entrega Continua (CI/CD) | Requerimiento académico del curso Software 2 (UCO) | Condiciona el flujo de trabajo del equipo. Implica el uso de GitHub + GitHub Actions, automatización de compilación, pruebas, construcción de imágenes Docker y despliegue. |

> **Nota importante sobre el resto de tecnologías del stack:** El resto de tecnologías del sistema (PostgreSQL 16 + PostGIS, Vue.js 3 + Bootstrap 5.3+, Azure VM + Docker Compose, Traefik, Infisical, Eclipse IDE, arquitectura Layered N-Capas con Clean Architecture) **no constituyen restricciones** impuestas externamente, sino **decisiones de diseño** tomadas por el equipo para resolver el problema bajo las restricciones reales del proyecto. La justificación detallada de cada una de estas decisiones —incluyendo las alternativas que se consideraron y por qué fueron descartadas— se desarrolla en la **[sección 8.2 — Estilos y Patrones Arquitectónicos Adoptados](#sec-8-2)** (decisiones de estilo arquitectónico) y en la **[sección 9 — Justificación Alternativa de Solución](#sec-9)** (decisiones de tecnologías concretas).

<a id="sec-3-1-2"></a>
#### 3.1.2 Restricciones de Ingeniería de Software

| Código | Tipo | Restricción | Justificación en el contexto de Tree Pruning |
|---|---|---|---|
| **RT-ING-001** | Prácticas de diseño | El diseño y desarrollo del sistema Tree Pruning debe propender por seguir los principios SOLID. | Aplicar los principios SOLID permite que cada módulo del sistema (Administración, Reportes, Podas y PQR) tenga responsabilidades claramente definidas y sea extensible de forma independiente. El principio de responsabilidad única garantiza que la lógica de planificación de podas preventivas no se mezcle con la lógica de notificación automática a cuadrillas, y el principio de abierto/cerrado permite incorporar nuevos tipos de intervención forestal sin modificar los módulos de registro ya construidos. Esto reduce el riesgo de regresiones al evolucionar el sistema y facilita el trabajo colaborativo sobre una base de código organizada. |
| **RT-ING-002** | Prácticas de diseño | El sistema debe propender por la adopción del Manifiesto de Aplicaciones Reactivas. | Tree Pruning debe atender simultáneamente solicitudes del Administrador del sistema, Encargados de Cuadrilla y Ciudadanos, quienes interactúan con módulos distintos de forma concurrente. El módulo de PQR debe responder ágilmente a solicitudes ciudadanas, el módulo de Reportes debe generar y exportar informes sin bloquear otras operaciones, y el módulo de Podas debe notificar automáticamente a los usuarios involucrados en la programación. Adoptar los principios del Manifiesto Reactivo (receptivo, resiliente, elástico y orientado a mensajes) proporciona la base para diseñar un sistema que responda adecuadamente frente al uso concurrente y que se recupere ante fallos parciales sin afectar la totalidad del servicio. |
| **RT-ING-003** | Prácticas de diseño | Propender por la adopción del Well-Architected Framework en el diseño del sistema. | El Well-Architected Framework provee directrices para abordar los cinco pilares relevantes en Tree Pruning: el manejo operativo de la gestión de podas y cuadrillas, la seguridad en el control de acceso por roles (Administrador, Encargado de Cuadrilla, Ciudadano), la confiabilidad en la persistencia del inventario de árboles y el historial de podas, el rendimiento en la carga del mapa georreferenciado y la generación de reportes, y la optimización de costos para garantizar la sostenibilidad económica de la solución para el municipio de Rionegro. |
| **RT-ING-004** | Marco metodológico | Hacer uso del framework SCRUM para el desarrollo ágil del sistema Tree Pruning. | Tree Pruning comprende cuatro módulos interdependientes (Administración, Reportes, Podas y PQR) con funcionalidades que pueden evolucionar según las necesidades del municipio de Rionegro. SCRUM permite organizar el desarrollo en sprints incrementales priorizando las funcionalidades críticas como el inventario de árboles con atributos, la planificación de podas preventivas y el registro de PQR ciudadanas; incorporar retroalimentación continua del cliente municipal; y garantizar entregas parciales funcionales que reduzcan el riesgo de construir funcionalidades que no se alineen con las necesidades reales de los actores del sistema. |
| **RT-ING-005** | Prácticas DevOps | Propender por el uso de prácticas DevOps en el ciclo de vida del sistema Tree Pruning. | La operación continua de Tree Pruning es crítica para el municipio dado que los retrasos en la atención de PQR ciudadanas, el riesgo de accidentes por árboles en mal estado y el incumplimiento de podas programadas representan consecuencias directas de la indisponibilidad del sistema. Las prácticas DevOps permiten automatizar las pruebas de los módulos críticos de seguridad y trazabilidad, agilizar el despliegue de nuevas versiones sin interrumpir el servicio durante el horario laboral, y monitorear continuamente el comportamiento del sistema en producción para detectar fallos antes de que afecten a los Encargados de Cuadrilla o a los ciudadanos que realizan seguimiento a sus PQR. |
| **RT-ING-006** | Prácticas DevOps | Propender por la adopción de los 12 factores de aplicación (más los 3 extendidos) en el desarrollo del sistema Tree Pruning. | Adoptar los 12 factores en Tree Pruning garantiza que el sistema pueda desplegarse y operarse de forma portable en la infraestructura tecnológica del municipio de Rionegro, que el acceso a la base de datos y las claves de integración con Google Maps Platform y Firebase Cloud Messaging se gestionen de forma segura mediante configuración de entorno (variables de Infisical), y que el sistema escale adecuadamente ante el crecimiento del inventario de árboles y el aumento de solicitudes ciudadanas de poda, garantizando la confiabilidad del servicio como atributo intrínseco para su operación municipal sostenida. |
| **RT-ING-007** | Prácticas de código limpio | Propender por la aplicación de prácticas de código limpio (Clean Code), evitando Messy Code y Code Smells en el desarrollo del sistema Tree Pruning. | Tree Pruning puede incorporar nuevas funcionalidades municipales a lo largo del tiempo. Aplicar Clean Code mediante nombres descriptivos en variables, métodos y clases de los módulos de Administración, Podas, Reportes y PQR; funciones de responsabilidad única; y eliminación de código duplicado, facilita la comprensión del código por parte de todos los integrantes del equipo, reduce la probabilidad de errores en lógicas críticas como el control de acceso por roles, la trazabilidad de acciones del usuario y la generación automática de informes, y disminuye los costos de corrección y mantenimiento futuro del sistema. |
| **RT-ING-008** | Patrones de diseño | Propender por el uso de patrones de diseño y de implementación como patrones GoF, GRASP, DRY y KISS en el desarrollo del sistema Tree Pruning. | En Tree Pruning, el patrón Observer (GoF) puede aplicarse para las notificaciones automáticas a usuarios involucrados en la programación de podas, y Factory para la generación de diferentes tipos de reportes. Los principios GRASP permiten asignar responsabilidades de forma clara entre las capas del sistema, evitando que la lógica de negocio de módulos como PQR o Podas quede acoplada a la capa de infraestructura. DRY evita duplicar la lógica de validación de formularios compartida entre los módulos de registro de árboles, podas y PQR. KISS garantiza soluciones simples y comprensibles reduciendo la complejidad innecesaria en módulos como la ubicación de árboles mediante GPS y la visualización en mapa. |
| **RT-ING-009** | Prácticas de desarrollo | Propender por la aplicación del Cloud Adoption Framework en el despliegue del sistema Tree Pruning. | El Cloud Adoption Framework proporciona una guía para planificar el despliegue del sistema en infraestructura en la nube, teniendo en cuenta aspectos como la seguridad de la información municipal del arbolado urbano de Rionegro, estrategias de gestión del cambio para la adopción del sistema por parte del Administrador municipal y los Encargados de Cuadrilla, y sostenibilidad económica que garantice que el costo de operación en la nube sea asumible para el municipio a largo plazo, evitando infraestructura costosa que ponga en riesgo la continuidad del proyecto. |

<a id="sec-3-2"></a>
### 3.2 Restricciones de Negocio

Las restricciones de negocio son condicionantes impuestos por el contexto organizacional, legal, económico, humano o temporal del proyecto que delimitan el espacio de soluciones viables y que el equipo debe asumir como hechos no negociables al momento de diseñar. A diferencia de las restricciones técnicas (sección 3.1), estas no provienen del entorno tecnológico sino del contexto del cliente y del modo en que el proyecto se ejecuta.

Para Tree Pruning se identificaron veinte restricciones agrupadas en seis categorías. Las primeras cinco categorías (Humano, Legal/Normativo, Presupuesto/Costos, Tiempo y Alcance) corresponden a riesgos del proyecto y para cada una se documenta su importancia, los riesgos asociados y el plan de acción que el equipo adopta para mitigarlos. La sexta categoría (Operativas) corresponde a restricciones del entorno municipal que condicionan el diseño del producto en operación.

<a id="sec-3-2-1"></a>
#### 3.2.1 Restricciones Humanas

Las restricciones humanas son aquellas relacionadas con la disponibilidad, dedicación y conocimiento del negocio por parte de los actores que intervienen en el proyecto (cliente, expertos del negocio y equipo de desarrollo).

| Código | Restricción | Importancia para el proyecto | Riesgos asociados | Plan de acción |
|---|---|---|---|---|
| **RN-HUM-001** | El Product Owner no tiene disponibilidad suficiente por sus otras responsabilidades del día a día, lo que dificulta atender sesiones clave para definir y validar el proyecto. | Es importante contar con la disponibilidad del PO para tomar decisiones a tiempo y no frenar el avance del equipo. | • Retraso del proyecto<br>• Reprocesos | Coordinar con anticipación las sesiones y documentar los acuerdos para no depender de su presencia en cada decisión. |
| **RN-HUM-002** | No existe una persona que pueda reemplazar al Product Owner en caso de ausencia prolongada o imprevista. | Si el PO no puede participar y no hay un respaldo, el proyecto puede quedar sin rumbo en decisiones clave. | • Retraso del proyecto<br>• Fracaso del proyecto | Definir desde el inicio quién puede tomar decisiones en nombre del PO cuando no esté disponible. |
| **RN-HUM-003** | Las personas que realmente conocen el proceso de podas no siempre pueden participar en las sesiones de definición del sistema. | Tomar decisiones sin los expertos del negocio lleva a construir funcionalidades que luego no sirven o deben rehacerse. | • Reprocesos<br>• Desalineación con el negocio | Organizar los horarios de sesión pensando en la disponibilidad de los actores clave del municipio. |
| **RN-HUM-004** | Los integrantes del equipo de desarrollo cuentan con compromisos adicionales, lo que limita las horas que pueden dedicar al proyecto. | Si no se planifica bien el trabajo, se puede llegar a los hitos sin el avance esperado. | • Retraso del proyecto<br>• Incumplimiento de entregas | Definir un alcance realista desde el inicio, priorizando las funcionalidades definidas en los requisitos funcionales del proyecto, y gestionar el tiempo disponible del equipo con entregas incrementales. |
| **RN-HUM-005** | Las validaciones con el cliente solo pueden hacerse en ciertos horarios, lo que genera tiempos muertos en el desarrollo. | El ritmo del desarrollo depende directamente de cuándo el cliente puede revisar y aprobar. Si los espacios de validación son escasos, el equipo queda detenido esperando respuestas, lo que afecta el cumplimiento de los hitos del proyecto. | • Retrasos en feedback<br>• Bloqueos al avance | Acordar ventanas fijas de revisión y usar canales como correo o mensajería para validaciones menores. |

<a id="sec-3-2-2"></a>
#### 3.2.2 Restricciones Legales/Normativas

Las restricciones legales y normativas son obligaciones impuestas por la normativa colombiana aplicable a la gestión municipal del arbolado urbano y al tratamiento de datos personales. Su incumplimiento expone al municipio a sanciones administrativas, ambientales o legales, por lo que condicionan el diseño del sistema desde su concepción.

| Código | Restricción | Importancia para el proyecto | Riesgos asociados | Plan de acción |
|---|---|---|---|---|
| **RN-LEG-001** | El sistema maneja datos personales de ciudadanos, por lo que debe cumplir con la Ley 1581 de 2012 de protección de datos en Colombia. | Tree Pruning registra datos personales de los ciudadanos que radican PQR (nombre, contacto, ubicación). Por ley colombiana, el sistema debe garantizar desde su diseño el tratamiento autorizado de esa información, lo que condiciona funcionalidades como el registro de ciudadanos y la gestión de PQR. | • Riesgo legal<br>• Sanciones administrativas | Incluir un consentimiento informado al registrarse y una política de privacidad visible dentro del sistema. |
| **RN-LEG-002** | Cualquier poda o tala de árbol debe contar con el permiso o concepto técnico de la autoridad ambiental (CORNARE u otra entidad regional). | En Colombia, cualquier intervención sobre arbolado urbano requiere autorización previa de la autoridad ambiental competente. El sistema debe contemplar este requisito desde el diseño del módulo de podas, ya que sin trazabilidad del permiso, las intervenciones registradas carecen de respaldo legal. | • Riesgo legal<br>• Sanciones ambientales | El sistema debe permitir asociar cada intervención con su respectivo número de permiso o soporte legal. |
| **RN-LEG-003** | La ley colombiana obliga a las entidades públicas a responder las PQR ciudadanas dentro de unos plazos establecidos (Ley 1755 de 2015). | El módulo de PQR del sistema debe estar diseñado para soportar los plazos legales de respuesta desde el inicio, ya que las entidades públicas no pueden manejar peticiones ciudadanas sin control de tiempos. Esto impacta directamente el diseño del flujo de estados y las alertas del módulo. | • Incumplimiento legal<br>• Riesgo reputacional | El sistema debe registrar la fecha de cada PQR y alertar cuando se acerque el vencimiento del plazo de respuesta. |

<a id="sec-3-2-3"></a>
#### 3.2.3 Restricciones de Presupuesto/Costos

Las restricciones económicas reflejan que el proyecto opera bajo un modelo de presupuesto operativo cero y que el municipio de Rionegro no puede sostener costos recurrentes elevados una vez entregado el sistema. Esto condiciona las decisiones de stack tecnológico, infraestructura y modelo de mantenimiento.

| Código | Restricción | Importancia para el proyecto | Riesgos asociados | Plan de acción |
|---|---|---|---|---|
| **RN-ECO-001** | El proyecto no cuenta con presupuesto para pagar licencias, herramientas o servicios en la nube. | La selección de tecnologías del sistema está condicionada desde el inicio por esta restricción. No se pueden considerar alternativas que impliquen licencias o pagos, lo que limita las opciones de infraestructura, mapas y servicios en la nube disponibles para el proyecto. | • Limitación tecnológica<br>• Deuda técnica | Usar únicamente herramientas gratuitas y de código abierto como PostgreSQL, Leaflet y servicios cloud en su versión gratuita. |
| **RN-ECO-002** | El municipio necesita que el sistema sea barato de mantener una vez entregado, no puede depender de servicios costosos. | El municipio opera con presupuestos institucionales limitados y no tiene garantizado un contrato de mantenimiento con el equipo de desarrollo. El sistema debe poder sostenerse con la infraestructura disponible sin requerir pagos recurrentes, lo que condiciona las decisiones de arquitectura desde el inicio. | • Abandono del sistema<br>• Dependencia de soluciones costosas | Diseñar la infraestructura con opciones económicas y evitar integraciones que generen costos recurrentes. |
| **RN-ECO-003** | El proyecto irá recibiendo recursos según los avances aprobados por el cliente, no de forma anticipada. | El equipo no puede planificar suponiendo recursos constantes o anticipados. Cada entrega debe ser demostrable y aprobable por el cliente, lo que obliga a estructurar el proyecto en hitos verificables y condiciona cómo se priorizan las funcionalidades. | • Interrupción del proyecto<br>• Flujo de caja incierto | Planificar entregas incrementales claras y medibles que permitan al cliente aprobar y liberar recursos oportunamente. |

<a id="sec-3-2-4"></a>
#### 3.2.4 Restricciones de Tiempo

Las restricciones de tiempo se derivan de la naturaleza académica del proyecto, con una fecha de entrega fija, y de la dinámica de aprobación del cliente, que condiciona el ritmo al que el equipo puede avanzar.

| Código | Restricción | Importancia para el proyecto | Riesgos asociados | Plan de acción |
|---|---|---|---|---|
| **RN-TMP-001** | El proyecto tiene una fecha de entrega académica fija que no puede moverse. | Al ser un proyecto académico con fecha de entrega inamovible, el equipo debe priorizar desde el inicio qué funcionalidades son viables en el tiempo disponible. Esto obliga a tomar decisiones de alcance tempranas y a no dejar funcionalidades críticas para las últimas semanas. | • Entrega incompleta<br>• Retraso general | Priorizar las funcionalidades más críticas y tener un plan de contingencia para los casos en que algo tome más tiempo. |
| **RN-TMP-002** | El cliente necesita ver resultados funcionales en poco tiempo para mantener su interés y compromiso con el proyecto. | Un proyecto que tarda mucho en mostrar algo concreto pierde relevancia y apoyo del cliente. | • Pérdida de interés del cliente<br>• Pérdida de valor del proyecto | Trabajar con entregas cortas y frecuentes que muestren avances reales desde las primeras semanas. |
| **RN-TMP-003** | El avance del desarrollo depende de que el cliente revise y apruebe cada entrega, lo cual no siempre ocurre rápido. | Las demoras del cliente para dar feedback bloquean al equipo y generan retrasos que se van acumulando. | • Bloqueos al desarrollo<br>• Retrasos en cascada | Documentar supuestos de trabajo para avanzar sin esperar aprobación en cada detalle menor, y validar al final de cada ciclo. |

<a id="sec-3-2-5"></a>
#### 3.2.5 Restricciones de Alcance

Las restricciones de alcance reflejan que el cliente no tiene completamente formalizado su proceso de gestión de podas y que durante el proyecto pueden surgir cambios o nuevas solicitudes que afecten el plan inicial. Estas restricciones obligan al equipo a establecer mecanismos de control de cambios y definir con claridad la frontera entre lo que TI construye y lo que el negocio define.

| Código | Restricción | Importancia para el proyecto | Riesgos asociados | Plan de acción |
|---|---|---|---|---|
| **RN-SCO-001** | El cliente no tiene completamente definido cómo funciona su proceso de gestión de podas, y quiere ir construyendo sobre la marcha. | Sin una definición clara del proceso de gestión de podas, el equipo debe diseñar con supuestos que el cliente puede refutar más adelante. Esto hace que las decisiones de arquitectura y los flujos del sistema queden expuestos a cambios que obligan a rehacer trabajo ya construido. | • Cambios constantes<br>• Reprocesos | Avanzar con entregas pequeñas y documentar cada decisión, acordando con el cliente qué entra y qué no en cada ciclo. |
| **RN-SCO-002** | Los requerimientos del sistema no están completamente definidos al inicio y pueden cambiar durante el proyecto. | El sistema no puede diseñarse ni desarrollarse con claridad si los requerimientos cambian constantemente. Esta restricción obliga al equipo a establecer acuerdos formales de control de cambios desde el inicio, para que cada modificación pase por un proceso de validación antes de ser incorporada. | • Desviación del proyecto<br>• Esfuerzo desperdiciado | Definir con claridad desde el inicio qué funcionalidades entran al proyecto basándose en los requisitos funcionales ya documentados, y gestionar cualquier cambio de alcance de forma formal y deliberada antes de incorporarlo al desarrollo. |
| **RN-SCO-003** | El cliente espera que el equipo de TI defina cómo deben funcionar los procesos del negocio, cuando eso no es responsabilidad del equipo técnico. | Cuando el cliente delega en TI la definición del proceso de negocio, el equipo asume decisiones que no le corresponden y construye flujos basados en su interpretación, no en la realidad operativa del municipio. Esto es un riesgo estructural porque cualquier funcionalidad construida bajo ese supuesto puede ser rechazada completa por los actores reales del proceso. | • Mal diseño funcional<br>• Rechazo posterior de entregables | Dejar claro desde el inicio que TI construye y habilita, pero el negocio define cómo deben funcionar sus procesos. |
| **RN-SCO-004** | Existe el riesgo de que durante el desarrollo se vayan agregando funcionalidades nuevas que no estaban planeadas. | Agregar cosas sin control hace que el proyecto nunca termine y el equipo se desgaste. | • Retraso del proyecto<br>• Sobrecarga del equipo | Controlar los cambios de alcance con una revisión formal antes de incluir cualquier nueva funcionalidad. |

<a id="sec-3-2-6"></a>
#### 3.2.6 Restricciones Operativas

Las restricciones operativas son condiciones del entorno del municipio de Rionegro que el sistema en operación debe respetar. A diferencia de las anteriores, no afectan la forma de ejecutar el proyecto sino las características que el producto debe cumplir en producción.

| Código | Restricción | Impacto en el diseño |
|---|---|---|
| **RN-OPE-001** | El sistema debe operar en horario laboral 6 AM – 6 PM de lunes a sábado. | La disponibilidad del 99.5% se mide sobre el horario laboral establecido (ver Anexo C — SLA). Las ventanas de mantenimiento se ubican fuera de este rango. |
| **RN-OPE-002** | El sistema debe ser accesible desde dispositivos institucionales existentes sin actualizaciones de hardware. | Los requerimientos mínimos del cliente son: Intel Core i3, 4 GB RAM, navegador Chrome/Edge actualizado. El Frontend (Vue.js 3 + Bootstrap 5.3+) debe rendir adecuadamente en esa configuración base. |

<a id="sec-3-3"></a>
### 3.3 Atributos de Calidad

Los atributos de calidad son las propiedades del sistema que determinan su grado de excelencia más allá de la funcionalidad básica. Para Tree Pruning se identificaron 16 atributos mediante votación ponderada por los tres actores del sistema (Administrador, Encargado de Cuadrilla, Ciudadano), resultando en la siguiente priorización:

| Prioridad | Atributo de Calidad | Puntaje |
|---|---|---|
| 1 | Usabilidad | 16 |
| 2 | Seguridad | 15 |
| 3 | Disponibilidad | 14 |
| 4 | Confiabilidad | 13 |
| 5 | Rendimiento | 12 |
| 6 | Accesibilidad | 11 |
| 7 | Escalabilidad | 10 |
| 8 | Costo | 9 |
| 9 | Trazabilidad | 8 |
| 10 | Interoperabilidad | 7 |
| 11 | Capacidad | 6 |
| 12 | Capacidad para ser desplegado | 5 |
| 13 | Capacidad para ser soportado | 4 |
| 14 | Capacidad para ser administrado | 3 |
| 15 | Capacidad para ser mantenido | 2 |
| 16 | Conformidad | 1 |

<a id="sec-3-3-1"></a>
#### 3.3.1 Atributo: Rendimiento

El rendimiento garantiza que el sistema responde a las solicitudes de los usuarios dentro de los tiempos máximos establecidos, incluso bajo carga concurrente, manteniendo la experiencia de uso fluida para los tres actores.

##### 3.3.1.1 Característica CAR-REN-0001 — Tiempos máximos por operación

El sistema debe asegurar que cada una de las operaciones en las cuales se especifique un tiempo máximo de respuesta, cumpla dicho tiempo de respuesta de manera obligatoria.

**Escenario ESC-CAL-REN-0002 — Registro exitoso de información dentro del tiempo máximo**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-REN-0002 |
| **Nombre** | Registro exitoso de información en el sistema dentro del tiempo máximo permitido |
| **Objetivo** | Asegurar que el sistema procese y confirme el guardado de registros (árbol, sector, PQR, poda o herramienta) en un tiempo menor o igual al definido |
| **Criterio de éxito** | Luego de que el usuario ejecuta la acción guardar, el sistema muestra el mensaje de éxito de guardado en un tiempo menor o igual al definido en la Matriz de Tiempos |
| **Prerequisitos** | El usuario debe estar autenticado en el sistema con permisos de registro |
| **Fuente del estímulo** | Usuario autenticado con permisos de registro (administrador, operario o ciudadano según el módulo) |
| **Estímulo** | Diligenciar el formulario de registro y ejecutar la acción guardar |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema procesa la solicitud, persiste el registro en la base de datos y muestra el mensaje de éxito |
| **Medida de la respuesta** | El mensaje de éxito es visible en un tiempo ≤ al definido en la Matriz de Tiempos |

**Escenario ESC-CAL-REN-0003 — Carga del mapa dentro del tiempo máximo**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-REN-0003 |
| **Nombre** | Carga de la utilidad de visualización de árboles o podas en el mapa dentro del tiempo máximo |
| **Objetivo** | Asegurar que el sistema cargue completamente la utilidad de visualización en el mapa en un tiempo ≤ al definido |
| **Criterio de éxito** | El mapa con los árboles o podas georreferenciados es visible e interactuable en el tiempo máximo |
| **Prerequisitos** | El usuario debe estar autenticado con permisos de visualización |
| **Fuente del estímulo** | Usuario autenticado (encargado de cuadrilla) |
| **Estímulo** | Acceder a la utilidad de visualización de árboles o podas en el mapa |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema carga y renderiza el mapa con los árboles o podas georreferenciados |
| **Medida de la respuesta** | El mapa es completamente visible e interactuable en un tiempo ≤ al definido en la Matriz de Tiempos |

<a id="sec-3-3-2"></a>
#### 3.3.2 Atributo: Confiabilidad

La confiabilidad garantiza que el sistema mantiene la integridad de la información durante su funcionamiento, asegurando que las operaciones se completen de forma consistente y que los fallos no dejen datos en estados inconsistentes.

##### 3.3.2.1 Característica CAR-CON-0001 — Integridad de la información

**Escenario ESC-CAL-CON-0001 — Validación y actualización al crear o modificar registros**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-CON-0001 |
| **Nombre** | Validación y actualización de información al crear o modificar registros en el sistema |
| **Objetivo** | Asegurar que el sistema valide correctamente la información ingresada según las reglas de negocio y actualice el listado de registros con los valores exactos ingresados |
| **Criterio de éxito** | El sistema valida la información antes de ejecutar la acción de guardado y el listado muestra el registro con los valores exactos |
| **Prerequisitos** | El usuario debe estar autenticado con permisos de creación o modificación |
| **Fuente del estímulo** | Usuario autenticado con permisos de creación o modificación (administrador) |
| **Estímulo** | Crear o modificar un registro en el sistema y ejecutar la acción de guardado |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema valida la información ingresada, guarda el registro y muestra la lista actualizada |
| **Medida de la respuesta** | La lista actualizada muestra el registro con los valores exactos ingresados por el usuario |

##### 3.3.2.2 Característica CAR-CON-0002 — Atomicidad de operaciones

**Escenario ESC-CAL-CON-0003 — Reversión automática ante pérdida de conexión**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-CON-0003 |
| **Nombre** | Reversión automática de cambios ante pérdida de conexión durante la creación de podas preventivas anuales |
| **Objetivo** | Asegurar que la creación del conjunto de podas preventivas anuales se trate como una unidad atómica; si ocurre un fallo, el sistema revierte todos los cambios parciales |
| **Criterio de éxito** | Ante una pérdida de conexión, el sistema revierte la transacción y la base de datos no contiene ningún registro parcial |
| **Prerequisitos** | El usuario debe estar autenticado con permisos para crear podas preventivas |
| **Fuente del estímulo** | Usuario autenticado (encargado de cuadrilla) + fallo externo (pérdida de conexión) |
| **Estímulo** | Pérdida de conexión, error del sistema o interrupción inesperada durante la creación del conjunto de podas preventivas |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema detecta la interrupción, revierte la transacción y notifica al usuario |
| **Medida de la respuesta** | La base de datos no contiene ningún registro parcial de las podas preventivas que se intentaron crear |

<a id="sec-3-3-3"></a>
#### 3.3.3 Atributo: Seguridad

La seguridad protege el acceso no autorizado al sistema mediante métodos de autenticación robustos, control de sesiones y presentación de información según los permisos asignados a cada rol.

##### 3.3.3.1 Característica CAR-SEG-0001 — Autenticación y control de acceso

**Escenario ESC-CAL-SEG-0002 — Bloqueo temporal por 3 intentos fallidos**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-SEG-0002 |
| **Nombre** | Bloqueo temporal de cuenta por intentos fallidos de autenticación consecutivos |
| **Objetivo** | Asegurar que el sistema bloquee temporalmente una cuenta durante 5 minutos cuando se detectan 3 intentos fallidos consecutivos |
| **Criterio de éxito** | Luego del tercer intento fallido consecutivo, el sistema bloquea la cuenta e informa al usuario |
| **Prerequisitos** | El usuario debe existir en el sistema |
| **Fuente del estímulo** | Usuario o actor no autorizado intentando acceder al sistema |
| **Estímulo** | Introducir contraseña incorrecta en 3 intentos consecutivos para una cuenta existente |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema detecta el tercer intento fallido, bloquea temporalmente la cuenta e informa al usuario |
| **Medida de la respuesta** | La cuenta permanece bloqueada 5 minutos rechazando cualquier intento de acceso durante ese período |

##### 3.3.3.2 Característica CAR-SEG-0002 — Módulos según rol

**Escenario ESC-CAL-SEG-0005 — Visualización de módulos según el rol autenticado**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-SEG-0005 |
| **Nombre** | Visualización de módulos en el menú principal según el rol del usuario autenticado |
| **Objetivo** | Asegurar que el sistema muestre en la barra lateral únicamente los módulos a los cuales tiene acceso el rol del usuario |
| **Criterio de éxito** | La barra lateral muestra exclusivamente los módulos correspondientes al rol activo, sin que aparezca ningún módulo no autorizado |
| **Prerequisitos** | El usuario debe estar autenticado con un rol válido y activo |
| **Fuente del estímulo** | Usuario autenticado con rol y permisos previamente asignados |
| **Estímulo** | Ingresar al sistema y acceder a la vista principal con la barra lateral |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema evalúa el rol y renderiza la barra lateral mostrando únicamente los módulos autorizados |
| **Medida de la respuesta** | La barra lateral muestra exactamente los módulos asignados al rol, sin que aparezca ningún módulo no autorizado |

<a id="sec-3-3-4"></a>
#### 3.3.4 Atributo: Disponibilidad

La disponibilidad garantiza que el sistema esté operativo y accesible durante el horario laboral establecido, con mecanismos de recuperación ante fallos y copias de seguridad diarias.

##### 3.3.4.1 Característica CAR-DIS-0001 — Disponibilidad en horario laboral

**Escenario ESC-CAL-DIS-0001 — Disponibilidad y respuesta en horario establecido**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-DIS-0001 |
| **Nombre** | Disponibilidad y respuesta del sistema durante el horario establecido |
| **Objetivo** | Asegurar que el sistema esté disponible y responda correctamente durante el horario laboral (6 AM – 6 PM) con disponibilidad del 99.5% anual |
| **Criterio de éxito** | El sistema está disponible para todos los usuarios, garantizando 99.5% de disponibilidad anual durante el horario laboral |
| **Prerequisitos** | El usuario debe existir en el sistema con cuenta activa y vigente |
| **Fuente del estímulo** | Usuario autenticado o por autenticar que intenta acceder dentro del horario laboral |
| **Estímulo** | Intentar ingresar al aplicativo y realizar solicitudes |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema se encuentra disponible, permite el ingreso y responde correctamente a todas las solicitudes |
| **Medida de la respuesta** | El sistema mantiene disponibilidad continua durante el 99.5% de las horas anuales del horario laboral |

<a id="sec-3-3-5"></a>
#### 3.3.5 Atributo: Escalabilidad

**Escenario ESC-CAL-ESC-0028 — Continuidad operativa ante desactivación de funcionalidad**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-ESC-0028 |
| **Nombre** | Continuidad operativa del sistema base ante la desactivación de una funcionalidad nueva |
| **Objetivo** | Asegurar que la desactivación de una funcionalidad nueva por fallo o mantenimiento no afecte el funcionamiento de los módulos base |
| **Criterio de éxito** | Los módulos base (inventario, podas, reportes, PQR) responden correctamente según la Matriz de Tiempos luego de desactivar una funcionalidad nueva |
| **Prerequisitos** | El sistema debe tener al menos una funcionalidad nueva integrada y activa |
| **Fuente del estímulo** | Administrador del sistema |
| **Estímulo** | Desactivación de una funcionalidad nueva (alerta automática o módulo de análisis) por fallo o mantenimiento |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema aísla el módulo desactivado sin propagar el fallo hacia los módulos base |
| **Medida de la respuesta** | Los módulos base responden correctamente según la Matriz de Tiempos, sin errores visibles para el usuario |

<a id="sec-3-3-6"></a>
#### 3.3.6 Atributo: Trazabilidad

**Escenario ESC-CAL-TRA-0036 — Bloqueo y notificación ante 5 intentos fallidos**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-TRA-0036 |
| **Nombre** | Bloqueo automático de cuenta y notificación al administrador ante intentos fallidos consecutivos |
| **Objetivo** | Asegurar que el sistema registre todos los intentos fallidos y bloquee automáticamente la cuenta tras 5 intentos en menos de 10 minutos |
| **Criterio de éxito** | La cuenta queda bloqueada automáticamente y se envía notificación al administrador |
| **Prerequisitos** | El usuario debe existir en el sistema con cuenta activa y vigente |
| **Fuente del estímulo** | Usuario o actor no autorizado que intenta acceder repetidamente con credenciales incorrectas |
| **Estímulo** | Producir 5 intentos fallidos consecutivos para un mismo usuario en menos de 10 minutos |
| **Ambiente** | Operación normal en ambiente productivo |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema registra cada intento, bloquea la cuenta en el quinto intento y notifica al administrador |
| **Medida de la respuesta** | La cuenta queda bloqueada tras el quinto intento; el administrador recibe notificación en menos de 1 minuto |

<a id="sec-3-3-7"></a>
#### 3.3.7 Atributo: Usabilidad

**Escenario ESC-CAL-USA-0003 — Interacción y estilo uniforme en formularios**

| Campo | Detalle |
|---|---|
| **Código** | ESC-CAL-USA-0003 |
| **Nombre** | Interacción y estilo uniforme en los formularios |
| **Objetivo** | Garantizar que todos los formularios presenten estructura, estilo visual y comportamiento consistentes |
| **Criterio de éxito** | Al interactuar con un formulario, el usuario identifica inmediatamente el campo activo mediante indicador visual, los campos obligatorios con asterisco (*) y los mensajes de error en rojo debajo del campo |
| **Prerequisitos** | Usuario autenticado con sesión activa en el sistema |
| **Fuente del estímulo** | Cualquier usuario del sistema |
| **Estímulo** | El usuario selecciona o interactúa con un formulario para ingresar datos |
| **Ambiente** | Operación normal en ambiente productivo o pruebas |
| **Artefacto** | Sistema |
| **Respuesta** | El sistema presenta el formulario con campos obligatorios identificados mediante asterisco (*), delimitadores de color verde y mensajes de error descriptivos |
| **Medida de la respuesta** | El 100% de los campos obligatorios son identificados visualmente por el usuario mediante asterisco (*) y delimitador de color verde |

<a id="sec-3-4"></a>
### 3.4 Funcionalidades Críticas

Las funcionalidades críticas son aquellas sin las cuales el sistema no cumple su propósito fundamental.

| Código | Funcionalidad | Módulo | Actores |
|---|---|---|---|
| **FC-001** | Registro y gestión del inventario de árboles georreferenciados | Inventario | Administrador |
| **FC-002** | Planificación y programación de podas preventivas y correctivas | Podas | Encargado de Cuadrilla |
| **FC-003** | Ejecución y evidencia fotográfica de podas en campo | Podas | Encargado de Cuadrilla |
| **FC-004** | Registro y seguimiento de PQR ciudadanas sobre el arbolado | PQR | Ciudadano |
| **FC-005** | Generación y exportación de reportes institucionales | Reportes | Administrador |
| **FC-006** | Autenticación y control de acceso por roles (RBAC) | Transversal | Todos |
| **FC-007** | Visualización geográfica del inventario y podas en mapa interactivo | Inventario / Podas | Administrador, Encargado |
| **FC-008** | Trazabilidad completa de acciones de usuarios | Transversal | Todos |

<a id="sec-3-4-1"></a>
#### 3.4.1 Historias de Usuario asociadas a las Funcionalidades Críticas

Las siguientes historias de usuario definen los requerimientos funcionales que sustentan cada funcionalidad crítica del sistema.

| Identificador | Historia de usuario | Justificación |
|---|---|---|
| **HU_01** | Yo como administrador quiero registrar nuevos usuarios con sus datos básicos para garantizar que cada persona tenga acceso a los módulos del aplicativo según sus responsabilidades y permisos. | Es importante que el administrador del sistema pueda gestionar los usuarios del aplicativo, ya que estos son los que se encargan de alimentar la información en este. |
| **HU_02** | Yo como administrador del sistema quiero asignar o modificar el rol de un usuario existente para garantizar que tenga permisos adecuados según sus responsabilidades en la gestión de podas. | Es muy importante que el administrador pueda controlar el acceso basado en roles dentro del aplicativo, garantizando la seguridad de la información y que las acciones dentro del sistema sean realizadas por el personal que tiene autorización de hacerlo. |
| **HU_03** | Yo como usuario de la aplicación de podas quiero iniciar sesión con mis credenciales y mantener una sesión segura para garantizar que solo yo pueda acceder a mis funcionalidades y datos autorizados. | Es muy importante que los usuarios puedan iniciar sesión y hacerlo de manera segura, asegurando que las acciones realizadas en el aplicativo sean realizadas por el personal autorizado. |
| **HU_06** | Yo como administrador del aplicativo de podas quiero registrar las cuadrillas de poda asociando sus integrantes y las herramientas asignadas para organizar y controlar de manera eficiente los recursos humanos y materiales en cada operación. | Es muy importante que el administrador del sistema pueda alimentar la información de cuadrillas de poda y herramientas de trabajo en el sistema para que los encargados tengan un inventario actualizado con los recursos físicos y humanos disponibles. |
| **HU_08** | Yo como encargado del aplicativo de poda de árboles quiero registrar y consultar información de cada árbol (especie, estado, ubicación, nombre y altura) para disponer de un inventario actualizado que sirva de base para la programación y control de podas. | Es muy importante que el encargado de cuadrilla disponga del inventario de árboles y tenga la posibilidad de actualizarlo, así podrá planificar y hacer seguimiento a las podas del municipio de manera ordenada. |
| **HU_09** | Yo como encargado de cuadrilla, quiero planificar podas preventivas de manera recurrente en intervalos de tiempo establecidos para garantizar la correcta gestión y mantenimiento de las áreas públicas. | Es muy importante que el encargado del sistema pueda programar de manera anticipada y recurrente las podas para cada árbol del municipio, manteniendo en buen estado el espacio público y reduciendo riesgos de daños materiales y humanos a lo largo del tiempo. |
| **HU_10** | Yo como encargado de cuadrilla, quiero asignar cuadrillas y fechas a las podas para garantizar la organización y cumplimiento de las podas programadas. | Es muy importante que un encargado de cuadrilla pueda asignar los recursos necesarios para su ejecución a una poda, dejando responsables claros y un momento definido de ejecución, haciendo posible que la poda realmente ocurra. |
| **HU_11** | Yo como encargado de cuadrilla, quiero planificar podas correctivas a partir de las PQR registradas por los ciudadanos, para dar solución a sus solicitudes. | Es muy importante que el encargado de cuadrilla pueda planificar podas correctivas basado en las PQR generadas por los ciudadanos del municipio, garantizando una gestión y respuesta oportuna. |
| **HU_13** | Yo como encargado de cuadrilla del aplicativo, quiero marcar una poda como ejecutada indicando la fecha y la hora de finalización para dejar constancia en el sistema de la actividad realizada y facilitar el control del cumplimiento de la programación. | Es muy importante que un encargado de cuadrilla pueda marcar una poda como ejecutada con su fecha, dejando constancia del trabajo realizado; de esta manera pueden medir el cumplimiento y la productividad de las cuadrillas. |
| **HU_14** | Yo como encargado de cuadrillas del aplicativo, quiero registrar la cuadrilla responsable y las herramientas utilizadas en la ejecución de la poda para garantizar la trazabilidad de recursos empleados en cada intervención. | Es muy importante que un encargado de cuadrilla registre la cuadrilla y las herramientas utilizadas en las podas, lo que permite saber responsables y el uso de los recursos que posee la organización, llevando trazabilidad de cada intervención. |
| **HU_15** | Yo como encargado de cuadrillas del aplicativo, quiero adjuntar evidencia de la poda realizada (fotografías, observaciones de campo y firmas digitales) para dejar constancia verificable de la ejecución y facilitar la validación por parte del administrador. | Es muy importante que el encargado de cuadrilla adjunte la evidencia fotográfica de la poda antes y después de su ejecución, las observaciones de la poda y una firma, dejando constancia de la realización de la tarea y que esta cumple según los parámetros técnicos del árbol. |
| **HU_17** | Yo como administrador del aplicativo de podas, quiero registrar la ubicación exacta de cada árbol en el espacio público mediante coordenadas GPS para georreferenciar el inventario y facilitar su localización en el mapa del sistema. | Es muy importante que el administrador pueda ubicar los árboles usando el mapa interactivo de Google Maps, para que la gestión en campo y la planificación sea más efectiva. |
| **HU_19** | Yo como ciudadano o usuario del sistema quiero registrar una PQR asociada a un sector para que la solicitud ingrese al flujo de atención y pueda convertirse en una poda correctiva cuando corresponda. | Es muy importante que un usuario con el rol de ciudadano pueda registrar las solicitudes de poda para que el equipo de gestión ambiental de la alcaldía pueda dar solución en el menor tiempo posible. |

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-4"></a>
## 4. Tácticas y Estrategias

Las tácticas son los mecanismos de diseño que permiten satisfacer los atributos de calidad priorizados. Cada táctica responde directamente a uno o más escenarios de calidad y se implementa mediante una estrategia técnica concreta.

<a id="sec-4-1"></a>
### 4.1 Tácticas para Rendimiento

**Táctica: Optimización de operaciones de escritura con respuesta asíncrona** *(ESC-CAL-REN-0002)*

Implementar un mecanismo de escritura que procese las operaciones de guardado de forma eficiente, utilizando transacciones optimizadas en Spring Data JPA con confirmación inmediata. El Backend responde al Frontend con el mensaje de éxito en cuanto la transacción se confirma en PostgreSQL, sin esperar procesos secundarios.

**Táctica: Paginación geográfica para la carga del mapa** *(ESC-CAL-REN-0003)*

Implementar un mecanismo que restrinja la cantidad de árboles o podas cargados en el mapa según el área visible en el viewport del usuario. Solo se consultan los registros dentro del bounding box actual, reduciendo el volumen de datos transmitidos. Redis almacena en caché los puntos georreferenciados frecuentemente consultados con TTL de 300 segundos.

<a id="sec-4-2"></a>
### 4.2 Tácticas para Confiabilidad

**Táctica: Validación en capas con actualización desde la fuente de datos** *(ESC-CAL-CON-0001)*

Implementar doble validación: primero en el Frontend mediante Bootstrap Validator (validación reactiva inmediata) y luego en el Backend mediante Spring Validation antes de ejecutar la escritura. La respuesta al Frontend incluye el registro recién guardado leído directamente desde la base de datos, garantizando consistencia.

**Táctica: Transacciones ACID en creación masiva de podas** *(ESC-CAL-CON-0003)*

Envolver toda la operación de creación de podas preventivas anuales dentro de una única transacción de Spring (`@Transactional`). Ante cualquier fallo (pérdida de conexión, error de validación, timeout), Spring activa el rollback automático dejando la base de datos en estado coherente previo a la operación.

<a id="sec-4-3"></a>
### 4.3 Tácticas para Seguridad

**Táctica: Contador de intentos fallidos con bloqueo temporal en el IDP** *(ESC-CAL-SEG-0002)*

Delegar la gestión del contador de intentos fallidos y el bloqueo temporal de cuentas a Keycloak (Identity Provider). Keycloak registra cada intento fallido y aplica la política de bloqueo de 5 minutos tras 3 intentos consecutivos sin necesidad de código adicional en el Backend.

**Táctica: Filtrado de módulos del menú basado en el rol de la sesión** *(ESC-CAL-SEG-0005)*

Al cargar la barra lateral de navegación, el Frontend consulta el token JWT activo almacenado en Pinia Store y extrae el rol del usuario. El componente de menú renderiza condicionalmente solo los módulos autorizados para ese rol, impidiendo que rutas no autorizadas se rendericen mediante Vue Router guards.

<a id="sec-4-4"></a>
### 4.4 Tácticas para Disponibilidad

**Táctica: Monitoreo periódico con notificación automática ante fallos** *(ESC-CAL-DIS-0001)*

Implementar un mecanismo de monitoreo mediante Prometheus que ejecute verificaciones automáticas del estado del sistema cada 15 segundos usando el endpoint `/actuator/health` de Spring Boot. Grafana genera alertas automáticas cuando la disponibilidad cae por debajo del umbral configurado. Traefik actúa como health-check del contenedor.

<a id="sec-4-5"></a>
### 4.5 Tácticas para Escalabilidad

**Táctica: Bandera de activación por módulo** *(ESC-CAL-ESC-0028)*

Implementar un mecanismo que controle el estado de cada funcionalidad nueva mediante una bandera (flag) almacenada en el Parameter Catalog (Spring Cloud Config). Antes de ejecutar cualquier funcionalidad nueva, el Backend verifica el flag. Si está desactivado, omite la ejecución sin lanzar excepción hacia los módulos base.

<a id="sec-4-6"></a>
### 4.6 Tácticas para Trazabilidad

**Táctica: Registro de intentos fallidos delegado al IDP** *(ESC-CAL-TRA-0036)*

Delegar la gestión de autenticación y las políticas de seguridad de acceso al IDP configurado (Keycloak). Keycloak registra cada intento fallido en su log de eventos de seguridad, bloquea la cuenta tras los umbrales configurados y puede notificar al administrador mediante el mecanismo de eventos de Keycloak integrado con el Notification Gateway (FCM).

<a id="sec-4-7"></a>
### 4.7 Tácticas para Usabilidad

**Táctica: Estilos y comportamiento accesible de formularios** *(ESC-CAL-USA-0003)*

Aplicar un conjunto de estilos globales en Bootstrap 5.3+ que garanticen: campos obligatorios marcados con asterisco (*) mediante CSS global, delimitador verde en el campo activo mediante `:focus`, mensajes de error en rojo debajo del campo afectado. Este comportamiento se aplica automáticamente a todos los formularios del sistema sin configuración adicional por módulo.

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-5"></a>
## 5. Modelo de Contexto

El modelo de contexto muestra el sistema Tree Pruning en relación con los actores y sistemas externos que interactúan con él, definiendo las fronteras del sistema y los canales de comunicación.

Tree Pruning opera como el sistema central de gestión de arbolado urbano del municipio de Rionegro. Recibe solicitudes HTTPS de tres tipos de actores (Administrador, Encargado de Cuadrilla, Ciudadano) a través de internet, previa validación por el WAF de Cloudflare y el API Gateway (Kong). El sistema interactúa con servicios externos para autenticación (Keycloak/Microsoft Entra ID), notificaciones push (Firebase Cloud Messaging), visualización geográfica (Google Maps Platform) y parámetros operativos (Spring Cloud Config).

**Actores externos:**

| Actor | Tipo | Canal | Descripción |
|---|---|---|---|
| Administrador del sistema | Humano | HTTPS / Browser | Gestiona inventario, reportes, usuarios y configuración del sistema |
| Encargado de cuadrilla | Humano | HTTPS / Browser | Planifica y registra la ejecución de podas |
| Ciudadano | Humano | HTTPS / Browser | Registra y hace seguimiento a PQR sobre el arbolado |
| Cloudflare WAF | Sistema externo | HTTPS | Filtra tráfico malicioso antes de llegar al servidor |
| Cloudflare CDN | Sistema externo | HTTPS | Entrega el Frontend estático desde el nodo más cercano |
| Microsoft Entra ID | Sistema externo | OIDC/HTTPS | Federated Identity para autenticación institucional del municipio |
| Firebase Cloud Messaging | Sistema externo | HTTPS | Envío de notificaciones push a navegadores |
| Google Maps Platform | Sistema externo | HTTPS/JS | Visualización de mapas interactivos en el Frontend |
| GitHub Actions | Sistema externo | HTTPS | Pipeline CI/CD que despliega automáticamente en la VM Azure |
| Infisical | Sistema externo (SaaS) | HTTPS | Gestión y distribución de secretos al sistema |

> **📷 Diagrama requerido — Modelo de Contexto del Sistema**  
> **Archivo:** `./images/tp-context-model.png`  
> **Descripción esperada:** Diagrama de contexto C4 (Nivel 1) o equivalente que muestre a Tree Pruning en el centro y a su alrededor los tres actores humanos (Administrador, Encargado de Cuadrilla, Ciudadano) y los siete sistemas externos (Cloudflare WAF/CDN, Microsoft Entra ID, Firebase Cloud Messaging, Google Maps Platform, GitHub Actions, Infisical), con los canales de comunicación etiquetados (HTTPS, OIDC, etc.).

![Modelo de Contexto del Sistema](./images/tp-context-model.png)

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-6"></a>
## 6. Arquetipo de Solución/Referencia

El arquetipo de solución describe el patrón arquitectónico de referencia que sirve como modelo conceptual para Tree Pruning antes de instanciarlo con tecnologías específicas.

Tree Pruning adopta el arquetipo de **aplicación web empresarial de N-capas con gestión documental geoespacial**, caracterizado por:

- **Capa de presentación (SPA):** Interfaz de usuario reactiva que se ejecuta completamente en el navegador del cliente, comunicándose con el backend únicamente mediante llamadas HTTPS/REST con tokens JWT.
- **Capa de integración (API Gateway):** Punto de entrada único que centraliza enrutamiento, autenticación y políticas de acceso.
- **Capa de aplicación (Backend REST):** Núcleo de lógica de negocio organizado en módulos independientes por dominio funcional.
- **Capa de datos (SQL + Blob):** Persistencia relacional con extensión geoespacial para el inventario y almacenamiento de objetos para evidencias fotográficas.
- **Capa de gestión (Management Layer):** Servicios de soporte transversales: identidad, secretos, notificaciones, parámetros, monitoreo y trazabilidad.

Este arquetipo es el estándar de la industria para sistemas de gestión de información municipal porque balancea: facilidad de despliegue (contenedores Docker), mantenibilidad (separación de capas), cumplimiento normativo (trazabilidad y control de acceso por rol) y costo operativo mínimo (tecnologías open source en capa gratuita).

> **📷 Diagrama requerido — Arquetipo de Solución**  
> **Archivo:** `./images/tp-archetype.png`  
> **Descripción esperada:** Diagrama agnóstico de tecnología que muestre las cinco capas del arquetipo (Presentación, Integración API Gateway, Aplicación, Datos SQL+Blob, Management Layer) con sus responsabilidades, sin nombres de productos concretos.

![Arquetipo de Solución](./images/tp-archetype.png)

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-7"></a>
## 7. Arquitectura de Solución/Referencia

La arquitectura de solución es la instancia concreta del arquetipo para Tree Pruning, con las tecnologías, versiones y configuraciones específicas seleccionadas para cada capa.

La solución se despliega sobre una máquina virtual Azure Standard_B4ms (4 vCPUs, 16 GB RAM) con Ubuntu 22.04 LTS, donde todos los servicios corren como contenedores Docker gestionados por Docker Compose. Traefik actúa como reverse proxy enrutando el tráfico HTTPS entrante hacia el contenedor correcto según el subdominio. Cloudflare gestiona el DNS y el WAF perimetral.

**Dominio:** `treepruning.org`

| Subdominio | Servicio | Puerto interno |
|---|---|---|
| `treepruning.org` | Frontend Vue.js | 80 |
| `api.treepruning.org` | Kong Gateway | 8000 |
| `auth.treepruning.org` | Keycloak | 8080 |
| `cms.treepruning.org` | Strapi | 1337 |
| `grafana.treepruning.org` | Grafana | 3000 |
| `sonar.treepruning.org` | SonarQube | 9000 |
| `console.treepruning.org` | MinIO Consola | 9001 |
| `s3.treepruning.org` | MinIO API | 9000 |

> **📷 Diagrama requerido — Arquitectura de Solución**  
> **Archivo:** `./images/tp-solution-architecture.png`  
> **Descripción esperada:** Diagrama que instancia el arquetipo con las tecnologías concretas: Vue.js 3 + Bootstrap (Frontend), Kong (Gateway), Spring Boot 3.3 + Java 26 (Backend), PostgreSQL 16 + PostGIS + MinIO (Datos), Keycloak + Infisical + Strapi + Prometheus + Grafana + SonarQube (Management), todo desplegado en Docker Compose sobre Azure VM con Traefik y Cloudflare al frente.

![Arquitectura de Solución](./images/tp-solution-architecture.png)

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-8"></a>
## 8. Línea Base Arquitectónica

La línea base arquitectónica define el estado aprobado y estable de la arquitectura del sistema a partir del cual se miden los cambios y evoluciones.

<a id="sec-8-1"></a>
### 8.1 Línea Base de Componentes

<a id="sec-8-1-1"></a>
#### 8.1.1 Componente: Frontend Tree Pruning

El Frontend es una SPA (Single Page Application) desarrollada en Vue.js 3 con Bootstrap 5.3+. Se organiza en módulos funcionales (Inventario, Podas, PQR, Reportes, Administración) con navegación controlada por rol mediante Vue Router Guards. Axios gestiona todas las llamadas HTTP con interceptores para JWT y manejo centralizado de errores de autorización.

El contenedor Docker del Frontend usa la imagen `nginx:alpine` como servidor estático. GitHub Actions compila el proyecto con `npm run build` y empuja la imagen resultante a GitHub Container Registry (GHCR), desde donde la VM Azure la descarga y ejecuta con las labels de Traefik para enrutamiento HTTPS automático.

<a id="sec-8-1-2"></a>
#### 8.1.2 Componente: Backend Tree Pruning

El Backend es una API REST desarrollada en Spring Boot 3.3+ con Java 26, organizada en Clean Architecture con las capas: `domain` → `application` → `infrastructure`. Expone endpoints REST para los cuatro módulos del sistema (Administración, Podas, PQR, Reportes), con seguridad implementada mediante Spring Security OAuth2 Resource Server que valida tokens JWT contra Keycloak.

Spring Data JPA con PostGIS gestiona la persistencia geoespacial. Spring Events publica eventos de auditoría de forma asíncrona. Spring Actuator expone métricas para Prometheus en formato `/actuator/prometheus`. Spring Cloud Config Client obtiene los parámetros operativos del municipio desde el Config Server al arranque.

El Dockerfile del Backend usa `eclipse-temurin:26-jdk-alpine` para compilación y ejecución (no existe imagen JRE separada para Java 26). GitHub Actions compila el JAR con Maven (`mvn clean package -DskipTests`) y construye la imagen Docker para GHCR.

<a id="sec-8-2"></a>
### 8.2 Estilos y Patrones Arquitectónicos Adoptados

Los estilos arquitectónicos y los patrones de diseño son soluciones probadas y reutilizables a problemas recurrentes en la construcción de sistemas de software. Un **estilo arquitectónico** define la organización macroestructural del sistema (cómo se distribuyen las responsabilidades entre los componentes principales y cómo se comunican entre sí), mientras que un **patrón** ofrece una solución acotada a un problema específico dentro de esa estructura. La selección de estilos y patrones condiciona directamente atributos de calidad como la mantenibilidad, la escalabilidad, la testabilidad y la separación de responsabilidades del sistema; por lo tanto, es una decisión de diseño que debe justificarse explícitamente.

Para Tree Pruning se adoptaron tres estilos arquitectónicos combinados, cada uno aplicado al ámbito donde mejor resuelve el problema correspondiente: **Layered N-Capas con Clean Architecture** como estilo dominante del Backend, **Event-Driven** de forma puntual para la trazabilidad y notificaciones, y **Microservicios de Soporte** para los servicios transversales (identidad, secretos, monitoreo, catálogos). A continuación se documenta cada uno con el nombre, el problema que resuelve y la solución/motivación que justifica su adopción.

<a id="sec-8-2-1"></a>
#### 8.2.1 Layered N-Capas (Arquitectura en Capas)

##### 8.2.1.1 Nombre

Layered Architecture / Clean Architecture

##### 8.2.1.2 Problema

El sistema necesita separar las responsabilidades de presentación, lógica de negocio y persistencia para garantizar mantenibilidad, testabilidad y bajo acoplamiento entre módulos funcionales del municipio.

##### 8.2.1.3 Solución/Motivación

Se adoptó la arquitectura en capas con flujo de dependencias unidireccional (capas externas dependen de capas internas, nunca al revés). La capa `domain` contiene las entidades de negocio puras sin dependencias de infraestructura. La capa `application` orquesta los casos de uso. La capa `infrastructure` implementa los adaptadores de entrada (controladores REST) y salida (repositorios JPA, integraciones externas). Esta separación permite modificar la implementación técnica (cambiar de PostgreSQL a otro motor, cambiar el framework HTTP) sin alterar la lógica de negocio.

<a id="sec-8-2-2"></a>
#### 8.2.2 Event-Driven (Eventos de Dominio)

##### 8.2.2.1 Nombre

Event-Driven Architecture (puntual, para trazabilidad y notificaciones)

##### 8.2.2.2 Problema

La trazabilidad de acciones y el envío de notificaciones push no deben acoplarse síncronamente al flujo principal de negocio. Si el servicio de notificaciones falla, la operación de negocio no debe verse afectada.

##### 8.2.2.3 Solución/Motivación

Spring Events publica eventos de dominio de forma asíncrona dentro del mismo proceso (sin broker externo). Cuando un caso de uso completa una operación crítica (crear poda, cerrar PQR), publica un `DomainEvent` que es consumido por los listeners de trazabilidad y notificación de forma independiente. Esto garantiza atomicidad (si la operación principal falla, el evento no se publica) y desacoplamiento del canal de notificación.

<a id="sec-8-2-3"></a>
#### 8.2.3 Microservicios de Soporte (Management Layer)

##### 8.2.3.1 Nombre

Sidecar / Supporting Services Pattern

##### 8.2.3.2 Problema

Los servicios de soporte (identidad, secretos, monitoreo, catálogos) deben poder evolucionar de forma independiente sin afectar el Frontend o el Backend, y deben ser intercambiables por alternativas sin reescribir código.

##### 8.2.3.3 Solución/Motivación

Cada servicio de soporte corre como contenedor Docker independiente con su propia base de datos (Kong → BD `kong`, Keycloak → BD `keycloak`, Strapi → BD `strapi`). El Backend se comunica con ellos mediante sus APIs REST estándar (OIDC para Keycloak, REST para Strapi, S3 API para MinIO). La separación de bases de datos evita interferencia entre servicios y permite reemplazar cualquier componente sin migración de datos del sistema principal.

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-9"></a>
## 9. Justificación Alternativa de Solución

La justificación de la alternativa de solución consiste en argumentar por qué la combinación de decisiones de diseño tomadas por el equipo es la mejor manera de resolver el problema dadas las restricciones reales del proyecto. Esta sección documenta no solo la alternativa seleccionada, sino también las alternativas que se consideraron y se descartaron, explicando los criterios usados para la decisión.

<a id="sec-9-1"></a>
### 9.1 Justificación

La alternativa seleccionada para Tree Pruning consiste en: arquitectura **Layered N-Capas con Clean Architecture** en el Backend, **SPA en Vue.js 3 + Bootstrap 5.3+** en el Frontend, **PostgreSQL 16 + PostGIS** como motor de datos, **Azure VM + Docker Compose + Traefik** como infraestructura de despliegue, e **Infisical SaaS** como gestor de secretos. Esta combinación es la que mejor resuelve el problema de gestión del arbolado urbano de Rionegro considerando las restricciones reales (RT-001, RT-002 del curso y RN-ECO-* de presupuesto cero).

A continuación se desarrolla la justificación específica de cada decisión clave que el equipo tomó, presentando para cada caso las alternativas consideradas, los criterios de evaluación y la decisión adoptada.

#### 9.1.1 Motor de base de datos: PostgreSQL 16 + PostGIS

**Alternativas consideradas:** MySQL 8, MariaDB, SQL Server Express, MongoDB, PostgreSQL 16.

**Criterios de evaluación:** soporte nativo para datos geoespaciales (los árboles son entidades georreferenciadas con coordenadas GPS y los sectores son polígonos), licenciamiento open source, comunidad activa y compatibilidad con Spring Data JPA.

**Decisión:** PostgreSQL 16 + PostGIS. PostGIS es la extensión geoespacial más madura del ecosistema open source, con soporte nativo para tipos `geometry`, `geography` e índices espaciales (GiST). Permite consultas como "todos los árboles dentro de este polígono" o "los 10 árboles más cercanos a este punto" sin necesidad de calcular distancias en el Backend. MySQL ofrece soporte geoespacial básico pero limitado para las consultas complejas que Tree Pruning requiere. MongoDB descartado porque las relaciones entre Árbol-Sector-PQR-Poda son inherentemente relacionales y los `joins` son críticos para los reportes municipales.

#### 9.1.2 Estilo arquitectónico: Layered N-Capas con Clean Architecture

**Alternativas consideradas:** Arquitectura monolítica clásica MVC, Hexagonal Architecture, Layered N-Capas con Clean Architecture, Microservicios completos.

**Criterios de evaluación:** mantenibilidad para un equipo académico pequeño (3 desarrolladores), testabilidad de la lógica de negocio, separación clara de responsabilidades, costo operativo de la infraestructura resultante, y aplicabilidad de las restricciones de ingeniería (RT-ING-001 SOLID, RT-ING-007 Clean Code).

**Decisión:** Layered N-Capas con Clean Architecture. Microservicios completos se descartaron por la complejidad operativa innecesaria para un sistema de cuatro módulos funcionales (Administración, Podas, PQR, Reportes) operado por una sola alcaldía. MVC clásico se descartó porque acopla demasiado la lógica de negocio a la infraestructura y dificulta los principios SOLID que se exigen. Hexagonal Architecture es muy similar y válida; Clean Architecture se prefirió por la claridad de su flujo de dependencias (`infrastructure → application → domain`, nunca al revés) que facilita la enseñanza del estilo en el equipo. La justificación detallada del estilo arquitectónico se desarrolla en la **[sección 8.2.1 — Estilo 1: Layered N-Capas](#sec-8-2-1)**.

#### 9.1.3 Framework de Frontend: Vue.js 3 + Bootstrap 5.3+

**Alternativas consideradas:** Vue.js 3 + Vuetify, Vue.js 3 + Tailwind CSS, Angular 17, React 18.

**Criterios de evaluación:** curva de aprendizaje del equipo (sin experiencia previa en frameworks reactivos pesados), tamaño del bundle final, compatibilidad con dispositivos institucionales del municipio (RNF-05.01.01: navegadores estándar), comunidad de componentes UI listos para usar, y consistencia visual con la guía gráfica del municipio.

**Decisión:** Vue.js 3 + Bootstrap 5.3+. Vue.js fue seleccionado sobre Angular y React por su curva de aprendizaje más suave y porque su Composition API y Single-File Components son didácticamente más claros para el equipo académico. Bootstrap fue elegido sobre Vuetify porque Vuetify impone un sistema de diseño Material que es estéticamente más opinionated, mientras que Bootstrap permite una identidad visual neutra y fácilmente adaptable a los colores institucionales del municipio. Tailwind CSS fue descartado por requerir más configuración inicial sin aportar componentes pre-construidos como modales, formularios validados y tablas, que Bootstrap provee out-of-the-box.

#### 9.1.4 Infraestructura de despliegue: Azure VM + Docker Compose + Traefik

**Alternativas consideradas:** Render (capa gratuita), Railway, Heroku, AWS Elastic Beanstalk, Google Cloud Run, Oracle Cloud Free Tier, Azure VM con licencia académica.

**Criterios de evaluación:** costo cero o muy bajo (RN-PRE-* presupuesto cero), capacidad de ejecutar simultáneamente más de 10 contenedores (PostgreSQL, Keycloak, Kong, MinIO, Strapi, Grafana, Prometheus, SonarQube, Traefik, Backend, Frontend), control completo sobre la red interna del sistema, integración con dominio personalizado (`treepruning.org`) y certificados SSL automáticos.

**Decisión:** Azure VM Standard_B4ms (4 vCPU, 16 GB RAM) con licencia académica gestionada por el equipo + Docker Compose + Traefik v2.11 como reverse proxy con Let's Encrypt vía Cloudflare DNS Challenge. Render y Heroku se descartaron porque su capa gratuita limita los contenedores a 1 por servicio y duerme el contenedor tras inactividad, lo que rompe la disponibilidad del sistema completo. AWS Beanstalk y Google Cloud Run cobran por uso, lo cual incumple la restricción de presupuesto cero. Oracle Cloud Free Tier fue una alternativa considerada como respaldo pero su ARM-only requiere imágenes Docker construidas específicamente para ARM64. Azure VM fue la opción seleccionada porque la licencia académica permite ejecutar la VM continuamente durante el semestre sin costos adicionales, y porque el control total del sistema operativo permite instalar exactamente las versiones de Docker, Traefik e Infisical CLI que el sistema requiere.

#### 9.1.5 Gestión de secretos: Infisical SaaS

**Alternativas consideradas:** HashiCorp Vault auto-hospedado, AWS Secrets Manager, Azure Key Vault, Infisical SaaS, variables de entorno en archivos `.env` versionados.

**Criterios de evaluación:** costo cero, no requerir mantenimiento operativo (RN-ORG-* el municipio no tiene personal técnico permanente), distribución segura de secretos hacia la VM y hacia GitHub Actions, rotación de secretos, capa gratuita suficiente para el volumen de secretos del proyecto.

**Decisión:** Infisical SaaS. HashiCorp Vault fue la alternativa inicial considerada porque es el estándar de la industria, pero se descartó por una razón operativa crítica: Vault requiere el proceso de **unseal** después de cada reinicio del servidor; si la VM se reinicia por una actualización del kernel, mantenimiento de Azure o un fallo, Vault queda en estado sellado y los secretos quedan inaccesibles hasta que un operador humano ejecute el proceso de unseal manual. Esto rompe la disponibilidad automática del sistema que el municipio requiere. Infisical, como SaaS, elimina completamente esta complejidad: los secretos están siempre disponibles vía API/CLI sin necesidad de un proceso de desbloqueo. AWS Secrets Manager y Azure Key Vault se descartaron por su modelo de cobro por secreto recuperado, que aunque económico, no es cero. Archivos `.env` versionados fueron descartados absolutamente por motivos de seguridad (RNF-02 Seguridad).

#### 9.1.6 IDE de desarrollo: Eclipse IDE 2024-12 con Spring Tools 4

**Alternativas consideradas:** IntelliJ IDEA Community/Ultimate, Visual Studio Code con extensiones Java, NetBeans, Eclipse IDE.

**Criterios de evaluación:** costo cero, soporte para Spring Boot, herramientas de refactorización, depuración remota de contenedores Docker, plugins activos para Java 26.

**Decisión:** Eclipse IDE 2024-12 con Spring Tools 4. IntelliJ Community ofrece mejor experiencia de desarrollo, pero sus capacidades para Spring Boot son limitadas en la edición Community (las funciones avanzadas de Spring están en Ultimate, que es de pago). Eclipse IDE con Spring Tools 4 proporciona soporte completo y gratuito para Spring Boot, incluyendo navegación entre beans, inspección de propiedades de configuración y plantillas de generación de clases. Visual Studio Code se evaluó pero las extensiones para Java no proveen el nivel de integración con Maven y Spring Boot que Eclipse ofrece de forma nativa. Esta decisión NO es una restricción técnica: es una elección de herramientas del equipo basada en la disponibilidad gratuita de Spring Tools.

<a id="sec-9-2"></a>
### 9.2 Ventajas

- **Costo operativo cero:** Todas las herramientas adoptadas operan en capa gratuita o bajo licencias open source sin restricciones de uso.
- **Despliegue reproducible:** Docker Compose permite recrear el entorno completo en cualquier VM con un solo comando. El INSTALL.md documenta el proceso completo en menos de 2 horas.
- **CI/CD integrado:** GitHub Actions automatiza la compilación, construcción de imagen Docker y despliegue en la VM sin infraestructura adicional de CI/CD.
- **Observabilidad completa:** La combinación Spring Actuator + Prometheus + Grafana proporciona dashboards de disponibilidad en tiempo real sin costo.
- **Seguridad perimetral sin costo:** Cloudflare WAF + CDN en capa gratuita protege el sistema contra OWASP Top 10 sin configuración activa.
- **HTTPS automático:** Traefik + Let's Encrypt vía Cloudflare DNS Challenge gestiona los certificados SSL automáticamente para todos los subdominios.
- **Separación de responsabilidades:** Cada servicio de soporte tiene su propia base de datos, eliminando interferencia entre servicios de infraestructura y el esquema de datos del sistema principal.

<a id="sec-9-3"></a>
### 9.3 Desventajas

- **Recursos limitados de la VM:** Con 16 GB RAM y 11 contenedores en ejecución, SonarQube (que requiere Elasticsearch) compite por memoria con Keycloak y Strapi. En carga pico puede requerir ajuste de límites de memoria por contenedor.
- **Sin alta disponibilidad:** Una sola VM (sin clustering ni load balancing) introduce un Single Point of Failure. El auto-restart de Docker (`restart: unless-stopped`) mitiga los fallos de contenedores individuales pero no los fallos de la VM.
- **Java 26 no es LTS:** Java 26 no tiene soporte a largo plazo (fin de soporte en septiembre 2026 con la salida de Java 27). Esto implica necesidad de actualización del Dockerfile y posibles incompatibilidades de plugins Maven en el corto plazo.
- **Token de Infisical con expiración:** El Access Token de Infisical expira cada 30 días, requiriendo renovación manual mensual en el servidor. El servicio systemd está configurado para auto-renovación pero depende de que las variables CLIENT_ID y CLIENT_SECRET estén vigentes en `.bashrc`.
- **Keycloak requiere HTTPS para acceso externo:** Keycloak en modo `start-dev` no permite acceso HTTP desde IPs públicas, requiriendo el dominio `auth.treepruning.org` con SSL para que el Identity Provider sea accesible. Esto significa que sin el dominio activo, el acceso al panel de administración solo es posible vía túnel SSH.

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-10"></a>
## 10. Vistas de Arquitectura del Sistema

Las vistas de arquitectura son representaciones del sistema desde diferentes perspectivas que permiten comprender, comunicar y verificar distintos aspectos del diseño.

<a id="sec-10-1"></a>
### 10.1 Vista Funcional / Vista de Escenarios / Vista de Casos de Uso

La vista funcional describe el sistema desde la perspectiva del negocio, mostrando los procesos, los actores, los contextos acotados y los casos de uso que el sistema debe soportar.

<a id="sec-10-1-1"></a>
#### 10.1.1 Modelo de Procesos del Negocio

El modelo de procesos del negocio describe los flujos de trabajo que Tree Pruning digitaliza y automatiza en el municipio de Rionegro.

**Proceso 1: Gestión del inventario de arbolado urbano**

El municipio mantiene un inventario de los árboles en el espacio público. Actualmente este proceso es manual (Excel). Con Tree Pruning, el Administrador registra cada árbol con sus atributos (familia botánica, especie, dimensiones, estado de riesgo, ubicación GPS) y lo georreferencia en el mapa interactivo. El sistema almacena el historial completo de cada árbol, incluyendo todas las intervenciones realizadas.

**Proceso 2: Planificación y ejecución de podas**

El Encargado de Cuadrilla planifica las podas preventivas anuales para cada árbol según la programación de frecuencia establecida, y las podas correctivas derivadas de PQR ciudadanas. Durante la ejecución en campo, registra la fecha de ejecución, la cuadrilla y herramientas utilizadas, y sube evidencia fotográfica. El sistema notifica automáticamente a los involucrados mediante FCM.

**Proceso 3: Gestión de PQR ciudadanas**

El Ciudadano registra una solicitud (poda, revisión de árbol en riesgo, reporte de emergencia) con descripción, fotografía y ubicación en el mapa. El sistema asigna automáticamente la PQR y gestiona los plazos legales (Ley 1755). El Encargado actualiza el estado y el Ciudadano recibe notificaciones push en cada cambio de estado.

**Proceso 4: Generación de reportes institucionales**

El Administrador genera reportes filtrados por sector, fecha, estado de poda o tipo de árbol para presentar a entidades de control. Los reportes exportan en PDF o Excel incluyendo datos de trazabilidad (quién generó, cuándo, para quién).

<a id="sec-10-1-2"></a>
#### 10.1.2 Modelado de Dominio

El modelado de dominio aplica los principios de Domain-Driven Design (DDD) para descomponer Tree Pruning en áreas de negocio cohesivas e independientes (Bounded Contexts), cada una con su propio lenguaje ubicuo y modelo de objetos. Esto permite que cada contexto evolucione de forma autónoma sin generar acoplamiento accidental entre módulos.

##### 10.1.2.1 Modelo de Contextos Acotados

Tree Pruning se organiza en cuatro contextos acotados (Bounded Contexts) que representan las áreas de negocio independientes del sistema:

> **📷 Diagrama requerido — Modelo de Contextos Acotados**  
> **Archivo:** `./images/tp-bounded-contexts.png`  
> **Descripción esperada:** Diagrama de los cuatro Bounded Contexts (Inventario, Podas, PQR, Personas y Acceso) representados como áreas independientes con sus entidades principales. Cada contexto debe tener un color distinto y listar sus aggregate roots.

![Modelo de Contextos Acotados](./images/tp-bounded-contexts.png)

**Contexto 1: Inventario**

Dominio: Gestión del inventario georreferenciado de árboles del municipio.

Entidades principales: `Árbol`, `Familia`, `Sector`, `Municipio`, `Programación`.

El árbol es la entidad central del sistema. Cada árbol tiene una ubicación GPS (latitud/longitud), pertenece a una familia botánica, está asignado a un sector geográfico y puede tener una programación de poda preventiva asociada.

**Contexto 2: Podas**

Dominio: Planificación, programación y registro de ejecución de intervenciones de poda.

Entidades principales: `Poda`, `TipoPoda`, `Estado`, `Cuadrilla`, `Herramienta`, `PodaHerramienta`.

Una poda está asociada a un árbol específico, tiene un tipo (preventiva/correctiva), un estado (programada/en ejecución/ejecutada/cancelada), una cuadrilla responsable, y puede tener evidencia fotográfica almacenada en MinIO.

**Contexto 3: PQR**

Dominio: Gestión de solicitudes ciudadanas relacionadas con el arbolado urbano.

Entidades principales: `PQR`, `Estado`, `Riesgo`.

Una PQR es creada por un Ciudadano, tiene un estado de trámite, un nivel de riesgo asociado, y puede derivar en la creación de una Poda correctiva.

**Contexto 4: Personas y Acceso**

Dominio: Gestión de usuarios del sistema y sus roles.

Entidades principales: `Persona`, `Documento`, `Administrador`, `Operador`, `Cuadrilla`, `Manager`.

La autenticación y autorización se delegan a Keycloak. El Backend gestiona el modelo de dominio de personas asociado a los roles operativos del sistema.

##### 10.1.2.2 Modelo de Mapeo de Contextos (Context Mapping)

El mapeo de contextos describe las relaciones entre los contextos acotados y los patrones de integración aplicados. Tree Pruning utiliza tres patrones estratégicos de DDD:

- **Customer/Supplier (Cliente/Proveedor):** Cuando un contexto consume servicios estables de otro contexto upstream.
- **Conformist (Conformista):** Cuando un contexto downstream adopta el modelo del contexto upstream sin traducción (típicamente con servicios de terceros).
- **Shared Kernel (Núcleo Compartido):** Un subconjunto reducido de modelo compartido entre dos contextos para minimizar duplicación.

**Relaciones entre contextos:**

| Origen | Destino | Patrón | Descripción de la relación |
|---|---|---|---|
| Podas | Inventario | Customer/Supplier | El contexto de Podas consume árboles del contexto de Inventario para asociarlos a una intervención. Inventario es upstream y define el modelo de `Árbol`. |
| PQR | Inventario | Customer/Supplier | El contexto de PQR consulta el árbol y el sector asociados a una solicitud ciudadana. Inventario es upstream. |
| PQR | Podas | Customer/Supplier | Cuando una PQR se aprueba, el contexto de Podas crea una poda correctiva asociada a la PQR. PQR es upstream del flujo de creación. |
| Podas | Personas y Acceso | Shared Kernel | Las entidades `Operador`, `Cuadrilla` y `Manager` son compartidas entre Podas (asignación de cuadrilla a una poda) y Personas y Acceso (gestión de operarios). |
| PQR | Personas y Acceso | Customer/Supplier | El contexto de PQR registra al Ciudadano que realiza la solicitud. Personas y Acceso es upstream. |
| Todos los contextos | Keycloak (IDP externo) | Conformist | Todos los contextos consumen identidades del IDP externo sin traducción del modelo. El JWT de Keycloak define el contrato de identidad y los contextos se adaptan a él. |
| Todos los contextos | Strapi (Catálogo Maestro) | Conformist | Los catálogos maestros (Tipos de Poda, Estados, Riesgos, Familias botánicas) son administrados en Strapi (CMS Headless) y los contextos los consumen vía API REST sin traducción. |

**Documentación del mapeo:**

La elección de Customer/Supplier como patrón dominante refleja la naturaleza unidireccional de los flujos de negocio del municipio: el inventario es la fuente de verdad sobre el arbolado, y los demás contextos derivan información a partir de él. El Shared Kernel se aplica únicamente entre Podas y Personas para evitar duplicación del modelo de operario, ya que ambos contextos necesitan operar sobre las mismas instancias de `Operador` y `Cuadrilla` con consistencia inmediata. El patrón Conformist se aplica a integraciones con sistemas externos (Keycloak, Strapi) porque el costo de mantener una capa anticorrupción para estos sistemas no se justifica en un sistema académico-municipal de pequeña escala.

> **📷 Diagrama requerido — Mapa de Contextos (Context Mapping)**  
> **Archivo:** `./images/tp-context-mapping.png`  
> **Descripción esperada:** Diagrama de Context Mapping de DDD que muestre los cuatro contextos como nodos conectados por flechas con la nomenclatura U (upstream) y D (downstream), etiquetando cada relación con su patrón (Customer/Supplier, Shared Kernel, Conformist). Incluir los sistemas externos Keycloak y Strapi.

![Mapa de Contextos](./images/tp-context-mapping.png)

##### 10.1.2.3 Modelos de Dominio por Contexto

Para cada contexto acotado se presenta un modelo anémico (estructura de datos sin comportamiento) y un modelo enriquecido (con responsabilidades, invariantes y reglas de negocio incluidas en las entidades).

**Contexto 1: Inventario — Modelo Anémico**

```
Árbol
  ├── id: UUID
  ├── latitud: Decimal
  ├── longitud: Decimal
  ├── familia_id: UUID (FK)
  ├── sector_id: UUID (FK)
  └── programacion_id: UUID (FK)

Familia
  ├── id: UUID
  ├── nombreCientifico: String
  └── nombreComun: String

Sector
  ├── id: UUID
  ├── nombre: String
  └── municipio_id: UUID (FK)

Programación
  ├── id: UUID
  ├── fechaInicial: Date
  ├── frecuenciaMeses: Integer
  └── cantidad: Integer
```

**Contexto 1: Inventario — Modelo Enriquecido**

`Árbol` (Aggregate Root del contexto). Responsabilidades:
- Validar que las coordenadas GPS estén dentro de los límites territoriales del municipio (invariante).
- Calcular la próxima fecha de poda preventiva a partir de la `Programación` asociada.
- Verificar si el árbol está en zona de protección ambiental antes de permitir intervenciones (consulta el sector).
- Combinación única: la tupla (`latitud`, `longitud`) debe ser única por municipio para evitar duplicados georreferenciados.
- Dato sensible: ninguno (datos públicos de espacio público).

`Familia`: Catálogo de referencia administrado por el contexto. Responsabilidad: garantizar nombres científicos válidos según taxonomía botánica.

`Sector`: Subdivisión territorial. Responsabilidad: encapsular información geográfica (polígono del sector) para validar pertenencia de coordenadas.

`Programación`: Política de mantenimiento preventivo. Responsabilidad: generar las fechas calculadas de las podas preventivas anuales en una operación transaccional.

**Contexto 2: Podas — Modelo Anémico**

```
Poda
  ├── id: UUID
  ├── arbol_id: UUID (FK)
  ├── tipo_id: UUID (FK)
  ├── estado_id: UUID (FK)
  ├── cuadrilla_id: UUID (FK)
  ├── pqr_id: UUID (FK, nullable)
  ├── fechaPlanificada: Date
  ├── fechaEjecutada: Date (nullable)
  ├── observaciones: String
  └── rutaReporteFotografico: String

TipoPoda
  ├── id: UUID
  └── nombre: String  ('preventiva' | 'correctiva')

Estado
  ├── id: UUID
  └── nombre: String  ('programada' | 'en_ejecucion' | 'ejecutada' | 'cancelada')

Herramienta
  ├── id: UUID
  ├── nombre: String
  └── descripcion: String

PodaHerramienta
  ├── poda_id: UUID (FK)
  ├── herramienta_id: UUID (FK)
  └── cantidad: Integer
```

**Contexto 2: Podas — Modelo Enriquecido**

`Poda` (Aggregate Root). Responsabilidades:
- Garantizar que `fechaEjecutada >= fechaPlanificada` (invariante temporal).
- Transición de estado válida: `programada → en_ejecucion → ejecutada` o `programada → cancelada`. Cualquier transición fuera de este flujo se rechaza con excepción de dominio.
- Una poda correctiva debe tener `pqr_id` no nulo. Una poda preventiva debe tener `pqr_id` nulo.
- Para marcar como `ejecutada`, debe tener al menos una `PodaHerramienta` asociada y la `rutaReporteFotografico` cargada (validación de completitud).
- Publicación del evento `PodaEjecutada` al marcar la poda como ejecutada.
- Dato sensible: ninguno (información operacional municipal).

`PodaHerramienta`: Value Object que asocia herramientas con cantidad utilizada. Inmutable una vez creado.

`Cuadrilla`: Referencia hacia Personas y Acceso (Shared Kernel). Responsabilidad de carga: validar que la cuadrilla tenga al menos un operador y un manager activo.

**Contexto 3: PQR — Modelo Anémico**

```
PQR
  ├── id: UUID
  ├── fecha: Date
  ├── estado_id: UUID (FK)
  ├── persona_id: UUID (FK)
  ├── sector_id: UUID (FK)
  ├── riesgo_id: UUID (FK)
  └── rutaRegistroFotografico: String

Riesgo
  ├── id: UUID
  └── nombre: String  ('bajo' | 'medio' | 'alto' | 'critico')

Estado
  ├── id: UUID
  └── nombre: String  ('radicada' | 'en_tramite' | 'cerrada' | 'rechazada')
```

**Contexto 3: PQR — Modelo Enriquecido**

`PQR` (Aggregate Root). Responsabilidades:
- Al crear una PQR, calcular automáticamente el plazo legal de respuesta según el `Riesgo`: crítico → 1 día hábil, alto → 5 días hábiles, medio/bajo → 15 días hábiles (Ley 1755 de 2015 con escalamiento por riesgo).
- Combinación única: no se permite más de una PQR activa (no cerrada) por (`persona_id`, `sector_id`) sobre el mismo árbol en una ventana de 24 horas (anti-duplicado).
- Transición de estado: `radicada → en_tramite → cerrada` o `radicada → rechazada`. La transición a `cerrada` requiere que exista una `Poda` asociada con estado `ejecutada`.
- Publicación de eventos: `PQRCreada`, `PQRAsignada`, `PQRCerrada`.
- Dato sensible: información personal del ciudadano (Ley 1581 de 2012). Solo visible para el ciudadano titular y para roles administrativos autorizados.

**Contexto 4: Personas y Acceso — Modelo Anémico**

```
Persona
  ├── id: UUID
  ├── nombres: String
  ├── apellidos: String
  ├── documento_id: UUID (FK)
  ├── numeroDocumento: String
  ├── correo: String
  ├── telefono: String
  └── edad: Integer

Documento
  ├── id: UUID
  ├── nombre: String  ('Cédula' | 'Tarjeta de Identidad' | 'Pasaporte')
  └── codigo: String

Operador
  ├── id: UUID
  ├── persona_id: UUID (FK)
  └── cuadrilla_id: UUID (FK, nullable)

Manager
  ├── id: UUID
  └── persona_id: UUID (FK)

Cuadrilla
  ├── id: UUID
  ├── nombre: String
  └── manager_id: UUID (FK, nullable)
```

**Contexto 4: Personas y Acceso — Modelo Enriquecido**

`Persona` (Aggregate Root). Responsabilidades:
- Validar unicidad de (`documento_id`, `numeroDocumento`) — combinación única que identifica a la persona en el sistema.
- Validar formato del correo electrónico y del teléfono según convenciones colombianas.
- Dato sensible: correo, teléfono, número de documento. Solo visibles para el titular y roles administrativos. La generación de reportes con datos personales requiere logging de auditoría obligatorio.

`Cuadrilla`: Agregado del Shared Kernel con Podas. Responsabilidad: garantizar que toda cuadrilla activa tiene un manager asignado antes de aceptar la asignación a una poda. Si el manager se desactiva, la cuadrilla queda en estado "sin manager" y no acepta nuevas podas hasta reasignación.

`Operador` y `Manager`: Roles operativos. Responsabilidad: encapsular las reglas de pertenencia a cuadrilla (un operador pertenece a una cuadrilla a la vez; un manager puede liderar varias cuadrillas).

> **Nota:** La caracterización detallada de cada objeto de dominio (atributos con tipos y longitudes, combinaciones únicas, políticas aplicadas y muestreos de datos representativos) se documenta en la **[Vista Lógica — sección 10.3](#sec-10-3)**, ya que pertenece a la perspectiva estructural-estática del sistema. Los modelos anémico y enriquecido presentados arriba describen la perspectiva de DDD (lenguaje ubicuo y responsabilidades por contexto); la sección 10.3 amplía con el detalle técnico de cada entidad para el diseño de la base de datos y las clases de persistencia.

<a id="sec-10-1-3"></a>
#### 10.1.3 Flujo de Eventos / Event Storming

Los eventos de dominio relevantes para Tree Pruning son:

| Evento | Disparador | Consecuencias |
|---|---|---|
| `ArbolRegistrado` | Administrador crea árbol | Árbol disponible en mapa, inventario actualizado |
| `PodaProgramada` | Encargado programa poda | Notificación push al encargado, poda visible en calendario |
| `PodaEjecutada` | Encargado marca poda como ejecutada | Evidencia almacenada en MinIO, historial del árbol actualizado, trazabilidad registrada |
| `PQRCreada` | Ciudadano registra PQR | Notificación al administrador, contador de plazo legal iniciado |
| `PQRAsignada` | Administrador asigna PQR | Notificación al encargado, PQR vinculada a poda correctiva |
| `PQRCerrada` | Encargado cierra PQR | Notificación al ciudadano, trazabilidad de cierre registrada |
| `SesionBloqueada` | 3 intentos fallidos consecutivos | Cuenta bloqueada 5 minutos, evento de seguridad registrado |
| `CuentaBloqueada` | 5 intentos fallidos en 10 minutos | Cuenta bloqueada, notificación al administrador |

> **📷 Diagrama requerido — Event Storming**  
> **Archivo:** `./images/tp-event-storming.png`  
> **Descripción esperada:** Diagrama de Event Storming con la línea temporal de los eventos de dominio: notas naranjas para los eventos (ArbolRegistrado, PodaProgramada, PodaEjecutada, PQRCreada, PQRAsignada, PQRCerrada, SesionBloqueada, CuentaBloqueada), notas azules para los comandos disparadores, notas amarillas para los actores y notas rosadas para las políticas/reglas activadas.

![Event Storming](./images/tp-event-storming.png)

<a id="sec-10-1-4"></a>
#### 10.1.4 Glosario de Términos del Negocio

El glosario de términos del negocio es el diccionario común del proyecto: una lista en orden alfabético con la definición precisa de cada concepto, sigla o entidad que se utiliza de forma recurrente en el dominio del problema. Su propósito es eliminar ambigüedades en la comunicación entre el equipo de desarrollo, el cliente municipal y los demás interesados, garantizando que todos los actores interpreten los términos del mismo modo cuando aparecen en requisitos, casos de uso, código fuente o diagramas. El glosario forma parte del *lenguaje ubicuo* (ubiquitous language) de DDD y se actualiza a lo largo del proyecto a medida que aparecen nuevos términos del negocio.

| Término | Definición |
|---|---|
| **Arbolado urbano** | Conjunto de árboles ubicados en el espacio público del municipio (andenes, parques, separadores viales) bajo responsabilidad del municipio |
| **Cuadrilla** | Equipo de operarios responsables de ejecutar las intervenciones de poda en campo bajo la dirección de un Encargado |
| **Encargado de cuadrilla** | Funcionario municipal o contratista responsable de coordinar y registrar las actividades de poda |
| **Inventario de arbolado** | Registro sistematizado de todos los árboles del espacio público con sus atributos taxonómicos, físicos, de riesgo y ubicación GPS |
| **PQR** | Petición, Queja o Reclamo ciudadana relacionada con el estado del arbolado urbano, gestionada bajo la Ley 1755 |
| **Poda correctiva** | Intervención de poda generada en respuesta a una PQR ciudadana o situación de emergencia |
| **Poda preventiva** | Intervención de poda programada con anticipación según la frecuencia de mantenimiento definida para cada árbol |
| **Programación** | Configuración que define la frecuencia de podas preventivas para un árbol (inicial_date, frequency_months, amount) |
| **Sector** | División geográfica del municipio utilizada para organizar el inventario y asignar responsabilidades de cuadrillas |
| **RBAC** | Role-Based Access Control — control de acceso basado en roles implementado mediante Keycloak |

<a id="sec-10-1-5"></a>
#### 10.1.5 Especificación de Requisitos de Software

La especificación de requisitos de software documenta de forma estructurada qué debe hacer Tree Pruning (requisitos funcionales), bajo qué restricciones de calidad (no funcionales), qué información debe gestionar (requisitos de información), qué necesita el usuario (requisitos de usuario) y qué reglas del negocio se aplican (reglas de negocio). Esta especificación es la base contractual entre el equipo de desarrollo y el cliente municipal, y soporta la trazabilidad entre necesidades del usuario y elementos de diseño.

##### 10.1.5.1 Requisitos de Usuario

Los requisitos de usuario describen, en lenguaje del negocio, las necesidades que cada actor del sistema espera ver satisfechas.

| Código | Actor | Necesidad |
|---|---|---|
| **RU-001** | Administrador del sistema | Necesito gestionar usuarios y asignar roles para garantizar el control de acceso al sistema. |
| **RU-002** | Administrador del sistema | Necesito mantener el inventario georreferenciado de árboles del municipio para la planificación. |
| **RU-003** | Administrador del sistema | Necesito generar reportes filtrados y exportables para presentar a entidades de control. |
| **RU-004** | Administrador del sistema | Necesito visualizar indicadores en tiempo real para tomar decisiones sobre el arbolado. |
| **RU-005** | Encargado de Cuadrilla | Necesito programar podas preventivas y correctivas asignándolas a una cuadrilla y fecha. |
| **RU-006** | Encargado de Cuadrilla | Necesito registrar la ejecución de una poda con evidencia fotográfica y herramientas utilizadas. |
| **RU-007** | Encargado de Cuadrilla | Necesito visualizar el mapa de árboles y podas asignadas a mi cuadrilla. |
| **RU-008** | Ciudadano | Necesito registrar una PQR sobre el arbolado urbano con descripción, fotografía y ubicación. |
| **RU-009** | Ciudadano | Necesito hacer seguimiento al estado de mi PQR y recibir notificaciones de cambios. |
| **RU-010** | Todos | Necesito autenticarme de forma segura con mi cuenta institucional o ciudadana. |

##### 10.1.5.2 Requisitos Funcionales

Los requisitos funcionales especifican el comportamiento del sistema en términos de acciones, entradas y salidas verificables.

| Código | Módulo | Requisito |
|---|---|---|
| **RF-001** | Administración | El sistema debe permitir al Administrador crear, modificar, activar y desactivar usuarios. |
| **RF-002** | Administración | El sistema debe permitir asignar uno o más roles (Administrador, Encargado, Ciudadano) a cada usuario. |
| **RF-003** | Administración | El sistema debe permitir gestionar catálogos maestros: Familias botánicas, Tipos de poda, Estados, Riesgos, Herramientas, Documentos. |
| **RF-004** | Administración | El sistema debe permitir definir sectores geográficos del municipio con polígonos GeoJSON. |
| **RF-005** | Inventario | El sistema debe permitir registrar árboles con atributos taxonómicos, físicos y coordenadas GPS. |
| **RF-006** | Inventario | El sistema debe permitir visualizar el inventario en un mapa interactivo con filtros por sector, familia y estado. |
| **RF-007** | Inventario | El sistema debe permitir configurar una Programación de poda preventiva por árbol (fecha inicial, frecuencia, cantidad). |
| **RF-008** | Inventario | El sistema debe permitir consultar el historial completo de intervenciones de un árbol. |
| **RF-009** | Podas | El sistema debe permitir generar las podas preventivas anuales de un árbol a partir de su Programación, en una única operación atómica. |
| **RF-010** | Podas | El sistema debe permitir programar una poda correctiva derivada de una PQR aprobada. |
| **RF-011** | Podas | El sistema debe permitir asignar una cuadrilla y una fecha planificada a cada poda. |
| **RF-012** | Podas | El sistema debe permitir registrar la ejecución de una poda: fecha real, herramientas utilizadas, observaciones y reporte fotográfico. |
| **RF-013** | Podas | El sistema debe enviar notificaciones push (FCM) a los involucrados ante eventos de programación y cambio de estado. |
| **RF-014** | PQR | El sistema debe permitir al Ciudadano registrar una PQR con descripción, fotografía, ubicación y nivel de riesgo. |
| **RF-015** | PQR | El sistema debe asignar automáticamente un plazo legal de respuesta según el nivel de riesgo. |
| **RF-016** | PQR | El sistema debe permitir al Administrador asignar una PQR a un Encargado y aprobarla o rechazarla. |
| **RF-017** | PQR | El sistema debe permitir al Ciudadano consultar el estado de sus PQR y recibir notificaciones push. |
| **RF-018** | Reportes | El sistema debe generar reportes por sector, fecha, estado de poda, tipo de árbol y cuadrilla. |
| **RF-019** | Reportes | El sistema debe permitir exportar reportes en formatos PDF y Excel. |
| **RF-020** | Reportes | El sistema debe permitir programar el envío automático de reportes por correo a destinatarios institucionales. |
| **RF-021** | Transversal | El sistema debe registrar trazabilidad de todas las acciones de creación, modificación y eliminación. |
| **RF-022** | Transversal | El sistema debe autenticar usuarios mediante OIDC contra Keycloak y validar JWT en cada petición. |

##### 10.1.5.3 Requisitos No Funcionales

Los requisitos no funcionales restringen el cómo del sistema. Se derivan directamente de los escenarios de calidad de la sección 3.3.

| Código | Atributo de calidad | Requisito |
|---|---|---|
| **RNF-001** | Rendimiento | El registro de cualquier entidad (árbol, sector, PQR, poda, herramienta) debe completarse en un tiempo ≤ al definido en la Matriz de Tiempos (≤ 3 segundos para operaciones de escritura unitarias). |
| **RNF-002** | Rendimiento | La carga del mapa con árboles georreferenciados debe completarse en ≤ 5 segundos en condiciones normales. |
| **RNF-003** | Confiabilidad | Todas las operaciones de escritura deben ser transaccionales (ACID). Ante fallo parcial, el sistema debe revertir todos los cambios. |
| **RNF-004** | Seguridad | El sistema debe bloquear la cuenta tras 5 intentos fallidos consecutivos en menos de 10 minutos y notificar al Administrador. |
| **RNF-005** | Seguridad | El acceso a cada módulo debe estar restringido por rol (RBAC). El menú debe ocultar módulos no autorizados. |
| **RNF-006** | Seguridad | Toda comunicación con el sistema debe usar HTTPS/TLS 1.2 o superior. |
| **RNF-007** | Disponibilidad | El sistema debe garantizar disponibilidad del 99.5% durante el horario laboral 6 AM – 6 PM, lunes a sábado. |
| **RNF-008** | Escalabilidad | La desactivación de cualquier funcionalidad nueva no debe afectar el funcionamiento de los módulos base. |
| **RNF-009** | Trazabilidad | Cada intento de autenticación (exitoso o fallido) debe quedar registrado en el log de eventos de seguridad. |
| **RNF-010** | Usabilidad | Todos los formularios deben presentar comportamiento y estilo uniforme: indicador de campo activo, asterisco en campos obligatorios, mensajes de error inline. |
| **RNF-011** | Accesibilidad | La interfaz debe cumplir nivel AA de las WCAG 2.1 en contraste, navegación por teclado y etiquetado de formularios. |
| **RNF-012** | Costo | El sistema debe operar con presupuesto cero, usando solo tecnologías open source o en capa gratuita permanente. |
| **RNF-013** | Mantenibilidad | El código fuente debe alcanzar al menos un Quality Gate "Passed" en SonarQube con cobertura ≥ 70% en clases de dominio. |
| **RNF-014** | Conformidad | El tratamiento de datos personales debe cumplir la Ley 1581 de 2012. La gestión de PQR debe cumplir la Ley 1755 de 2015. |

##### 10.1.5.4 Requisitos de Información

Los requisitos de información describen la información que el sistema debe almacenar, mostrar y proteger.

| Código | Requisito |
|---|---|
| **RI-001** | El sistema debe almacenar el inventario completo de árboles del municipio con todos sus atributos taxonómicos y geoespaciales. |
| **RI-002** | El sistema debe almacenar el historial inmutable de todas las podas ejecutadas, incluyendo evidencia fotográfica en MinIO. |
| **RI-003** | El sistema debe almacenar todas las PQR ciudadanas con sus estados y fechas de transición, incluso después de cerradas. |
| **RI-004** | El sistema debe almacenar la trazabilidad de todas las acciones administrativas (quién, cuándo, qué, sobre qué entidad). |
| **RI-005** | El sistema debe almacenar los catálogos maestros (Tipos de poda, Estados, Riesgos, Familias, Herramientas) gestionados por Strapi. |
| **RI-006** | El sistema debe almacenar los parámetros operativos (plazos legales, umbrales de bloqueo, banderas de funcionalidad) en Spring Cloud Config. |
| **RI-007** | El sistema debe presentar al Ciudadano únicamente sus propias PQR, no las de otros ciudadanos. |
| **RI-008** | El sistema debe presentar al Encargado únicamente las podas asignadas a su cuadrilla. |
| **RI-009** | Las evidencias fotográficas deben almacenarse con URL firmadas con TTL para evitar acceso público directo. |

##### 10.1.5.5 Reglas de Negocio

Las reglas de negocio son políticas del dominio que el sistema debe garantizar en todas las operaciones.

| Código | Regla |
|---|---|
| **RN-BIZ-001** | No se permite registrar dos árboles con las mismas coordenadas GPS dentro del mismo municipio. |
| **RN-BIZ-002** | Toda Poda debe estar asociada a un Árbol existente y vigente en el inventario. |
| **RN-BIZ-003** | Una Poda preventiva no puede tener una PQR asociada; una Poda correctiva debe tener una PQR asociada. |
| **RN-BIZ-004** | La fecha de ejecución de una Poda no puede ser anterior a la fecha de planificación. |
| **RN-BIZ-005** | Una Poda solo puede marcarse como `ejecutada` si tiene al menos una herramienta registrada y reporte fotográfico cargado. |
| **RN-BIZ-006** | El plazo legal de respuesta de una PQR depende del riesgo: crítico = 1 día hábil, alto = 5 días hábiles, medio/bajo = 15 días hábiles. |
| **RN-BIZ-007** | No se permite más de una PQR activa por (ciudadano, árbol) en una ventana de 24 horas. |
| **RN-BIZ-008** | Toda Cuadrilla activa debe tener un Manager asignado para aceptar podas. |
| **RN-BIZ-009** | Un Operador solo puede pertenecer a una Cuadrilla simultáneamente. |
| **RN-BIZ-010** | La PQR solo puede cerrarse si la Poda correctiva asociada está en estado `ejecutada`. |
| **RN-BIZ-011** | Los reportes que incluyan datos personales deben registrar un evento de auditoría con quien lo generó y para qué propósito. |
| **RN-BIZ-012** | La cuenta de un usuario se bloquea automáticamente tras 5 intentos fallidos en menos de 10 minutos. |

<a id="sec-10-1-6"></a>
#### 10.1.6 Casos de Uso

Los casos de uso describen la interacción de los actores con el sistema para satisfacer un objetivo del negocio. Para cada módulo se identifican los casos de uso principales; cada uno se documenta posteriormente con datos básicos, escenarios y flujos.

##### 10.1.6.1 Modelo de Contexto de Casos de Uso

El modelo de contexto de casos de uso muestra los actores del sistema y las fronteras de los módulos sobre los que actúan. Los tres actores humanos (Administrador, Encargado de Cuadrilla, Ciudadano) interactúan con el sistema, que a su vez consume servicios externos (Keycloak para identidad, FCM para notificaciones, Google Maps para visualización geográfica).

##### 10.1.6.2 Diagrama de Casos de Uso por Módulo

**Módulo Administración** (Actor principal: Administrador)
- CU-ADM-001: Crear usuario
- CU-ADM-002: Asignar rol a usuario
- CU-ADM-003: Activar/desactivar usuario
- CU-ADM-004: Gestionar catálogos maestros
- CU-ADM-005: Definir sector geográfico

> **📷 Diagrama de casos de uso — Módulo Administración**  
> **Archivo:** `./images/tp-uc-admin.png`

![CU Módulo Administración](./images/tp-uc-admin.png)

**Módulo Inventario** (Actor principal: Administrador)
- CU-INV-001: Registrar árbol
- CU-INV-002: Modificar árbol
- CU-INV-003: Configurar programación de poda preventiva
- CU-INV-004: Visualizar inventario en mapa
- CU-INV-005: Consultar historial de árbol

> **📷 Diagrama de casos de uso — Módulo Inventario**  
> **Archivo:** `./images/tp-uc-inventario.png`

![CU Módulo Inventario](./images/tp-uc-inventario.png)

**Módulo Podas** (Actor principal: Encargado de Cuadrilla)
- CU-POD-001: Generar podas preventivas anuales
- CU-POD-002: Programar poda correctiva desde PQR
- CU-POD-003: Asignar cuadrilla y fecha a poda
- CU-POD-004: Registrar ejecución de poda con evidencia
- CU-POD-005: Cancelar poda programada

> **📷 Diagrama de casos de uso — Módulo Podas**  
> **Archivo:** `./images/tp-uc-podas.png`

![CU Módulo Podas](./images/tp-uc-podas.png)

**Módulo PQR** (Actor principal: Ciudadano)
- CU-PQR-001: Registrar PQR ciudadana
- CU-PQR-002: Consultar estado de PQR
- CU-PQR-003: Asignar PQR (Administrador)
- CU-PQR-004: Cerrar PQR (Encargado)

> **📷 Diagrama de casos de uso — Módulo PQR**  
> **Archivo:** `./images/tp-uc-pqr.png`

![CU Módulo PQR](./images/tp-uc-pqr.png)

**Módulo Reportes** (Actor principal: Administrador)
- CU-REP-001: Generar reporte filtrado
- CU-REP-002: Exportar reporte a PDF/Excel
- CU-REP-003: Programar envío automático de reporte

> **📷 Diagrama de casos de uso — Módulo Reportes**  
> **Archivo:** `./images/tp-uc-reportes.png`

![CU Módulo Reportes](./images/tp-uc-reportes.png)

**Módulo Transversal** (Actor: Todos)
- CU-AUT-001: Iniciar sesión
- CU-AUT-002: Cerrar sesión
- CU-AUT-003: Recuperar contraseña

> **📷 Diagrama de casos de uso — Módulo Transversal**  
> **Archivo:** `./images/tp-uc-transversal.png`

![CU Módulo Transversal](./images/tp-uc-transversal.png)

##### 10.1.6.3 Especificación Detallada — Casos de Uso Representativos

A continuación se detallan tres casos de uso representativos (uno por actor principal). El detalle completo de los demás casos se mantiene en documento aparte para no extender este DAS.

**CU-INV-001 — Registrar Árbol**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-INV-001 |
| **Nombre** | Registrar Árbol |
| **Descripción** | El Administrador registra un nuevo árbol en el inventario georreferenciado con sus atributos taxonómicos, físicos y de ubicación. |
| **Actores** | Administrador (principal) |
| **Referencias cruzadas** | RF-005, RU-002, RN-BIZ-001 |
| **Precondiciones** | El Administrador está autenticado y tiene rol `administrator`. Existen al menos una Familia botánica y un Sector configurados. |
| **Postcondiciones (éxito)** | El árbol queda registrado con UUID único, visible en el mapa, con evento `ArbolRegistrado` publicado. |
| **Postcondiciones (fallo)** | No se persiste ningún cambio; se muestra mensaje descriptivo del error. |

*Flujo normal:*
1. El Administrador accede al módulo Inventario y selecciona "Registrar árbol".
2. El sistema presenta el formulario con campos: Familia, Sector, Latitud, Longitud, Programación (opcional).
3. El Administrador completa los campos y hace clic en "Guardar".
4. El sistema valida que las coordenadas están dentro de los límites del municipio (RN-BIZ-001).
5. El sistema valida que no exista otro árbol con las mismas coordenadas.
6. El sistema persiste el árbol y publica el evento `ArbolRegistrado`.
7. El sistema muestra mensaje de éxito y refresca el listado.

*Flujo alterno A1 — Coordenadas fuera del municipio:* En el paso 4, si las coordenadas están fuera de los polígonos del municipio, el sistema muestra error "Coordenadas fuera del municipio de Rionegro" y permite corrección.

*Flujo alterno A2 — Árbol duplicado:* En el paso 5, si existe un árbol con las mismas coordenadas, el sistema muestra error con enlace al árbol existente.

*Flujo excepcional E1 — Pérdida de conexión:* Si se pierde la conexión durante el paso 6, el sistema revierte la transacción (RNF-003) y permite reintento.

**CU-POD-004 — Registrar Ejecución de Poda**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-POD-004 |
| **Nombre** | Registrar Ejecución de Poda |
| **Descripción** | El Encargado de Cuadrilla registra que una poda programada se ha ejecutado, cargando la evidencia fotográfica y las herramientas utilizadas. |
| **Actores** | Encargado de Cuadrilla (principal) |
| **Referencias cruzadas** | RF-012, RU-006, RN-BIZ-004, RN-BIZ-005 |
| **Precondiciones** | El Encargado está autenticado. La poda existe en estado `programada` o `en_ejecucion` y está asignada a su cuadrilla. |
| **Postcondiciones (éxito)** | La poda pasa a estado `ejecutada`, la evidencia queda almacenada en MinIO, el evento `PodaEjecutada` se publica. |
| **Postcondiciones (fallo)** | No se modifica el estado de la poda; la evidencia no se almacena. |

*Flujo normal:*
1. El Encargado accede al módulo Podas y selecciona la poda asignada.
2. El sistema presenta el formulario con: Fecha de ejecución, Herramientas utilizadas (lista), Reporte fotográfico (file upload), Observaciones.
3. El Encargado completa los campos y carga la fotografía.
4. El sistema valida que `fechaEjecutada >= fechaPlanificada` (RN-BIZ-004).
5. El sistema valida que haya al menos una herramienta registrada y una fotografía cargada (RN-BIZ-005).
6. El sistema persiste la poda, almacena la imagen en MinIO y publica `PodaEjecutada`.
7. El sistema notifica al Administrador y, si la poda viene de una PQR, al Ciudadano.
8. El sistema muestra mensaje de éxito.

*Flujo alterno A1 — Fecha de ejecución anterior a la planificación:* El sistema rechaza y solicita corrección.

*Flujo excepcional E1 — Fallo al almacenar imagen en MinIO:* El sistema revierte la transacción de la poda completa (RNF-003) y notifica al Encargado.

**CU-PQR-001 — Registrar PQR Ciudadana**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-PQR-001 |
| **Nombre** | Registrar PQR Ciudadana |
| **Descripción** | El Ciudadano registra una solicitud sobre el estado de un árbol del espacio público. |
| **Actores** | Ciudadano (principal) |
| **Referencias cruzadas** | RF-014, RU-008, RN-BIZ-006, RN-BIZ-007 |
| **Precondiciones** | El Ciudadano está autenticado. |
| **Postcondiciones (éxito)** | La PQR queda registrada en estado `radicada`, con plazo legal asignado según riesgo. Se notifica al Administrador. |

*Flujo normal:*
1. El Ciudadano accede al módulo PQR y selecciona "Nueva PQR".
2. El sistema presenta formulario con: descripción, fotografía, ubicación en mapa (clic para seleccionar), nivel de riesgo percibido.
3. El Ciudadano completa los campos.
4. El sistema valida la no existencia de una PQR activa del mismo ciudadano sobre el mismo árbol en las últimas 24 horas (RN-BIZ-007).
5. El sistema calcula el plazo legal según el riesgo (RN-BIZ-006).
6. El sistema persiste la PQR, almacena la imagen en MinIO y publica `PQRCreada`.
7. El sistema notifica al Administrador y muestra mensaje de éxito al Ciudadano con el número de radicado.

*Flujo alterno A1 — PQR duplicada en ventana de 24h:* El sistema muestra mensaje con el número de la PQR previa y permite consultar su estado.

##### 10.1.6.4 Especificación Detallada — Módulo PQR

**CU-12 — Registrar PQR**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-12 |
| **Nombre** | Registrar PQR |
| **Descripción** | Permite a los ciudadanos registrar solicitudes de poda (Peticiones, Quejas o Reclamos) en el espacio público, adjuntando evidencias fotográficas y descripción del problema para su posterior atención por parte de las cuadrillas municipales. |
| **Actores** | Ciudadano (principal) |
| **Referencias cruzadas** | RF-014, RF-015, RU-008, RN-BIZ-006, RN-BIZ-007 |
| **Precondiciones** | El Ciudadano debe tener un usuario registrado en el sistema con rol Ciudadano. |
| **Postcondiciones (éxito)** | PQR registrada con estado "Registrada" y número de radicado asignado. |
| **Postcondiciones (fallo)** | No se persiste ningún cambio; se muestra mensaje descriptivo del error. |

*Flujo básico:* (1) El ciudadano selecciona "Nueva Solicitud de PQR". (2) El sistema muestra el formulario con tipo de solicitud, nivel de riesgo, sector afectado, fotografías y observaciones. (3) El ciudadano selecciona el tipo (Petición/Queja/Reclamo) y el nivel de riesgo (Bajo/Medio/Alto). (4) El ciudadano selecciona el sector afectado. (5) El ciudadano adjunta fotografías (mín. 1, máx. 5, 4 MB c/u). (6) El ciudadano escribe la descripción detallada. (7) El ciudadano oprime "Registrar PQR". (8) El sistema valida campos obligatorios. (9) El sistema valida tamaño de fotografías. (10) El sistema asigna número de radicado único. (11) El sistema registra fecha, hora y ciudadano. (12) El sistema calcula plazo legal según riesgo (RN-BIZ-006). (13) El sistema guarda la PQR con estado "Registrada". (14) El sistema muestra confirmación con el número de radicado. (15) El sistema envía correo al ciudadano con el radicado. (16) Fin.

*Flujos alternos:*
- **FA-04 Ubicar sector en mapa:** El ciudadano marca el punto en el mapa interactivo → el sistema identifica el sector → continúa en el paso 5.
- **FA-05 Sin fotografías:** El ciudadano selecciona "No tengo fotografías" → el sistema solicita justificación escrita (mín. 20 caracteres) → continúa sin fotografías.
- **FA-08 Cancelar operación:** El ciudadano oprime "Cancelar" → confirma → el sistema descarta los datos y regresa al paso 1.
- **FA-09 Validación de campos obligatorios:** El sistema detecta campos vacíos → resalta en rojo → regresa al paso 3.
- **FA-10 Validación de tamaño/formato:** El sistema detecta archivos >4 MB o formato inválido (solo JPG/PNG/JPEG) → elimina el archivo → regresa al paso 5.

> **📷 Diagrama de actividades — CU-12 Registrar PQR**  
> **Archivo:** `./images/tp-cu-12-actividades.png`  
> **Descripción esperada:** Diagrama UML de actividades que represente los pasos del flujo básico de registro de PQR, incluyendo los puntos de decisión de los flujos alternos.

![Diagrama de actividades CU-12](./images/tp-cu-12-actividades.png)

> **📷 Diagrama de estados — PQR**  
> **Archivo:** `./images/tp-cu-12-estados.png`  
> **Descripción esperada:** Diagrama UML de estados de la PQR mostrando las transiciones: `[inicio] → Registrada → En Proceso → Cerrada` y la rama `Registrada → Rechazada`.

![Diagrama de estados PQR](./images/tp-cu-12-estados.png)

**CU-13 — Consultar Estado de PQR**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-13 |
| **Nombre** | Consultar Estado de PQR |
| **Descripción** | Permite consultar el estado actual, el historial de seguimiento y las evidencias de atención de las PQR registradas. |
| **Actores** | Ciudadano (principal), Encargado de Cuadrilla (secundario) |
| **Referencias cruzadas** | RF-017, RU-009, RI-003 |
| **Precondiciones** | El usuario está registrado como Ciudadano o Encargado, y existen PQR en el sistema. |
| **Postcondiciones (éxito)** | Se visualiza la información actualizada con su historial completo. |

*Flujo básico:* El usuario selecciona "Consultar PQR" → busca por número de radicado o "Mis PQR" → el sistema valida y recupera la información → muestra lista con ID, fecha, tipo, estado y sector → el usuario selecciona una PQR → el sistema muestra detalle completo (radicado, datos de registro, descripción, fotografías, estado actual e historial con fechas y responsables) → el sistema verifica si tiene poda asociada → fin.

*Flujos alternos clave:* "Mis PQR" para el ciudadano autenticado · Filtros avanzados para el encargado (estado, sector, fechas, riesgo) · Exportar lista a Excel · Ampliar fotografías a pantalla completa · Ver poda programada o ejecutada asociada con descarga de reporte PDF.

> **📷 Diagrama de actividades — CU-13 Consultar Estado**  
> **Archivo:** `./images/tp-cu-13-actividades.png`

![Diagrama de actividades CU-13](./images/tp-cu-13-actividades.png)

**CU-14 — Actualizar Estado de PQR**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-14 |
| **Nombre** | Actualizar Estado de PQR |
| **Descripción** | Actualiza automáticamente el estado de una PQR cuando se programa una poda correctiva asociada o cuando se ejecuta dicha poda. |
| **Actores** | Encargado de Cuadrilla (principal) |
| **Referencias cruzadas** | RF-016, RN-BIZ-010, RI-003 |
| **Precondiciones** | El usuario está registrado como Encargado y existe una PQR en estado "Abierta" o "En Ejecución". |
| **Postcondiciones (éxito)** | Estado actualizado a "En Proceso" o "Cerrada" según la acción. |

*Flujo básico:* El encargado selecciona "Actualizar el estado" → el sistema muestra la lista de PQR con estado actual → el encargado selecciona la PQR → el sistema recibe la confirmación (poda programada o cerrada) → recupera el ID de la PQR → determina el nuevo estado → actualiza el estado → registra en historial (fecha/hora, usuario, estado anterior y nuevo) → vincula con la acción (ID de poda) → muestra confirmación → fin.

*Flujos alternos clave:* Actualizar a "En Proceso" cuando se programa una poda correctiva · Actualizar a "Cerrada" cuando la poda se marca ejecutada · Validación de transiciones inválidas con mensaje descriptivo.

> **📷 Diagrama de actividades — CU-14 Actualizar Estado**  
> **Archivo:** `./images/tp-cu-14-actividades.png`

![Diagrama de actividades CU-14](./images/tp-cu-14-actividades.png)

##### 10.1.6.5 Especificación Detallada — Módulo Reportes

**CU-15 — Generar Reportes**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-15 |
| **Nombre** | Generar Reportes |
| **Descripción** | Permite generar reportes personalizados aplicando filtros específicos por sectores, podas ejecutadas y podas programadas, con exportación en PDF, Excel o CSV. |
| **Actores** | Administrador (principal) |
| **Referencias cruzadas** | RF-018, RF-019, RU-003, RI-004 |
| **Precondiciones** | El usuario está registrado como Administrador. |
| **Postcondiciones (éxito)** | Reporte generado y exportado en el formato seleccionado. |

*Flujo básico:* El administrador selecciona "Generar Reportes" → elige tipo (Podas Ejecutadas / Programadas / Por Sectores) → define filtros → presiona "Generar Vista Previa" → el sistema consulta la BD y valida datos → muestra resumen estadístico, gráficos y tabla → el administrador selecciona formato (PDF/Excel/CSV) → presiona "Exportar" → el sistema genera y descarga → confirmación → fin.

*Flujos alternos clave:* Cargar plantilla guardada · Guardar configuración como plantilla · Sin datos que coincidan (permite modificar filtros) · Excel con o sin gráficos · Enviar por email a destinatarios (con validación de formato).

> **📷 Diagrama de actividades — CU-15 Generar Reportes**  
> **Archivo:** `./images/tp-cu-15-actividades.png`

![Diagrama de actividades CU-15](./images/tp-cu-15-actividades.png)

**CU-16 — Visualizar Dashboard**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-16 |
| **Nombre** | Visualizar Dashboard |
| **Descripción** | Muestra en tiempo real los indicadores clave de gestión del sistema mediante un dashboard interactivo. |
| **Actores** | Administrador (principal), Encargado de Cuadrilla (secundario) |
| **Referencias cruzadas** | RF-018, RU-004, RU-007 |
| **Precondiciones** | El usuario está registrado como Administrador o Encargado, y existen datos en el sistema. |
| **Postcondiciones (éxito)** | Dashboard visualizado con indicadores actualizados según el período. |

*Flujos clave:* Cambiar período (Día/Semana/Mes/Año/Personalizado) · Período personalizado con validación de fechas · Ver detalles de indicador en ventana emergente · Personalizar dashboard (mín. 4, máx. 10 indicadores, solo Administrador) · Cambiar tipo de gráfico (Barras/Líneas/Pastel) · Actualización automática cada 5 minutos · Generar reporte completo desde el dashboard · Configurar informes automáticos.

> **📷 Diagrama de actividades — CU-16 Visualizar Dashboard**  
> **Archivo:** `./images/tp-cu-16-actividades.png`

![Diagrama de actividades CU-16](./images/tp-cu-16-actividades.png)

**CU-17 — Configurar Informes Automáticos**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-17 |
| **Nombre** | Configurar Informes Automáticos |
| **Descripción** | Permite configurar la generación y envío automático de informes ejecutivos de manera periódica (diaria, semanal, mensual, trimestral) a destinatarios específicos. |
| **Actores** | Administrador (principal) |
| **Referencias cruzadas** | RF-020, RU-003 |
| **Precondiciones** | El usuario está registrado como Administrador y existe al menos una plantilla de informe. |
| **Postcondiciones (éxito)** | Configuración guardada, activada y programada en el planificador de tareas. |

*Flujo básico:* "Configurar Informes Automáticos" → "Nueva Configuración" → nombre descriptivo → periodicidad (Diaria/Semanal/Mensual/Trimestral) → día y hora → plantilla → formato (PDF/Excel) → "Agregar Destinatarios" → emails clasificados por categoría (Directivos/Jefes de Área/Entes de Control) → validación de formato → personalizar asunto y cuerpo del correo (variables `{fecha}`, `{periodo}`, `{nombre_destinatario}`, `{nombre_informe}`) → "Guardar y Activar" → validación de campos obligatorios → guarda y activa en planificador → confirmación con resumen → fin.

*Flujos alternos clave:* Configuración semanal/mensual/trimestral con campos específicos · Previsualizar informe con datos actuales · Importar destinatarios desde Excel · Validación de emails duplicados/inválidos · Guardar como inactivo · Activar/Desactivar configuración existente.

> **📷 Diagrama de actividades — CU-17 Configurar Informes**  
> **Archivo:** `./images/tp-cu-17-actividades.png`

![Diagrama de actividades CU-17](./images/tp-cu-17-actividades.png)

**CU-18 — Consultar Historial de Envíos**

| Campo | Detalle |
|---|---|
| **Identificador** | CU-18 |
| **Nombre** | Consultar Historial de Envíos |
| **Descripción** | Permite consultar el registro histórico completo de los informes ejecutivos enviados automáticamente, con posibilidad de reenvío o descarga de copias. |
| **Actores** | Administrador (principal) |
| **Referencias cruzadas** | RF-020, RU-003, RI-004 |
| **Precondiciones** | El usuario está registrado como Administrador y existen informes enviados. |
| **Postcondiciones (éxito)** | Se visualiza el historial según los filtros aplicados, con opción de reenvío o descarga. |

*Flujo básico:* "Historial de Informes Enviados" → el sistema consulta la BD y muestra lista por fecha descendente con fecha/hora, nombre, destinatarios, formato, estado (Exitoso/Parcial/Fallido) e indicador visual → filtros (rango de fechas, nombre, formato, estado) → seleccionar un registro → detalle completo con destinatarios y estado individual, errores y opciones de descargar o reenviar → descarga del archivo desde almacenamiento → fin.

*Flujos alternos clave:* Sin historial (sugiere "Configurar Informe") · Paginación de 50 en 50 · Reenviar a destinatarios fallidos o a nuevos · Error al descargar (ofrece regenerar vía CU-15) · Exportar historial completo a Excel · Marcar como revisado.

> **📷 Diagrama de actividades — CU-18 Historial de Envíos**  
> **Archivo:** `./images/tp-cu-18-actividades.png`

![Diagrama de actividades CU-18](./images/tp-cu-18-actividades.png)

<a id="sec-10-2"></a>
### 10.2 Incepción Ágil

La Incepción Ágil es un taller de descubrimiento que permite alinear al equipo y al cliente sobre los aspectos esenciales del producto antes de iniciar la construcción. Para Tree Pruning se aplicó el formato de Caroli "Direto ao Ponto", que combina elementos de Lean Inception y Design Thinking.

<a id="sec-10-2-1"></a>
#### 10.2.1 Por Qué Estamos Aquí

Estamos aquí porque el municipio de Rionegro no cuenta con un sistema digital que permita gestionar de forma centralizada, trazable y georreferenciada el arbolado urbano. La gestión manual en Excel genera inconsistencias, impide la toma de decisiones preventivas y expone al municipio a responsabilidades legales por accidentes relacionados con árboles en mal estado.

Tree Pruning elimina el papel del proceso, georreferencia cada árbol del espacio público, permite programar podas preventivas, gestionar cuadrillas y atender PQR ciudadanas dentro de los plazos legales.

<a id="sec-10-2-2"></a>
#### 10.2.2 Visión / Elevator Pitch

##### 10.2.2.1 Visión

*Para la Administración municipal de Rionegro y empresas de servicios que necesitan optimizar la planificación y ejecución de podas en el espacio público, enfrentando actualmente falta de control, Tree Pruning es un aplicativo web que previene accidentes por caída de árboles sobre personas, vehículos e infraestructura, eliminando la exposición legal del municipio. A diferencia de procesos manuales en Excel y Word, soluciones del mercado como TreePlotter CANOPY y ArboMap, así como herramientas generales, nuestro producto ofrece gestión integral enfocada en el inventario de árboles, planificación de podas, PQR ciudadanas y cuadrillas de poda para Rionegro.*

##### 10.2.2.2 Project Canvas

El Project Canvas resume en una sola vista los componentes esenciales del proyecto.

| Bloque | Contenido |
|---|---|
| **Nombre del producto** | Tree Pruning |
| **Justificación** | Prevenir accidentes por caída de árboles, cumplir la normativa ambiental y de PQR, eliminar la gestión manual en Excel y Word. |
| **Visión** | (Ver visión arriba) |
| **Objetivos SMART** | (1) Inventariar el 100% de árboles de tres sectores piloto en 6 meses. (2) Reducir el tiempo de respuesta de PQR de 30 a 15 días hábiles. (3) Disminuir un 50% los reportes de árboles caídos al cabo de un año. |
| **Beneficios cualitativos** | Mejor imagen institucional, ciudadanía informada y atendida, gestión basada en datos, trazabilidad ante entes de control. |
| **Beneficios cuantitativos** | Reducción de horas-hombre en gestión manual (estimado 80 h/mes liberadas), disminución de demandas por daños (estimado COP 30M/año evitados). |
| **Producto / Entregables** | Aplicativo web responsive, módulos de Administración, Inventario, Podas, PQR y Reportes, documentación de usuario, manual de despliegue. |
| **Stakeholders** | Alcaldía de Rionegro, Secretaría del Medio Ambiente, Empresa de Servicios Públicos, Ciudadanía, Equipo de desarrollo UCO. |
| **Equipo** | Equipo de estudiantes de Software 2 — UCO. Roles: Product Owner académico, Scrum Master, 4 desarrolladores full-stack, 1 arquitecto. |
| **Premisas** | Disponibilidad de coordenadas GPS de árboles vía dispositivos institucionales; conectividad estable de cuadrillas en campo. |
| **Restricciones** | Presupuesto cero (open source), 1 VM Azure compartida, horario laboral 6 AM – 6 PM, 1 semestre de desarrollo. |
| **Riesgos** | Cambio de stack durante el desarrollo, rotación del equipo, indisponibilidad de la VM, expiración del token de Infisical. |
| **Hitos** | (M1) Backend autenticación + inventario mínimo. (M2) Módulo Podas + Mapa. (M3) Módulo PQR + Notificaciones. (M4) Reportes + DevOps. |
| **Costo** | Operativo: USD 0/mes (capa gratuita). Recursos humanos: estimado en sección 10.2.10. |

<a id="sec-10-2-3"></a>
#### 10.2.3 Mapa de Impacto

**Objetivo:** Digitalizar y centralizar la gestión del arbolado urbano de Rionegro para prevenir accidentes, cumplir normativa y mejorar la atención ciudadana.

**Actores e Impactos:**

| Actor | Impacto | Módulos / Entregables |
|---|---|---|
| **Administrador del sistema** | Reducir riesgos de seguridad y pérdida de información mediante control centralizado y seguro del sistema | Creación de usuarios, Asignación de roles, Inicio de sesión seguro, Trazabilidad de acciones → **Módulo: Administración** |
| **Administrador del sistema** | Contar con información territorial organizada y georreferenciada que facilite la planificación | Definición de sectores, Inventario de árboles con atributos, Georreferenciación GPS, Visualización en mapa → **Módulo: Inventario** |
| **Administrador del sistema** | Monitorear, analizar y comunicar la gestión de podas en tiempo real | Dashboard de indicadores, Plantillas de informes, Reportes filtrados, Exportación, Envío automático → **Módulo: Reportes** |
| **Encargado de Cuadrilla** | Optimizar la organización del trabajo en campo y reducir reprocesos | Planificación preventiva, Asignación de fechas/cuadrillas, Podas correctivas por PQR, Notificaciones → **Módulo: Podas** |
| **Encargado de Cuadrilla** | Facilitar el registro y evidenciar la ejecución de podas en campo | Marcar poda ejecutada, Registrar cuadrilla/herramientas, Subir evidencia fotográfica → **Módulo: Podas** |
| **Ciudadano** | Recibir atención rápida y transparente en sus solicitudes con seguimiento claro | Registro de PQR, Seguimiento de estado (realizado/en proceso/cerrado), Notificaciones push → **Módulo: PQR** |

<a id="sec-10-2-4"></a>
#### 10.2.4 Caja de Producto

La Caja de Producto es un ejercicio de síntesis que obliga al equipo a expresar la propuesta de valor como si fuera una caja real en el supermercado, con los argumentos de venta más fuertes y las características clave.

**Cara frontal:**

> **Tree Pruning** — *"Cuidamos los árboles que nos cuidan"*
> 
> El sistema integral para que tu municipio gestione su arbolado urbano de forma segura, trazable y conforme a la ley.

**Razones para comprarlo (3 principales):**

1. **Previene accidentes y demandas** — Mantén un inventario georreferenciado y un plan de podas preventivas auditable que evita la responsabilidad legal del municipio.
2. **Atiende al ciudadano dentro del plazo legal** — Las PQR se gestionan con los plazos de la Ley 1755 calculados automáticamente según el riesgo.
3. **Costo operativo cero** — 100% software libre, sin licencias mensuales ni cargos por usuario.

**Características destacadas (cara lateral):**

- Mapa georreferenciado con Google Maps Platform
- Notificaciones push automáticas a ciudadanos y cuadrillas
- Reportes filtrados exportables en PDF y Excel
- Autenticación corporativa SSO con Microsoft Entra ID
- Trazabilidad completa de todas las acciones
- Disponibilidad 99.5% en horario laboral

> **📷 Imagen requerida — Caja de Producto**  
> **Archivo:** `./images/tp-product-box.png`  
> **Descripción esperada:** Render visual (estilo packaging) de la caja del producto Tree Pruning con el slogan "Cuidamos los árboles que nos cuidan", logo, las tres razones para comprarlo en la cara frontal y las características destacadas en una cara lateral.

![Caja de Producto](./images/tp-product-box.png)

<a id="sec-10-2-5"></a>
#### 10.2.5 Lo Que Sí, Lo Que No

Este ejercicio delimita el alcance del producto separando lo que sí está incluido en la primera entrega de lo que explícitamente no lo está, para evitar expectativas mal alineadas.

| Lo que SÍ es Tree Pruning | Lo que NO es Tree Pruning |
|---|---|
| Sistema web para gestionar el inventario, las podas y las PQR del arbolado urbano | Sistema de gestión integral del medio ambiente del municipio |
| Aplicativo responsive accesible desde navegador en computador y móvil | App móvil nativa Android/iOS |
| Gestión de podas preventivas y correctivas | Gestión de tala, trasplante o siembra de árboles (fuera de alcance v1) |
| Atención de PQR sobre arbolado urbano según Ley 1755 | Atención de PQR generales del municipio (fuera de alcance) |
| Reportes operativos del arbolado | Sistema BI con dashboards analíticos avanzados |
| Notificaciones push vía FCM | Notificaciones SMS o llamadas telefónicas |
| Integración con Google Maps Platform | Sistema GIS completo tipo ArcGIS |
| Catálogos de familias botánicas básicos | Sistema de identificación automática de especies por imagen |
| Autenticación corporativa y ciudadana | Sistema de gestión de identidades del municipio (lo delega en Keycloak/Entra ID) |

##### 10.2.5.1 Mapa de Historias de Usuario

El mapa de historias de usuario organiza el backlog en una vista bidimensional: en horizontal, las actividades del usuario en el flujo del producto; en vertical, las historias específicas priorizadas por release. Cada columna representa un paso del journey del usuario y cada fila un release del producto.

**Estructura del mapa (resumen):**

| Actividad | Release 1 (MVP) | Release 2 | Release 3 |
|---|---|---|---|
| **Acceder al sistema** | HU-AUT-01: Iniciar sesión con cuenta institucional | HU-AUT-02: SSO con Entra ID | HU-AUT-03: Recuperar contraseña |
| **Administrar usuarios** | HU-ADM-01: Crear usuario, HU-ADM-02: Asignar rol | HU-ADM-03: Desactivar usuario | HU-ADM-04: Auditoría de accesos |
| **Gestionar inventario** | HU-INV-01: Registrar árbol, HU-INV-02: Ver mapa, HU-INV-03: Definir sector | HU-INV-04: Modificar árbol, HU-INV-05: Configurar programación | HU-INV-06: Historial de árbol |
| **Programar podas** | HU-POD-01: Generar podas anuales, HU-POD-02: Asignar cuadrilla | HU-POD-03: Programar correctiva, HU-POD-04: Calendario de podas | HU-POD-05: Reasignar poda |
| **Ejecutar podas** | HU-POD-06: Marcar ejecutada con evidencia | HU-POD-07: Registrar herramientas usadas | HU-POD-08: Firma digital del encargado |
| **Gestionar PQR** | HU-PQR-01: Registrar PQR, HU-PQR-02: Consultar estado | HU-PQR-03: Asignar PQR, HU-PQR-04: Cerrar PQR | HU-PQR-05: Calificar atención |
| **Reportar** | HU-REP-01: Reporte por sector | HU-REP-02: Exportar PDF/Excel | HU-REP-03: Envío automático programado |
| **Monitorear** | HU-MON-01: Dashboard básico | HU-MON-02: Alertas por umbral | HU-MON-03: Vistas geoanalíticas |

> **📷 Imagen requerida — Mapa de Historias de Usuario**  
> **Archivo:** `./images/tp-user-story-map.png`  
> **Descripción esperada:** Mapa de historias de usuario visual (estilo post-its en pared) con las actividades en horizontal (Acceder, Administrar usuarios, Gestionar inventario, Programar podas, Ejecutar podas, Gestionar PQR, Reportar, Monitorear) y las historias agrupadas verticalmente por release (R1 MVP, R2, R3). Cada historia como tarjeta con su código (HU-...).

![Mapa de Historias de Usuario](./images/tp-user-story-map.png)

##### 10.2.5.2 Product Backlog Item (PBI)

Cada Product Backlog Item se documenta con título, descripción ("Como… quiero… para…"), criterios de aceptación, prioridad MoSCoW y tallaje.

**Ejemplo de PBI representativos:**

| Código | Título | Descripción | Criterios de aceptación clave | Prioridad | Talla |
|---|---|---|---|---|---|
| HU-INV-01 | Registrar árbol | Como Administrador quiero registrar un árbol con sus atributos para mantener el inventario actualizado | Coordenadas validadas; árbol visible en mapa; evento publicado | Must | M |
| HU-POD-01 | Generar podas anuales | Como Encargado quiero generar las podas preventivas anuales de un árbol para no tener que programarlas una por una | Operación atómica; rollback ante fallo | Must | L |
| HU-POD-06 | Marcar poda ejecutada con evidencia | Como Encargado quiero registrar la ejecución con fotos para evidenciar el trabajo realizado | Imagen subida a MinIO; herramientas registradas; fecha válida | Must | M |
| HU-PQR-01 | Registrar PQR | Como Ciudadano quiero radicar una solicitud sobre un árbol para que el municipio lo atienda | Plazo legal calculado; notificación al Admin; número de radicado visible | Must | M |
| HU-REP-01 | Reporte por sector | Como Administrador quiero generar un reporte por sector para presentar a la Secretaría | Filtros aplicables; exportable PDF | Must | S |

<a id="sec-10-2-6"></a>
#### 10.2.6 La Comunidad

La comunidad del proyecto está integrada por todos los grupos cuyo apoyo, decisiones o uso impactan el éxito del producto.

| Grupo | Rol en el proyecto |
|---|---|
| **Equipo de desarrollo (UCO)** | Construye, prueba y mantiene el sistema. Compuesto por estudiantes del curso Software 2. |
| **Cuerpo docente UCO** | Acompaña el proceso académico, valida arquitectura y prácticas de ingeniería. |
| **Administración municipal de Rionegro** | Stakeholder principal. Toma decisiones de adopción y prioriza funcionalidades. |
| **Secretaría del Medio Ambiente** | Usuario administrador y validador funcional. |
| **Cuadrillas de poda** | Usuario operativo. Su feedback determina la usabilidad del módulo de Podas. |
| **Ciudadanía de Rionegro** | Usuario final del módulo de PQR. |
| **Comunidad open source** | Proveedora indirecta del stack (Spring, Vue, PostgreSQL, Keycloak, etc.). |

<a id="sec-10-2-7"></a>
#### 10.2.7 La Solución

La solución de Tree Pruning se materializa en un aplicativo web modular que opera sobre infraestructura en la nube (Azure VM) y se integra con servicios SaaS gratuitos para cubrir funciones transversales (identidad, secretos, notificaciones, mapas). El modelo de contexto de la solución se presenta detalladamente en la sección 5 (Modelo de Contexto) y la arquitectura en la sección 7 (Arquitectura de Solución).

<a id="sec-10-2-8"></a>
#### 10.2.8 Los Riesgos / Los Miedos

Los riesgos y miedos del equipo deben ser explícitos para que puedan mitigarse. Para Tree Pruning se identificaron:

| Código | Riesgo / Miedo | Probabilidad | Impacto | Mitigación |
|---|---|---|---|---|
| **R-001** | Indisponibilidad de la VM Azure por agotamiento de créditos estudiantiles | Media | Alto | Monitoreo de saldo, plan B de migración a otro proveedor con capa gratuita |
| **R-002** | Expiración del token de Infisical sin renovación | Alta | Alto | Servicio systemd de auto-renovación, alertas vía Grafana |
| **R-003** | Java 26 dejará de tener soporte en septiembre de 2026 | Alta | Medio | Plan de actualización a Java 27 LTS antes del fin de soporte |
| **R-004** | Rotación de integrantes del equipo en el semestre siguiente | Alta | Medio | Documentación exhaustiva, INSTALL.md, README por módulo, pair programming |
| **R-005** | El municipio no adopte el sistema al cierre del proyecto | Media | Alto | Demo periódica al cliente, pilotos en sectores, capacitación documentada |
| **R-006** | Cambios regulatorios en plazos de PQR (Ley 1755) | Baja | Medio | Plazos configurables en Parameter Catalog sin redespliegue |
| **R-007** | Fuga de información personal de ciudadanos | Baja | Alto | RBAC estricto, HTTPS obligatorio, auditoría de accesos a datos personales |
| **R-008** | Saturación de la VM por número de contenedores | Media | Medio | Límites de memoria por contenedor, monitoreo en Grafana, plan de escalado |

<a id="sec-10-2-9"></a>
#### 10.2.9 Tamaño / Talla de Historias de Usuario

##### 10.2.9.1 Tallaje del Producto

###### Definiciones para el Tallaje

El tallaje se realiza usando una escala de camisetas (XS, S, M, L, XL) inspirada en la complejidad relativa entre historias. Las definiciones son:

- **XS:** Cambio trivial; menos de 4 horas-hombre. Ejemplo: ajuste de etiqueta o validación simple en formulario.
- **S:** Cambio menor; 4–16 horas-hombre. Ejemplo: nuevo endpoint REST sobre una entidad ya modelada.
- **M:** Funcionalidad estándar; 16–32 horas-hombre. Ejemplo: nuevo CRUD completo con tabla, formulario y validaciones.
- **L:** Funcionalidad compleja; 32–64 horas-hombre. Ejemplo: generación de podas anuales con lógica transaccional y atomicidad.
- **XL:** Funcionalidad épica que debería partirse; >64 horas-hombre. Ejemplo: módulo completo de reportes con planificador y envío programado.

###### Tallaje del Producto

| Módulo | XS | S | M | L | XL | Total HU |
|---|---|---|---|---|---|---|
| Administración | 1 | 3 | 4 | 1 | 0 | 9 |
| Inventario | 2 | 2 | 5 | 2 | 0 | 11 |
| Podas | 0 | 2 | 6 | 3 | 1 | 12 |
| PQR | 1 | 3 | 4 | 1 | 0 | 9 |
| Reportes | 0 | 2 | 3 | 1 | 1 | 7 |
| Transversal (Auth/Mon) | 1 | 4 | 3 | 1 | 0 | 9 |
| **Total** | **5** | **16** | **25** | **9** | **2** | **57** |

##### 10.2.9.2 Release Plan

###### Definiciones para el Release Plan

- **Tamaño del equipo:** 5 desarrolladores + 1 arquitecto + 1 product owner académico = 7 personas.
- **Duración del sprint:** 2 semanas.
- **Capacidad por sprint:** 5 desarrolladores × 32 horas efectivas/semana × 2 semanas = 320 horas/sprint.
- **Velocity estimada inicial:** 240 horas/sprint (75% de capacidad, ajustando por reuniones, code review y estabilización).

###### Release Plan

| Release | Sprints | Contenido principal | Horas estimadas | Fecha objetivo |
|---|---|---|---|---|
| **R1 — MVP** | Sprints 1-3 | Autenticación, Administración básica, Inventario mínimo (registrar árbol, ver mapa), Persistencia, CI/CD | 720 h | Semana 6 |
| **R2 — Operación** | Sprints 4-6 | Podas (programación, asignación, ejecución), Calendario, Notificaciones FCM | 720 h | Semana 12 |
| **R3 — Ciudadano** | Sprints 7-8 | Módulo PQR completo, Notificaciones a ciudadanos, Cierre de PQR | 480 h | Semana 16 |
| **R4 — Reportería** | Sprints 9-10 | Reportes filtrados, Exportación, Envío programado, Dashboards Grafana | 480 h | Semana 20 |

<a id="sec-10-2-10"></a>
#### 10.2.10 Trade-off de Atributos de Calidad

El trade-off entre atributos de calidad explicita los conflictos inherentes entre atributos priorizados y la decisión arquitectónica que se tomó frente a cada conflicto. No todos los atributos pueden maximizarse simultáneamente; se debe negociar entre ellos.

| Atributo A | Atributo B | Conflicto | Decisión adoptada |
|---|---|---|---|
| **Seguridad** | **Usabilidad** | El bloqueo de cuenta tras 5 intentos fallidos protege contra fuerza bruta pero puede bloquear a un usuario legítimo que olvidó su clave | Se prioriza Seguridad: bloqueo de 5 minutos automático con notificación al Administrador, quien puede desbloquear inmediatamente. Hay flujo de "olvidé contraseña" disponible antes del bloqueo. |
| **Rendimiento** | **Confiabilidad** | Las transacciones ACID en la generación de podas anuales añaden latencia, pero la operación atómica es necesaria para no dejar registros parciales | Se prioriza Confiabilidad: operación transaccional con feedback explícito al usuario sobre el progreso (≤ 8 s aceptable para esta operación específica). |
| **Disponibilidad** | **Costo** | Alta disponibilidad requeriría múltiples VMs y load balancer; el costo cero solo permite una VM | Se prioriza Costo: una VM con auto-restart de contenedores y monitoreo. Se acepta el SPOF a nivel de VM. La disponibilidad 99.5% se mide solo en horario laboral. |
| **Escalabilidad** | **Costo** | El escalado horizontal requiere infraestructura adicional | Se prioriza Costo: la VM Standard_B4ms (4 vCPU, 16 GB) cubre la carga proyectada de Rionegro. El escalado vertical es el plan B. |
| **Seguridad** | **Rendimiento** | La validación del JWT en cada petición añade latencia | Se prioriza Seguridad: validación obligatoria con caché de claves públicas de Keycloak para reducir overhead. |
| **Confiabilidad** | **Rendimiento** | El flush inmediato a disco garantiza durabilidad pero reduce throughput | Se prioriza Confiabilidad: PostgreSQL con `synchronous_commit=on` por defecto. |
| **Trazabilidad** | **Rendimiento** | El registro de auditoría en cada operación añade I/O | Compromiso: publicación asíncrona del evento de auditoría con Spring Events, persistencia en background sin bloquear la respuesta al usuario. |
| **Usabilidad** | **Seguridad** | El JWT debería expirar pronto por seguridad, pero la sesión corta degrada UX | Compromiso: JWT con vida de 15 minutos + refresh token con vida de 8 horas (jornada laboral). |

<a id="sec-10-2-11"></a>
#### 10.2.11 Cuánto Cuesta

##### 10.2.11.1 Definiciones para el Coste

- **Valor hora del estudiante de pregrado:** COP 25.000/h (referencia académica de práctica universitaria).
- **Valor hora del arquitecto / docente acompañante:** COP 80.000/h.
- **Costo de infraestructura:** USD 0/mes (Azure VM con crédito estudiantil + servicios SaaS en capa gratuita).
- **Duración total del proyecto:** 10 sprints × 2 semanas = 20 semanas (5 meses).

##### 10.2.11.2 Coste

| Concepto | Cantidad | Valor unitario | Total |
|---|---|---|---|
| Desarrollo (5 estudiantes × 32 h/sem × 20 sem) | 3.200 h | COP 25.000 | COP 80.000.000 |
| Arquitectura (1 arquitecto × 6 h/sem × 20 sem) | 120 h | COP 80.000 | COP 9.600.000 |
| Product Owner académico (1 docente × 4 h/sem × 20 sem) | 80 h | COP 80.000 | COP 6.400.000 |
| Infraestructura Azure VM Standard_B4ms (crédito estudiantil) | 5 meses | USD 0 | COP 0 |
| Servicios SaaS (Cloudflare, Infisical, FCM, Maps, GHCR) — capa gratuita | 5 meses | USD 0 | COP 0 |
| Dominio `treepruning.org` (renovación anual) | 1 año | USD 12 | COP 50.000 |
| **Costo total estimado del proyecto** | | | **COP 96.050.000** |

Nota: El costo de horas humanas se computa como valor académico de referencia; en términos de desembolso real para el municipio, el costo de adopción del producto al término del proyecto es de **USD 12/año** (renovación del dominio), ya que toda la infraestructura puede migrarse a una VM del municipio sin cambiar el stack.

<a id="sec-10-3"></a>
### 10.3 Vista Lógica

La vista lógica describe la estructura estática del sistema mediante diagramas de clases y objetos, mostrando las entidades del dominio y sus relaciones.

<a id="sec-10-3-1"></a>
#### 10.3.1 Diagrama de Clases — Dominio Principal

El diagrama de clases es la representación gráfica de la estructura estática del sistema mediante clases, sus atributos, operaciones y las relaciones entre ellas (asociación, agregación, composición, herencia y dependencia). Su motivación es comunicar de forma clara el modelo de objetos del sistema —independientemente del lenguaje de programación y de la tecnología de persistencia— para que el equipo pueda razonar sobre el dominio, validar las invariantes de negocio y derivar luego el diseño físico de la base de datos y las entidades JPA. En Tree Pruning, el diagrama de clases es el insumo directo para la capa `domain` del Backend (Clean Architecture) y refleja las 20 entidades caracterizadas en la sección 10.3.2.

Las clases de dominio del esquema `treeprunning_sq` en PostgreSQL reflejan el modelo de objetos del sistema:

```
Country
  ├── id: UUID
  └── name: String

State
  ├── id: UUID
  ├── name: String
  └── country: Country

Municipality
  ├── id: UUID
  ├── name: String
  └── state: State

Sector
  ├── id: UUID
  ├── name: String
  └── municipality: Municipality

Family
  ├── id: UUID
  ├── scientificName: String
  └── commonName: String

Programming
  ├── id: UUID
  ├── initialDate: Date
  ├── frequencyMonths: Integer
  └── amount: Integer

Tree
  ├── id: UUID
  ├── longitude: Decimal(10,6)
  ├── latitude: Decimal(10,6)
  ├── family: Family [0..1]
  ├── sector: Sector [0..1]
  └── programming: Programming [0..1]

Type
  ├── id: UUID
  └── name: String

Risk
  ├── id: UUID
  └── name: String

Status
  ├── id: UUID
  └── name: String

Tool
  ├── id: UUID
  ├── name: String
  └── description: String

Pruning
  ├── id: UUID
  ├── status: Status
  ├── plannedDate: Date
  ├── executedDate: Date
  ├── tree: Tree
  ├── quadrille: Quadrille
  ├── type: Type
  ├── pqr: PQR [0..1]
  ├── photographicReportPath: String
  └── observations: String

PruningTool
  ├── pruning: Pruning
  ├── tool: Tool
  └── quantity: Integer

Document
  ├── id: UUID
  ├── name: String
  └── code: String

Person
  ├── id: UUID
  ├── firstName: String
  ├── surname: String
  ├── document: Document
  ├── documentNumber: String
  ├── email: String
  ├── phone: String
  └── age: Integer

Manager
  ├── id: UUID
  └── person: Person

Quadrille
  ├── id: UUID
  ├── quadrilleName: String
  └── manager: Manager [0..1]

Operator
  ├── id: UUID
  ├── person: Person
  └── quadrille: Quadrille [0..1]

PQR
  ├── id: UUID
  ├── date: Date
  ├── status: Status
  ├── person: Person [0..1]
  ├── sector: Sector [0..1]
  ├── risk: Risk
  └── photographicRecordPath: String
```

> **📷 Diagrama requerido — Diagrama de Clases (UML)**  
> **Archivo:** `./images/tp-class-diagram-uml.png`  
> **Descripción esperada:** Representación UML formal del modelo de clases, con visibilidad de atributos (+/-), tipos de datos, multiplicidades en las asociaciones (1, 0..1, 0..*), composiciones/agregaciones y herencias. Incluir las clases Country, State, Municipality, Sector, Family, Programming, Tree, Type, Risk, Status, Tool, Pruning, PruningTool, Document, Person, Manager, Quadrille, Operator, PQR.

![Diagrama de Clases UML](./images/tp-class-diagram-uml.png)

<a id="sec-10-3-2"></a>
#### 10.3.2 Caracterización Detallada de Objetos de Dominio

Esta subsección amplía el diagrama de clases con la caracterización completa de cada objeto del dominio: atributos (con tipos, longitudes, obligatoriedad, sensibilidad), combinaciones únicas, responsabilidades, políticas aplicadas y muestreos de datos representativos. Estos detalles son el insumo directo para el diseño físico de la base de datos (DDL), las entidades JPA y las validaciones de los DTO. Los objetos se ordenan por su línea de vida: los de menor número son independientes y sirven de base para los de mayor número.

**Catálogo de objetos de dominio y línea de vida:**

| Objeto de Dominio | Descripción | Línea de Vida |
|---|---|---|
| **País** | Representa cada uno de los países en los que se va a prestar el servicio de la poda. | 1 |
| **Tipo** | Representa la clasificación de la poda que se llevará a cabo (Preventivo / Correctivo). | 1 |
| **Herramienta** | Representa el instrumento utilizado para realizar la poda del árbol. | 1 |
| **Familia** | Representa la clasificación botánica de los árboles según su familia científica. | 1 |
| **Documento** | Representa la clasificación de los documentos de identidad. | 1 |
| **Programación** | Representa la planificación de la poda, con fecha inicial y frecuencia en meses. | 1 |
| **Administrador** | Representa a los usuarios que tienen control total sobre la aplicación. | 1 |
| **Riesgo** | Representa una escala cualitativa para medir el impacto de una PQR (Bajo / Medio / Alto). | 1 |
| **Estado** | Representa las condiciones en las que se puede encontrar un elemento del sistema (Abierto / En ejecución / Cerrado). | 1 |
| **Persona** | Representa los individuos que interactúan con el sistema, ya sea ciudadano o empleado relacionado con la gestión de podas. | 2 |
| **Departamento** | Representa el departamento en el que se va a prestar el servicio de la poda. | 2 |
| **Encargado** | Representa al empleado que lidera y supervisa el equipo de trabajo durante la ejecución de las podas en un sector específico. | 3 |
| **Operario** | Representa al empleado que ejecuta directamente las labores de poda y mantenimiento de los árboles utilizando las herramientas asignadas. | 3 |
| **Municipio** | Representa el municipio en el que se va a prestar el servicio de la poda. | 3 |
| **Cuadrilla** | Representa el grupo de empleados asignados a realizar una poda programada en un sector. | 4 |
| **Sector** | Representa los sectores del municipio en los que se va a prestar el servicio de la poda. | 4 |
| **PQR** | Representa las peticiones, quejas o reclamos asociados a un árbol de un sector, que llevan a la realización o no de una poda. | 5 |
| **Árbol** | Representa un árbol específico con información detallada como especie, ubicación y registros de poda. | 5 |
| **Poda** | Representa el registro detallado de una poda realizada, con fotos, herramientas utilizadas y el equipo de empleados involucrados. | 6 |
| **PodaHerramienta** | Representa la relación entre las podas y las herramientas utilizadas en ellas. | 7 |

A continuación se detalla cada objeto de dominio con sus atributos, combinaciones únicas, responsabilidades, políticas aplicadas y muestreos de datos representativos.

---

##### 10.3.2.1 País

**Descripción:** Representa cada uno de los países en los que se va a prestar el servicio de la poda.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Autogenerado | Identifica | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | Sí | Sí | No | Sí | No | No | Identificador único del país; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 2 | 60 | Sí | Sí | No | No | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del país. No se puede repetir. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única | `nombre` | El nombre del país no puede repetirse en el sistema. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Explorar países registrados | Consultar el país registrado en el sistema aplicando filtros. | País-POL-01: Validar datos del filtro (tipo, longitud, obligatoriedad, formato, rango). |
| Listar un país | Consultar un país según su `id`. | País-POL-03: Validar datos requeridos; generar excepción si el país no es encontrado. |

###### Muestreo de datos

| id | nombre |
|---|---|
| 1 | Colombia |

---

##### 10.3.2.2 Tipo

**Descripción:** Representa la clasificación de la poda que se llevará a cabo.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Autogenerado | Identifica | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | Sí | Sí | No | Sí | No | No | Identificador único del tipo; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 3 | 30 | Sí | Sí | No | No | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre asignado al tipo de poda. No se puede repetir. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única | `nombre` | El nombre del tipo de poda no puede repetirse en el sistema. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Consultar todos los tipos de poda | Listar los tipos de poda registrados con filtro opcional. | Tipo-POL-04: Validar datos del filtro. |
| Consultar un tipo de poda | Consultar un tipo según su `id`. | Tipo-POL-03: Validar datos requeridos; excepción si no se encuentra. |

###### Muestreo de datos

| id | nombre |
|---|---|
| 1 | Preventivo |
| 2 | Correctivo |

---

##### 10.3.2.3 Herramienta

**Descripción:** Representa el instrumento utilizado para realizar la poda del árbol.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Valor por defecto | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | — | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 2 | 50 | Sí | Sí | — | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre de la herramienta. No se puede repetir. |
| `descripcion` | Alfanumérico | 10 | 200 | No | Sí | Nulo | Sí | Sí {2} | Sí (ASC/DESC) | Sí | Descripción o uso principal de la herramienta. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única | `nombre` | El nombre de la herramienta no puede repetirse en el sistema. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Incorporar una herramienta | Crear una nueva herramienta en el sistema. | Herramienta-POL-01 (unicidad de id), POL-02 (unicidad de nombre), POL-03 (validación de datos). |
| Listar herramientas disponibles | Listar todas las herramientas con filtro opcional. | Herramienta-POL-04: Validar datos del filtro. |
| Detalle de herramienta | Consultar una herramienta según su `id`. | Herramienta-POL-03: Excepción si no se encuentra. |
| Registrar cambio de herramienta | Actualizar los datos de una herramienta existente. | Herramienta-POL-03: Excepción si no se encuentra. |
| Retirar una herramienta definitivamente | Eliminar una herramienta del sistema. | Herramienta-POL-05 (no puede estar en uso en una poda), POL-03 (excepción si no se encuentra). |

###### Muestreo de datos

| id | nombre | descripcion |
|---|---|---|
| 1 | Pala | Herramienta manual para cavar y mover tierra. |
| 2 | Tijera | Herramienta para cortes en ramas delgadas y hojas. |
| 3 | Pico | Herramienta para remover tierra dura, raíces o preparar el terreno. |
| 4 | Escalera | Estructura portátil para acceder a ramas en altura. |
| 5 | Arnés | Equipo de protección personal para podas en altura. |

---

##### 10.3.2.4 Familia

**Descripción:** Representa la clasificación botánica de los árboles según su familia científica.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombreCientifico` | Alfanumérico | 2 | 100 | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre científico de la familia botánica. No se puede repetir. |
| `nombreComun` | Alfanumérico | 2 | 100 | Sí | Sí | Sí | Sí {2} | Sí (ASC/DESC) | Sí | Nombre común de la familia. No se puede repetir. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única uno | `nombreCientifico` | El nombre científico no puede repetirse en el sistema. |
| Combinación única dos | `nombreComun` | El nombre común no puede repetirse en el sistema. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Incorporar una nueva familia de árboles | Crear la familia botánica de un conjunto de árboles. | Familia-POL-01 (unicidad de id), POL-02 (unicidad de nombreComun), POL-03 (unicidad de nombreCientifico), POL-04 (validación de datos). |
| Visualizar las familias de árboles registradas | Listar todas las familias con filtro opcional. | Familia-POL-05: Validar datos del filtro. |
| Examinar una familia de árboles específica | Consultar una familia según su `id`. | Familia-POL-04: Excepción si no se encuentra. |
| Actualizar la información de una familia existente | Modificar los datos de una familia ya registrada. | Familia-POL-04: Excepción si no se encuentra. |
| Retirar definitivamente una familia de árboles | Eliminar una familia del sistema. | Familia-POL-06 (no puede estar en uso en un árbol), POL-04 (excepción si no se encuentra). |

###### Muestreo de datos

| id | nombreCientifico | nombreComun |
|---|---|---|
| 1 | Araucaria heterophylla | Araucaria |
| 2 | Syzygium paniculata | Eugenia |
| 3 | Archontophoenix cunninghamiana | Palma payanesa |
| 4 | Inga sp | Inga |
| 5 | Handroanthus chrysanthus | Guayacán amarillo |
| 6 | Prunus serotine | Cerezo |
| 7 | Citrus spp | Cítrico |
| 8 | Persea americana | Aguacate |
| 9 | Acca sellowiana | Guayaba feijoa |
| 10 | Yucca gigantea | Palma yuca |

---

##### 10.3.2.5 Documento

**Descripción:** Representa la clasificación de los documentos de identidad aceptados en el sistema.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 2 | 60 | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del tipo de documento. No se puede repetir. |
| `codigo` | Alfanumérico | 2 | 10 | Sí | Sí | Sí | Sí {2} | Sí (ASC/DESC) | Sí | Código abreviado del tipo de documento. No se puede repetir. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única uno | `nombre` | El nombre del tipo de documento no puede repetirse. |
| Combinación única dos | `codigo` | El código del documento no puede repetirse. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Visualizar todos los documentos registrados | Listar los documentos disponibles con filtro opcional. | Documento-POL-01: Validar datos del filtro. |
| Mostrar detalles de un documento | Consultar un documento según su `id`. | Documento-POL-02: Excepción si no se encuentra. |
| Actualizar la información de un documento | Modificar los datos de un documento existente. | Documento-POL-02: Excepción si no se encuentra. |

###### Muestreo de datos

| id | nombre | codigo |
|---|---|---|
| 1 | Cédula de ciudadanía | CC |
| 2 | Cédula de extranjería | CI |

---

##### 10.3.2.6 Programación

**Descripción:** Representa la planificación de la poda, con fecha inicial y frecuencia en meses.

###### Atributos

| Atributo | Tipo de dato | Rango | Formato | Obligatorio | Modificable | Filtro | Listar | Ordenable | Descripción |
|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | Identificador único; no está al alcance del usuario final. |
| `fechaInicial` | Fecha | 01/01/2025 – 31/12/2100 | DD/MM/AAAA | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Fecha de inicio del primer ciclo de poda. |
| `frecuenciaMeses` | Numérico entero | 1 – 24 | Número entero | Sí | Sí | Sí | Sí {2} | Sí (ASC/DESC) | Periodicidad en meses con la que se repite la poda. |
| `cantidad` | Numérico entero | 1 – 24 | Número entero | Sí | Sí | Sí | Sí {3} | Sí (ASC/DESC) | Cantidad de repeticiones de la programación de poda. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única | `id` | La identificación de la programación no se puede repetir. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Definir una nueva programación de poda | Registrar una nueva programación con fechaInicial, frecuenciaMeses y cantidad. | Programación-POL-01 (unicidad de id), POL-02 (unicidad de fechaInicial por árbol), POL-03 (validación de datos). |
| Visualizar las programaciones registradas | Listar todas las programaciones con filtro opcional. | Programación-POL-04: Validar datos del filtro. |
| Revisar una programación específica | Consultar una programación según su `id`. | Programación-POL-03: Excepción si no se encuentra. |
| Actualizar una programación vigente | Modificar los datos de una programación existente. | Programación-POL-03: Excepción si no se encuentra. |
| Retirar definitivamente una programación | Eliminar una programación del sistema. | Programación-POL-05 (no puede estar en uso en una poda), POL-03 (excepción si no se encuentra). |

###### Muestreo de datos

| id | fechaInicial | frecuenciaMeses | cantidad |
|---|---|---|---|
| 1 | 01/01/2025 | 6 | 2 |
| 2 | 02/01/2025 | 4 | 3 |
| 3 | 03/01/2025 | 3 | 4 |

---

##### 10.3.2.7 Administrador

**Descripción:** Representa a los usuarios que tienen control total sobre la aplicación.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Sensible | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombreUsuario` | Alfanumérico | 2 | 60 | Sí | Sí | No | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre de usuario para inicio de sesión. No se puede repetir. |
| `correoElectronico` | Alfanumérico | 2 | 60 | Sí | Sí | No | Sí | Sí {2} | Sí (ASC/DESC) | Sí | Correo electrónico del administrador. No se puede repetir. |
| `correoConfirmado` | Lógico | — | — | Sí | Sí | No | Sí | Sí {3} | Sí (ASC/DESC) | Sí | Indica si el correo fue validado exitosamente. Valor por defecto: FALSE. |
| `numeroCelular` | Alfanumérico | 10 | 16 | Sí | Sí | **Sí** | Sí | Sí {4} | Sí (ASC/DESC) | Sí | Número de celular. No se puede repetir. |
| `celularConfirmado` | Lógico | — | — | Sí | Sí | No | Sí | Sí {5} | Sí (ASC/DESC) | Sí | Indica si el teléfono fue validado exitosamente. Valor por defecto: FALSE. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única uno | `nombreUsuario` | El nombre de usuario no puede repetirse. |
| Combinación única dos | `correoElectronico` | El correo electrónico no puede repetirse. |
| Combinación única tres | `numeroCelular` | El número de celular no puede repetirse. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Designar un nuevo administrador | Registrar un usuario con rol Administrador. | Administrador-POL-01 (unicidad de id), POL-02 (unicidad de nombreUsuario), POL-03 (unicidad de correo), POL-04 (unicidad de celular), POL-05 (validación general). |
| Visualizar el listado de administradores activos | Listar todos los administradores con filtro opcional. | Administrador-POL-06: Validar datos del filtro. |
| Revisar información detallada de un administrador | Consultar un administrador según su `id`. | Administrador-POL-05: Excepción si no se encuentra. |
| Actualizar los datos de un administrador activo | Modificar los datos de un administrador existente. | Administrador-POL-05: Excepción si no se encuentra. |
| Retirar un administrador del sistema | Eliminar un administrador (no referenciado en otro objeto). | Administrador-POL-05: Excepción si no se encuentra. |

###### Muestreo de datos

| id | nombreUsuario | correoElectronico | correoConfirmado | numeroCelular | celularConfirmado |
|---|---|---|---|---|---|
| 1 | daniloc | danilo.cordoba9497@uco.net.co | Sí | 3194656151 | Sí |
| 2 | michelg | michel.guarnizo2701@uco.net.co | No | 3226271355 | No |
| 3 | juanjg | juan.grisales2711@uco.net.co | No | 3127087800 | No |

---

##### 10.3.2.8 Riesgo

**Descripción:** Representa una escala cualitativa para medir el impacto de una PQR.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 3 | 30 | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del nivel de riesgo. No se puede repetir. |

###### Combinaciones únicas

`nombre` — El nombre del riesgo no puede repetirse.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Listar todos los riesgos | Visualizar los riesgos registrados con filtro opcional. | Riesgo-POL-01: Validar datos del filtro. |

###### Muestreo de datos

| id | nombre |
|---|---|
| 1 | Bajo |
| 2 | Medio |
| 3 | Alto |

---

##### 10.3.2.9 Estado

**Descripción:** Representa las condiciones en las que se puede encontrar un elemento del sistema.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 3 | 30 | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del estado. No se puede repetir. |

###### Combinaciones únicas

`nombre` — El nombre del estado no puede repetirse.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Listar todos los estados | Visualizar los estados registrados con filtro opcional. | Estado-POL-01: Validar datos del filtro. |

###### Muestreo de datos

| id | nombre |
|---|---|
| 1 | Abierto |
| 2 | En ejecución |
| 3 | Cerrado |

---

##### 10.3.2.10 Persona

**Descripción:** Representa los individuos que interactúan con el sistema, ya sea ciudadano o empleado relacionado con la gestión de podas.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Sensible | Calculado | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | No | No | Sí | Identificador único; no está al alcance del usuario final. |
| `nombreUno` | Alfanumérico | 2 | 60 | Sí | Sí | No | No | Sí | Sí {1} | Primer nombre del ciudadano. |
| `nombreDos` | Alfanumérico | 2 | 60 | No | Sí | No | No | Sí | Sí {1} | Segundo nombre del ciudadano. |
| `apellidoUno` | Alfanumérico | 2 | 60 | Sí | Sí | No | No | Sí | Sí {1} | Primer apellido del ciudadano. |
| `apellidoDos` | Alfanumérico | 2 | 60 | No | Sí | No | No | Sí | Sí {1} | Segundo apellido del ciudadano. |
| `Documento` | UUID (FK) | — | — | Sí | No | No | No | Sí | Sí | Tipo de documento de identidad (referencia a Documento). |
| `numeroDocumento` | Numérico | 5 | 15 | Sí | No | **Sí** | No | Sí | Sí | Número de documento de identidad. |
| `fechaNacimiento` | Fecha | — | Actualidad | Sí | No | No | No | Sí | Sí | Fecha de nacimiento (DD/MM/AAAA). La persona debe ser mayor de edad. |
| `direccion` | Alfanumérico | 7 | 120 | Sí | Sí | No | No | Sí | Sí | Dirección de residencia (letras, números y caracteres especiales .,#-). |
| `email` | Alfanumérico | 7 | 100 | Sí | Sí | **Sí** | No | Sí | Sí {2} | Correo electrónico (usuario@dominio.com). No se puede repetir. |
| `correoConfirmado` | Lógico | — | — | Sí | Sí | No | No | Sí | Sí {3} | Indica si el correo fue validado. |
| `telefono` | Alfanumérico | 7 | 15 | Sí | Sí | **Sí** | No | Sí | Sí {4} | Número de celular (solo números, opcional +57). No se puede repetir. |
| `telefonoConfirmado` | Lógico | — | — | Sí | Sí | No | No | Sí | Sí {5} | Indica si el teléfono fue validado. |
| `edad` | Numérico | 1 | 2 | Sí | No | No | **Sí** | Sí | Sí | Edad calculada. La persona debe ser mayor de edad. |

###### Combinaciones únicas

| Nombre | Atributos | Descripción |
|---|---|---|
| Combinación única uno | `Documento`, `numeroDocumento` | El tipo y número de documento no pueden repetirse. |
| Combinación única dos | `email` | El correo electrónico no puede repetirse. |
| Combinación única tres | `telefono` | El número de celular no puede repetirse. |

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Añadir una nueva persona | Registrar una nueva persona en el sistema. | Persona-POL-01 (unicidad de id), POL-02 (unicidad de documento, correo y celular), POL-03 (validación de datos). |
| Visualizar todas las personas registradas | Listar todas las personas con filtro opcional. | Persona-POL-04: Validar datos del filtro. |
| Examinar los datos de una persona específica | Consultar una persona según su `id`. | Persona-POL-03: Excepción si no se encuentra. |
| Actualizar los datos de una persona registrada | Modificar los datos de una persona existente. | Persona-POL-03: Excepción si no se encuentra. |
| Retirar definitivamente una persona | Eliminar una persona del sistema (no referenciada en otro objeto). | Persona-POL-03: Excepción si no se encuentra. |

###### Muestreo de datos

| id | nombreUno | apellidoUno | apellidoDos | Documento | numeroDocumento | email | telefono | edad |
|---|---|---|---|---|---|---|---|---|
| 1 | Danilo | Cordoba | Grisales | CC | 1017259497 | danilo.cordoba9497@uco.net.co | 3194656151 | 28 |
| 2 | Michel | Guarnizo | De los Ríos | CC | 1000442701 | michel.guarnizo2701@uco.net.co | 3226271355 | 22 |
| 3 | Juan José | Grisales | Castañeda | CC | 2222222222 | juan.grisales2711@uco.net.co | 3127087800 | 27 |

---

##### 10.3.2.11 Departamento

**Descripción:** Representa el departamento en el que se va a prestar el servicio de la poda.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 2 | 60 | Sí | No | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del departamento dentro de un país. No se puede repetir. |
| `pais` | UUID (FK) | — | — | Sí | Sí | Sí | No | Sí | Sí | País al que pertenece el departamento (referencia a País). |

###### Combinaciones únicas

`nombre` — El nombre del departamento no puede repetirse.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Explorar los departamentos registrados | Listar los departamentos con filtro opcional. | Departamento-POL-01: Validar datos del filtro. |
| Verificar un departamento específico | Consultar un departamento según su `id`. | Departamento-POL-02 (id debe existir), POL-03 (formato del id). |

###### Muestreo de datos

| id | nombre | pais |
|---|---|---|
| 1 | Antioquia | Colombia |

---

##### 10.3.2.12 Encargado

**Descripción:** Representa al empleado que lidera y supervisa el equipo de trabajo durante la ejecución de las podas.

###### Atributos

| Atributo | Tipo de dato | Obligatorio | Modificable | Identifica | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|
| `id` | UUID | Sí | No | Sí | No | Sí | Identificador único; no está al alcance del usuario final. |
| `persona` | UUID (FK) | Sí | No | Sí | Sí | Sí | Persona que se designa como encargado (referencia a Persona). |

###### Combinaciones únicas

`persona` — Una persona no puede registrarse más de una vez como encargado.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Añadir un nuevo encargado | Registrar un nuevo encargado. | Encargado-POL-01 (unicidad de id), POL-02 (unicidad de persona), POL-03 (validación de datos). |
| Listar encargados existentes | Consultar todos los encargados con filtro opcional. | Encargado-POL-04: Validar datos del filtro. |
| Revisar información de un encargado específico | Consultar un encargado según su `id`. | Encargado-POL-03: Excepción si no se encuentra. |
| Actualizar los datos de un encargado | Modificar los datos de un encargado existente. | Encargado-POL-03: Excepción si no se encuentra. |
| Retirar definitivamente un encargado | Eliminar un encargado del sistema (no referenciado en otro objeto). | Encargado-POL-03: Excepción si no se encuentra. |

###### Muestreo de datos

| id | persona (tipo-número) |
|---|---|
| 1 | CC-1017259497 |
| 2 | CC-1000442701 |
| 3 | CC-2222222222 |

---

##### 10.3.2.13 Operario

**Descripción:** Representa al empleado que ejecuta directamente las labores de poda utilizando las herramientas asignadas.

###### Atributos

| Atributo | Tipo de dato | Obligatorio | Modificable | Identifica | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|
| `id` | UUID | Sí | No | Sí | No | Sí | Identificador único; no está al alcance del usuario final. |
| `persona` | UUID (FK) | Sí | No | Sí | Sí | Sí | Persona que se designa como operario (referencia a Persona). |
| `cuadrilla` | UUID (FK) | Sí | No | Sí | Sí | Sí | Cuadrilla a la que pertenece el operario (referencia a Cuadrilla). |

###### Combinaciones únicas

`persona` + `cuadrilla` — Una persona no puede registrarse más de una vez como operario en la misma cuadrilla.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Añadir un nuevo operario | Registrar un nuevo operario. | Operario-POL-01 (unicidad de id), POL-02 (unicidad de persona y cuadrilla), POL-03 (validación de datos). |
| Listar los operarios registrados | Consultar todos los operarios con filtro opcional. | Operario-POL-04: Validar datos del filtro. |
| Revisar información de un operario específico | Consultar un operario según su `id`. | Operario-POL-03: Excepción si no se encuentra. |
| Actualizar los datos de un operario registrado | Modificar los datos de un operario existente. | Operario-POL-03: Excepción si no se encuentra. |
| Retirar definitivamente un operario | Eliminar un operario del sistema (no referenciado en otro objeto). | Operario-POL-03: Excepción si no se encuentra. |

###### Muestreo de datos

| id | persona | cuadrilla |
|---|---|---|
| 1 | CC-1017259497 | E-001 |
| 2 | CC-1000442701 | E-002 |
| 3 | CC-2222222222 | E-003 |

---

##### 10.3.2.14 Municipio

**Descripción:** Representa el municipio en el que se va a prestar el servicio de la poda.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 2 | 60 | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del municipio. No se puede repetir dentro del departamento. |
| `departamento` | UUID (FK) | — | — | Sí | Sí | Sí | No | Sí | Sí | Departamento al que pertenece el municipio (referencia a Departamento). |

###### Combinaciones únicas

`nombre` — El nombre del municipio no puede repetirse dentro del departamento.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Explorar los municipios registrados | Listar todos los municipios con filtro opcional. | Municipio-POL-01: Validar datos del filtro. |
| Verificar un municipio específico | Consultar un municipio según su `id`. | Municipio-POL-02 (id debe existir), POL-03 (formato del id). |

###### Muestreo de datos

| id | nombre | departamento |
|---|---|---|
| 1 | Rionegro | Antioquia – Colombia |

---

##### 10.3.2.15 Cuadrilla

**Descripción:** Representa el grupo de empleados asignados a realizar una poda programada en un sector.

###### Atributos

| Atributo | Tipo de dato | Obligatorio | Modificable | Identifica | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|
| `id` | UUID | Sí | No | Sí | No | Sí | Identificador único; no está al alcance del usuario final. |
| `nombreCuadrilla` | Alfanumérico | — | — | Sí | Sí | Sí {1} | Nombre o código del equipo de trabajo. No se puede repetir. |
| `encargado` | UUID (FK) | No | Sí | No | Sí | Sí {2} | Encargado responsable de liderar la cuadrilla (referencia a Encargado). |

###### Combinaciones únicas

`nombreCuadrilla` — El nombre de la cuadrilla no puede repetirse en el sistema.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Incorporar una nueva cuadrilla | Crear un nuevo grupo de trabajo. | Cuadrilla-POL-01 (unicidad de id), POL-02 (validación de datos), POL-03 (unicidad de nombreCuadrilla). |
| Listar todas las cuadrillas registradas | Consultar todas las cuadrillas con filtro opcional. | Cuadrilla-POL-02: Validar datos del filtro. |
| Examinar una cuadrilla específica | Consultar una cuadrilla según su `id`. | Cuadrilla-POL-04 (formato del id), POL-05 (existencia del registro), POL-02 (validación de datos). |
| Actualizar los datos de una cuadrilla registrada | Modificar los datos de una cuadrilla existente. | Cuadrilla-POL-04, POL-05, POL-02, POL-03: mismas validaciones de creación y existencia. |
| Retirar una cuadrilla definitivamente | Eliminar una cuadrilla del sistema. | Cuadrilla-POL-04, POL-05, POL-06 (no puede tener podas con estado "abierto"). |
| Asignar un encargado de cuadrilla | Designar un encargado a una cuadrilla existente. | Cuadrilla-POL-04, POL-05, POL-07 (el encargado debe existir en el sistema). |

###### Muestreo de datos

| id | nombreCuadrilla | encargado |
|---|---|---|
| 1 | E-001 | CC-1017259497 |
| 2 | E-002 | CC-1000442701 |
| 3 | E-003 | CC-2222222222 |

---

##### 10.3.2.16 Sector

**Descripción:** Representa los sectores del municipio en los que se va a prestar el servicio de la poda.

###### Atributos

| Atributo | Tipo de dato | Long. mín | Long. máx | Obligatorio | Modificable | Identifica | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | Sí | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `nombre` | Alfanumérico | 2 | 80 | Sí | Sí | No | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Nombre del sector dentro del municipio. No se puede repetir. |
| `municipio` | UUID (FK) | — | — | Sí | Sí | No | Sí | Sí {2} | Sí (ASC/DESC) | Sí | Municipio al que pertenece el sector (referencia a Municipio). |

###### Combinaciones únicas

`nombre` — El nombre del sector no puede repetirse dentro del municipio.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Añadir un nuevo sector en el municipio | Crear un sector dentro del municipio. | Sector-POL-01 (unicidad de id), POL-02 (validación de datos), POL-03 (unicidad de nombre). |
| Actualizar un sector específico | Modificar los datos de un sector existente. | Sector-POL-04 (existencia), POL-05 (formato del id), POL-06 (validación), POL-03 (unicidad). |
| Retirar un sector registrado | Eliminar un sector del sistema. | Sector-POL-04, POL-05, POL-07 (ningún árbol puede tener asociado el sector). |
| Revisar todos los sectores registrados | Listar todos los sectores con filtro opcional. | Sector-POL-08: Validar datos del filtro. |
| Examinar un sector específico | Consultar un sector según su `id`. | Sector-POL-04 (existencia), POL-05 (formato del id). |

###### Muestreo de datos

| id | nombre | municipio |
|---|---|---|
| 1 | Porvenir Tercera Etapa | Rionegro – Antioquia |
| 2 | El porvenir comuna 4 villa manuela | Rionegro – Antioquia |
| 3 | El centro comuna 3 avenida galán | Rionegro – Antioquia |
| 4 | San Antonio comuna 1 san bartolo | Rionegro – Antioquia |
| 5 | Santa Ana comuna 2 altos de la Pereira | Rionegro – Antioquia |

---

##### 10.3.2.17 PQR

**Descripción:** Representa las peticiones, quejas o reclamos asociados a un árbol de un sector, que llevan a la realización o no de una poda.

###### Atributos

| Atributo | Tipo de dato | Obligatorio | Modificable | Calculado | Sensible | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|---|
| `id` | UUID | Sí | No | No | No | No | Sí | Identificador único; no está al alcance del usuario final. |
| `fecha` | Fecha (DD/MM/AAAA) | No | No | **Sí** | No | Sí | Sí {1} | Fecha de registro de la PQR. Valor por defecto: fecha actual del sistema. |
| `estado` | UUID (FK) | Sí | Sí | No | No | Sí | Sí {2} | Estado de la PQR (referencia a Estado). Valor por defecto: Abierta. |
| `riesgo` | UUID (FK) | No | No | No | No | Sí | Sí {3} | Nivel de riesgo (referencia a Riesgo). Valor por defecto: Null. |
| `sector` | UUID (FK) | Sí | No | No | No | Sí | Sí {4} | Sector del árbol involucrado (referencia a Sector). |
| `persona` | UUID (FK) | No | No | No | **Sí** | Sí | Sí {5} | Ciudadano que realizó la PQR (referencia a Persona). |
| `registroFotografico` | Alfanumérico | 2 | 2048 | No | **Sí** | No | Sí {6} | Ruta a las evidencias fotográficas adjuntas. |

###### Combinaciones únicas

`id` — El identificador de la PQR garantiza su unicidad en el sistema.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Añadir una nueva PQR | Registrar una solicitud ciudadana. | pqr-POL-01 (unicidad de id), pqr-POL-02 (validación de datos). |
| Cambiar estado de una PQR | Actualizar el estado de una PQR existente. | pqr-POL-03 (formato), pqr-POL-04 (existencia), pqr-POL-05 (PQR cerrada no modificable), pqr-POL-06 (fecha de cierre no puede ser anterior a la de apertura). |
| Listar todas las PQR existentes | Consultar todas las PQR con filtro opcional. | pqr-POL-07: Validar datos del filtro. |
| Revisar una PQR específica | Consultar una PQR según su `id`. | pqr-POL-08 (formato), pqr-POL-09 (existencia). |
| Retirar definitivamente una PQR | Eliminar una PQR del sistema. | pqr-POL-10 (formato), pqr-POL-11 (existencia), pqr-POL-12 (no puede estar vinculada a poda abierta). |
| Actualizar una PQR | Modificar los datos de una PQR existente. | pqr-POL-13 (formato), pqr-POL-14 (existencia), pqr-POL-15 (PQR cerrada no modificable), pqr-POL-16 (unicidad). |
| Asignar riesgo a una PQR | Modificar el nivel de riesgo de una PQR. | pqr-POL-17 (formato), pqr-POL-18 (existencia), pqr-POL-19 (validación de datos), pqr-POL-20 (unicidad). |

###### Muestreo de datos

| id | fecha | estado | riesgo | sector | persona |
|---|---|---|---|---|---|
| 1 | 01/04/2025 | Abierto | Bajo | Porvenir Tercera Etapa | CC-1017259497 |
| 2 | 12/05/2025 | Cerrado | Medio | El porvenir comuna 4 | CC-1000442701 |
| 3 | 12/05/2025 | En ejecución | Alto | El centro comuna 3 | CC-2222222222 |

---

##### 10.3.2.18 Árbol

**Descripción:** Representa un árbol específico con información detallada como especie, ubicación y registros de poda.

###### Atributos

| Atributo | Tipo de dato | Precisión | Rango | Obligatorio | Modificable | Filtro | Listar | Ordenable | Visible | Descripción |
|---|---|---|---|---|---|---|---|---|---|---|
| `id` | UUID | — | — | Sí | No | No | Sí | No | No | Identificador único; no está al alcance del usuario final. |
| `Longitud` | Decimal | 10 cifras, 6 decimales | –180 a 180 | Sí | Sí | Sí | Sí {1} | Sí (ASC/DESC) | Sí | Longitud geográfica del árbol (truncamiento). |
| `Latitud` | Decimal | 10 cifras, 6 decimales | –90 a 90 | Sí | Sí | Sí | Sí {2} | Sí (ASC/DESC) | Sí | Latitud geográfica del árbol (truncamiento). |
| `Especie` | UUID (FK) | — | — | Sí | Sí | Sí | Sí {3} | Sí (ASC/DESC) | Sí | Nombre científico del árbol (referencia a Familia). |
| `Sector` | UUID (FK) | — | — | No | Sí | Sí | Sí {4} | Sí (ASC/DESC) | Sí | Sector al que pertenece el árbol (referencia a Sector). |
| `programacion` | UUID (FK) | — | — | No | Sí | No | Sí {5} | Sí | Sí | Programación de poda asociada al árbol (referencia a Programación). |

###### Combinaciones únicas

`especie` + `Longitud` + `Latitud` — No pueden existir dos árboles con la misma especie y coordenadas geográficas dentro del mismo sector.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Registrar un nuevo árbol | Crear un árbol con su ubicación y características. | Árbol-POL-01 (unicidad de id), POL-02 (validación de datos), POL-03 (unicidad de especie+coordenadas). |
| Actualizar un árbol registrado | Modificar la información de un árbol existente. | Árbol-POL-04 (formato del id), POL-05 (existencia), POL-02 (validación), POL-03 (unicidad). |
| Listar todos los árboles | Consultar todos los árboles con filtro opcional. | Árbol-POL-06: Validar datos del filtro. |
| Examinar un árbol específico | Consultar un árbol según su `id`. | Árbol-POL-04 (formato), POL-05 (existencia). |
| Retirar definitivamente un árbol | Eliminar un árbol del sistema. | Árbol-POL-04, POL-05, POL-07 (no puede estar en uso en poda con estado "abierto"). |

###### Muestreo de datos

| id | Longitud | Latitud | Especie | programacion | Sector |
|---|---|---|---|---|---|
| 1 | –75.382563 | 6.145493 | Araucaria heterophylla | 1 | El porvenir comuna 4 |
| 2 | –75.382687 | 6.145493 | Syzygium paniculata | 2 | El porvenir comuna 4 |
| 3 | –75.382467 | 6.145503 | Archontophoenix cunninghamiana | 3 | El porvenir comuna 4 |
| 4 | –75.375115 | 6.148721 | Inga sp | — | El centro comuna 3 |
| 5 | –75.375177 | 6.148722 | Handroanthus chrysanthus | — | El centro comuna 3 |
| 6 | –75.375353 | 6.148725 | Prunus serotine | — | El centro comuna 3 |
| 7 | –75.383343 | 6.127223 | Citrus spp | — | San Antonio comuna 1 |
| 8 | –75.383347 | 6.127257 | Persea americana | — | San Antonio comuna 1 |
| 9 | –75.383295 | 6.127282 | Acca sellowiana | — | San Antonio comuna 1 |
| 10 | –75.374468 | 6.142899 | Yucca gigantea | — | Santa Ana comuna 2 |

---

##### 10.3.2.19 Poda

**Descripción:** Representa el registro detallado de una poda realizada, con fotos, herramientas utilizadas y el equipo de empleados involucrados.

###### Atributos

| Atributo | Tipo de dato | Obligatorio | Modificable | Valor por defecto | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|
| `id` | UUID | Sí | No | — | No | Sí | Identificador único; no está al alcance del usuario final. |
| `estado` | UUID (FK) | Sí | Sí | — | Sí | Sí {1} | Estado actual de la poda (referencia a Estado). |
| `fechaPlaneado` | Fecha (AAAA/MM/DD) | Sí | Sí | — | Sí | Sí {2} | Fecha programada. No puede ser anterior a la fecha actual. |
| `fechaEjecutado` | Fecha (AAAA/MM/DD) | No | Sí | Nulo | Sí | Sí {3} | Fecha de ejecución real de la poda. |
| `arbol` | UUID (FK) | Sí | Sí | — | Sí | Sí {4} | Árbol sobre el que se realiza la poda (referencia a Árbol). |
| `cuadrilla` | UUID (FK) | No | Sí | — | Sí | Sí {5} | Equipo de trabajo asignado (referencia a Cuadrilla). |
| `tipo` | UUID (FK) | Sí | Sí | — | Sí | Sí {6} | Clasificación de la poda — Preventivo / Correctivo (referencia a Tipo). |
| `PQR` | UUID (FK) | No | Sí | — | Sí | Sí {7} | PQR asociada, si es poda correctiva (referencia a PQR). |
| `registroFotografico` | UUID (FK) | No | Sí | — | No | Sí {9} | Referencia a las fotos antes, durante y después de la poda. |
| `observaciones` | Alfanumérico | No | Sí | Nulo | No | Sí {10} | Observaciones de campo (máx. 500 caracteres). |

###### Combinaciones únicas

`fechaPlaneado` + `arbol` — No pueden existir dos podas para el mismo árbol en la misma fecha planificada.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Programar una poda preventiva | Registrar una nueva poda preventiva. | poda-POL-01 (unicidad de id), POL-02 (validación), POL-03 (unicidad de fecha+árbol), POL-04 (árbol debe existir), POL-05 (estado no puede ser "Cerrado"), POL-06 (tipo debe existir), POL-07 (tipo debe ser "Preventivo"), POL-08 (programación debe existir), POL-09 (programación en estado abierto o en ejecución). |
| Programar una poda correctiva | Registrar una nueva poda correctiva. | poda-POL-01, POL-02, POL-04, POL-05, POL-06, poda-POL-10 (tipo debe ser "Correctivo"), POL-11 (PQR debe existir), POL-12 (PQR en estado abierto o en ejecución), POL-13 (árbol no puede tener poda el mismo día), POL-14 (existencia del registro). |
| Registrar ejecución de una poda | Marcar la poda como ejecutada con los recursos utilizados. | poda-POL-04 (árbol existente), POL-05 (existencia), POL-02 (poda no cerrada), POL-03 (estado de ejecución). |
| Listar las podas registradas | Consultar todas las podas con filtro opcional. | poda-POL-06: Validar datos del filtro. |
| Examinar una poda específica | Consultar una poda según su `id`. | poda-POL-04 (formato), POL-05 (existencia). |
| Retirar una poda registrada | Eliminar una poda del sistema. | poda-POL-04, POL-05, poda-POL-07 (no puede estar asociada a podaHerramienta). |
| Actualizar una poda específica | Cambiar el estado de una poda o registrar su ejecución. | poda-POL-04, POL-05, POL-02, POL-03: validaciones de integridad y estado. |
| Asignar una cuadrilla a la poda | Designar una cuadrilla para ejecutar la poda. | poda-POL-04, POL-05, POL-02, POL-03, poda-POL-08 (cuadrilla debe existir). |

###### Muestreo de datos

| id | estado | fechaPlaneado | fechaEjecutado | arbol | cuadrilla | tipo | PQR |
|---|---|---|---|---|---|---|---|
| 1 | Ejecutado | 01/01/2025 | 01/01/2025 | Araucaria – E-001 | E-001 | Preventivo | — |
| 2 | Planeado | 01/08/2025 | — | Araucaria – E-001 | E-001 | Preventivo | — |
| 3 | Planeado | 01/10/2025 | — | Araucaria – E-001 | E-001 | Correctivo | 1 |
| 4 | Planeado | 02/02/2026 | — | Araucaria – E-001 | E-001 | Preventivo | — |

---

##### 10.3.2.20 PodaHerramienta

**Descripción:** Representa la relación entre las podas y las herramientas utilizadas en ellas.

###### Atributos

| Atributo | Tipo de dato | Obligatorio | Modificable | Identifica | Filtro | Listar | Descripción |
|---|---|---|---|---|---|---|---|
| `id` | UUID | Sí | No | Sí | No | Sí | Identificador único; no está al alcance del usuario final. |
| `poda` | UUID (FK) | Sí | Sí | No | Sí | Sí {1} | Poda en la que se utilizó la herramienta (referencia a Poda). |
| `herramienta` | UUID (FK) | Sí | Sí | No | Sí | Sí {2} | Herramienta utilizada en la poda (referencia a Herramienta). |

###### Combinaciones únicas

`poda` + `herramienta` — La asociación entre una poda y una herramienta no puede registrarse más de una vez.

###### Responsabilidades y políticas

| Responsabilidad | Descripción | Políticas aplicadas |
|---|---|---|
| Añadir herramientas empleadas en una poda | Indicar qué herramienta fue utilizada en la poda. | podaHerramienta-POL-01 (unicidad de id), POL-02 (validación de datos), POL-03 (unicidad de poda+herramienta). |
| Actualizar una herramienta específica | Modificar la herramienta asociada a una poda. | podaHerramienta-POL-04 (formato del id), POL-05 (existencia), POL-02 (validación), POL-03 (unicidad). |
| Examinar todas las herramientas de una poda | Listar todas las herramientas registradas con filtro opcional. | podaHerramienta-POL-06: Validar datos del filtro. |
| Revisar una herramienta específica | Consultar un registro de podaHerramienta según su `id`. | podaHerramienta-POL-04 (formato), POL-05 (existencia). |
| Retirar definitivamente una herramienta | Eliminar el registro de herramienta de una poda. | podaHerramienta-POL-04 (formato), POL-05 (existencia). |

###### Muestreo de datos

| id | poda | herramienta |
|---|---|---|
| 1 | Araucaria–75.382563/6.145493–01/01/2025 | Pala |


<a id="sec-10-3-3"></a>
#### 10.3.3 Diagrama de Objetos

El diagrama de objetos muestra una instantánea (snapshot) del sistema con instancias concretas de las clases del dominio en un momento dado, lo que ayuda a comprender cómo se relacionan los objetos en tiempo de ejecución.

> **📷 Diagrama requerido — Diagrama de Objetos**  
> **Archivo:** `./images/tp-object-diagram.png`  
> **Descripción esperada:** Instantánea del sistema con objetos concretos. Ejemplo sugerido: un árbol Araucaria del sector "Porvenir Tercera Etapa" de Rionegro (Antioquia, Colombia), con una Programación de poda preventiva semestral, una Poda ejecutada del 01/01/2025 (Preventivo, Estado=Ejecutado, Cuadrilla=E-001 con Encargado y 2 Operarios), y una PQR-1 abierta del ciudadano CC-1017259497.

![Diagrama de Objetos](./images/tp-object-diagram.png)

<a id="sec-10-4"></a>
### 10.4 Vista de Despliegue / Vista de Implementación

La vista de implementación describe la organización interna del código fuente mediante diagramas de componentes y paquetes.

<a id="sec-10-4-1"></a>
#### 10.4.1 Diagrama de Componentes — Backend

El diagrama de componentes muestra la organización modular del sistema en términos de unidades de software desplegables o reutilizables (componentes), las interfaces que cada componente expone o consume, y las dependencias entre ellos. Su motivación es comunicar la arquitectura interna del sistema en un nivel intermedio entre el diseño detallado de clases (vista lógica) y la infraestructura física (vista de despliegue), lo que permite al equipo planificar el orden de construcción, gestionar las dependencias técnicas y razonar sobre el impacto de cambios en un componente sobre los demás. Para el Backend de Tree Pruning, los componentes corresponden a los módulos de Spring Boot y las integraciones con servicios externos (Keycloak, Infisical, FCM, Spring Cloud Config).

| Componente | Descripción | Depende de |
|---|---|---|
| **Backend Tree Pruning** | Núcleo que expone servicios REST para los 4 módulos | Spring Boot 3.3+, Java 26, PostgreSQL, Infisical, API Gateway |
| **Spring Boot 3.3+** | Framework con autoconfiguración y módulos integrados | Java 26 |
| **Spring Data JPA + PostGIS** | Persistencia con soporte geoespacial | PostgreSQL + PostGIS |
| **Spring Security + OAuth2** | Validación JWT contra Keycloak | Keycloak |
| **Spring Web** | Exposición de APIs REST | Spring Boot |
| **Spring Events** | Trazabilidad asíncrona y notificaciones | Spring Boot |
| **Spring Actuator** | Métricas para Prometheus | Spring Boot |
| **Infisical SDK/CLI** | Obtención segura de secretos | Infisical SaaS |
| **FCM SDK** | Envío de notificaciones push | Firebase Cloud Messaging |
| **Spring Cloud Config Client** | Parámetros operativos del municipio | Spring Cloud Config |
| **CrossCutting** | Excepciones, helpers, utilidades compartidas | Java 26 |

> **📷 Diagrama requerido — Diagrama de Componentes**  
> **Archivo:** `./images/tp-component-diagram.png`  
> **Descripción esperada:** Diagrama UML de componentes que muestre los componentes del Backend (Backend Tree Pruning, Spring Boot, Spring Data JPA + PostGIS, Spring Security + OAuth2, Spring Web, Spring Events, Spring Actuator, Infisical SDK, FCM SDK, Spring Cloud Config Client, CrossCutting) con sus interfaces requeridas y provistas (lollipops y sockets).

![Diagrama de Componentes](./images/tp-component-diagram.png)


<a id="sec-10-4-2"></a>
#### 10.4.2 Diagrama de Componentes — Frontend

El diagrama de componentes del Frontend muestra la estructura modular de la SPA (Single Page Application) en Vue.js 3, las librerías que la conforman y las dependencias entre ellas. A diferencia del Backend (donde los componentes son módulos de Spring Boot), aquí los componentes son las librerías de runtime del navegador (Vue.js core, Vue Router, Pinia, Axios, Bootstrap) más los SDK de servicios externos (Google Maps Platform, Firebase Cloud Messaging). Estos componentes se empaquetan juntos en el bundle estático que sirve nginx desde el contenedor Docker del Frontend.

| Componente | Descripción | Depende de |
|---|---|---|
| **Frontend Tree Pruning** | SPA contenedora que orquesta todos los módulos funcionales (Inventario, Podas, PQR, Reportes, Administración) | Vue.js 3, Vue Router, Pinia, Axios, Bootstrap, Google Maps SDK, FCM SDK |
| **Vue.js 3** | Framework reactivo con Composition API y Single-File Components que provee el sistema de renderizado y reactividad | — (núcleo del runtime) |
| **Vue Router 4** | Router declarativo de rutas SPA con soporte para `beforeEach` guards. Implementa el control de acceso por rol antes de renderizar cada página | Vue.js 3, Pinia (para leer rol/JWT del store) |
| **Pinia** | Store de estado global. Mantiene el token JWT, el rol del usuario autenticado, los módulos habilitados y las preferencias de usuario | Vue.js 3 |
| **Axios** | Cliente HTTP con interceptores. El interceptor de request adjunta el JWT del Pinia store; el interceptor de response gestiona 401/403 redirigiendo al login | Pinia (lectura del JWT) |
| **Bootstrap 5.3+** | Biblioteca de componentes UI (formularios con validación, tablas, modales, alertas, grid responsive). Provee el sistema visual del aplicativo | — (CSS + JS estándar) |
| **Google Maps Platform SDK** | SDK JavaScript para renderizar el mapa interactivo de árboles, sectores (polígonos) y podas georreferenciadas. Habilita los marcadores, infowindows y bounding box requeridos por la paginación geográfica | — (servicio externo) |
| **Firebase Cloud Messaging SDK** | SDK JavaScript para recibir notificaciones push en el navegador del Encargado de Cuadrilla y del Ciudadano (cambios de estado de PQR, asignación de podas) | — (servicio externo) |
| **Vue I18n** | Internacionalización del Frontend (RNF-09: español de Colombia, formato DD/MM/AAAA, moneda COP). Permite habilitar idiomas adicionales en el futuro sin rediseño | Vue.js 3 |

**Relaciones clave entre componentes:**

```
Frontend Tree Pruning
   │
   ├── Vue.js 3                              (motor reactivo)
   │
   ├── Vue Router 4
   │     └── (consulta Pinia para rol/JWT en cada navegación)
   │
   ├── Pinia                                 (estado global)
   │     └── (consultado por Axios y Vue Router)
   │
   ├── Axios
   │     ├── interceptor request → Pinia (adjunta JWT)
   │     ├── interceptor response → Pinia/Vue Router (gestiona 401/403)
   │     └── → API Gateway (HTTPS)
   │
   ├── Bootstrap 5.3+                        (componentes UI)
   │
   ├── Google Maps Platform SDK
   │     └── → maps.googleapis.com (HTTPS)
   │
   ├── Firebase Cloud Messaging SDK
   │     └── → fcm.googleapis.com (HTTPS)
   │
   └── Vue I18n                              (formatos regionales)
```

**Empaquetado y entrega:**

Todos los componentes del Frontend se empaquetan en un único bundle estático durante el build (`npm run build`), que se ejecuta dentro del job de GitHub Actions sobre Node 20 Alpine. El resultado es un conjunto de archivos `index.html`, `assets/*.js`, `assets/*.css` y recursos estáticos que se copian a la imagen `nginx:alpine`, publicada en GitHub Container Registry (GHCR). Traefik enruta el dominio raíz `treepruning.org` al contenedor Frontend y entrega los archivos estáticos al navegador del usuario, donde el bundle se hidrata y arranca la SPA.

> **📷 Diagrama requerido — Diagrama de Componentes Frontend**  
> **Descripción esperada:** Diagrama UML de componentes del Frontend Vue.js mostrando el componente raíz `Frontend Tree Pruning` y sus dependencias hacia Vue.js 3 (núcleo), Vue Router 4 (con dependencia hacia Pinia), Pinia (store), Axios (con dependencias hacia Pinia para JWT y hacia API Gateway externo), Bootstrap 5.3+, Google Maps Platform SDK (con dependencia hacia servicio externo), Firebase Cloud Messaging SDK (con dependencia hacia servicio externo) y Vue I18n. Marcar con estereotipos `<<library>>` los componentes internos y `<<external_service>>` los SDKs que se conectan a servicios externos.

![Diagrama de Componentes Frontend](./images/tp-component-frontend.png)

<a id="sec-10-4-3"></a>
#### 10.4.3 Diagrama de Paquetes — Backend

El diagrama de paquetes representa la organización lógica del código fuente en agrupaciones jerárquicas (paquetes o carpetas) que reflejan la separación de responsabilidades del sistema. Su motivación es hacer visible la estructura física del repositorio de código —independientemente del despliegue— para que el equipo sepa dónde ubicar cada nueva clase, dónde buscar lógica existente y cómo evolucionar el sistema sin romper la separación de capas.

El Backend de Tree Pruning adopta una organización híbrida que combina **Clean Architecture** (con su flujo de dependencias unidireccional `infrastructure → application → domain`, nunca al revés) con **Vertical Slice Architecture**: cada caso de uso del sistema es un *vertical slice* completo dentro del paquete `features`, encapsulando su propio inputport, DTO, validador, interactor, use case, dominio y reglas de negocio. Esta combinación tiene tres beneficios prácticos para el equipo:

- **Cohesión por caso de uso:** Todo lo necesario para una operación de negocio (por ejemplo, programar una poda preventiva) está dentro de una única carpeta, evitando navegar entre carpetas horizontales (`controllers`, `services`, `repositories`) cuando se trabaja sobre una sola funcionalidad.
- **Aislamiento de cambios:** Modificar una regla de negocio de un caso de uso no afecta el código de otros casos. Cada *slice* puede evolucionar de forma independiente.
- **Reutilización controlada:** Las preocupaciones realmente transversales (manejo de excepciones, helpers, respuesta global, seguridad) se ubican en `crosscutting` e `infrastructure`, accesibles desde cualquier feature sin acoplar features entre sí.

**Estructura del Backend (general):**

```
co.edu.uco.treepruning
│
├── initializer                          (clase main de Spring Boot)
│
├── crosscutting                         (preocupaciones transversales)
│   ├── exception                       (excepciones genéricas reutilizables)
│   ├── helper                          (utilidades de propósito general:
│   │                                    fechas, números, texto, booleanos, UUIDs)
│   └── response                        (respuesta HTTP estándar y manejo
│                                        centralizado de excepciones)
│
├── application                          (contratos base globales)
│   ├── inputport                       (interfaz base InputPort de la cual
│   │                                    heredan los inputport de cada feature)
│   └── usecase                         (interfaz base UseCase de la cual
│                                        heredan los use case de cada feature)
│
├── features                             (organizado por dominio → caso de uso)
│   └── <domain-object>                 (un paquete por entidad de dominio:
│       │                                family, manager, person, sector,
│       │                                status, tree, type, quadrille,
│       │                                programming, pruning, pqr, …)
│       │
│       └── <transaction>               (un paquete por caso de uso de la
│           │                            entidad: getXByFilter, submitX,
│           │                            scheduleX, …)
│           │
│           └── application
│               ├── inputport           (contrato de entrada del caso de uso)
│               │   ├── interactor      (orquestador del caso de uso)
│               │   │   └── mapper      (DTO ↔ objeto de dominio)
│               │   └── dto             (objeto de transferencia de datos
│               │                        + validador, si aplica)
│               │
│               └── usecase             (operación de negocio)
│                   ├── impl            (implementación del caso de uso)
│                   │   └── mapper      (Domain ↔ Entity)
│                   ├── domain          (objeto de dominio específico
│                   │                    del caso de uso)
│                   └── rules           (excepciones de negocio del caso
│                                        de uso, solo si tiene reglas que
│                                        pueden fallar)
│
└── infrastructure                       (adaptadores de entrada y de salida)
    │
    ├── controller                      (adaptadores de entrada — REST)
    │   └── request                     (objetos de request HTTP)
    │
    ├── security                        (configuración de Spring Security
    │                                    y validación de JWT)
    │
    └── persistence
        └── repository                  (puertos de salida — interfaces)
            ├── <repository-interfaces> (puertos abstractos que el dominio
            │                            declara y la infraestructura implementa)
            ├── entity                  (entidades de dominio para la capa
            │                            de repositorio)
            │
            ├── adapter                 (implementaciones de los puertos)
            │   └── sql
            │       └── jpa             (adapters JPA de los puertos)
            │           └── mapper      (MapStruct: Entity ↔ Domain)
            │
            └── sql
                └── jpa                 (Spring Data JPA + Hibernate)
                    ├── <jpa-repositories> (interfaces Spring Data JPA)
                    └── entity          (entidades JPA — Hibernate)
```

**Responsabilidad de cada paquete:**

| Paquete | Qué contiene |
|---|---|
| `initializer` | La clase main de Spring Boot (`@SpringBootApplication`). Es el punto de entrada del Backend. |
| `crosscutting.exception` | Excepciones genéricas reutilizables por cualquier feature. |
| `crosscutting.helper` | Utilidades de propósito general (fechas, números, texto, booleanos, UUIDs). |
| `crosscutting.response` | La estructura `ApiResponse` común para todas las respuestas HTTP y el `GlobalExceptionHandler` que captura las excepciones y las traduce a respuestas estándar. |
| `application.inputport` | La interfaz base `InputPort` que define el contrato común para invocar cualquier caso de uso desde el exterior. |
| `application.usecase` | La interfaz base `UseCase` que define el contrato común de cualquier operación de negocio. |
| `features.<domain-object>` | Una carpeta por cada entidad principal del dominio (family, tree, pruning, pqr, etc.). Sirve de agrupación de los casos de uso relacionados con esa entidad. |
| `features.<domain-object>.<transaction>` | Una carpeta por cada caso de uso de la entidad. Es el *vertical slice*: contiene todo lo necesario para ejecutar esa operación. |
| `features.<domain-object>.<transaction>.application.inputport` | Cómo se invoca el caso de uso desde afuera: el DTO de entrada/salida, el validador del DTO (si aplica) y el interactor que orquesta la ejecución. |
| `features.<domain-object>.<transaction>.application.usecase` | La operación de negocio en sí: el contrato del use case, el objeto de dominio específico del caso de uso, la implementación y las excepciones de negocio que pueden lanzarse (paquete `rules`). |
| `infrastructure.controller` | Los controladores REST que reciben las peticiones HTTP y las traducen en invocaciones de los inputport correspondientes. Sus objetos de request viven en `controller.request`. |
| `infrastructure.security` | La configuración de Spring Security (cadena de filtros, validación de JWT contra Keycloak, RBAC). |
| `infrastructure.persistence.repository` | Los puertos de salida (interfaces de repositorio) declarados desde el lado del dominio, junto con sus entidades de dominio. |
| `infrastructure.persistence.repository.adapter.sql.jpa` | Los adapters que implementan los puertos del repositorio usando JPA, con sus mappers MapStruct entre Entity ↔ Domain. |
| `infrastructure.persistence.repository.sql.jpa` | Los repositorios Spring Data JPA (interfaces marcadas con `@Repository`) y las entidades JPA con anotaciones Hibernate (`*JPAEntity`). |

**Flujo de una solicitud a través de los paquetes:**

```
HTTP Request
   ↓
infrastructure.controller                                (recibe Request)
   ↓
features.<X>.<transaction>.application.inputport         (interactor valida
   ↓                                                      DTO, invoca UseCase)
features.<X>.<transaction>.application.usecase           (orquesta reglas
   ↓                                                      de negocio)
infrastructure.persistence.repository                    (puerto de salida)
   ↓
infrastructure.persistence.repository.adapter.sql.jpa    (adapter JPA)
   ↓
infrastructure.persistence.repository.sql.jpa            (Spring Data JPA)
   ↓
PostgreSQL                                                (vía Hibernate)
```

Este flujo respeta la regla fundamental de Clean Architecture: las dependencias siempre apuntan hacia adentro. El `controller` no conoce las entidades JPA; conoce únicamente el contrato del `InputPort`. El `usecase` no conoce Hibernate; conoce únicamente la interfaz del repositorio. La infraestructura es reemplazable sin tocar la lógica de negocio del feature.

> **📷 Diagrama requerido — Diagrama de Paquetes Backend**  
> **Archivo:** `./images/tp-package-backend.png`  
> **Descripción esperada:** Diagrama UML de paquetes que represente la estructura `co.edu.uco.treepruning` con sus paquetes principales (`initializer`, `crosscutting`, `application`, `features`, `infrastructure`) usando placeholders genéricos `<domain-object>` y `<transaction>` para mostrar el patrón aplicable a cualquier feature, y las relaciones de dependencia entre paquetes (flechas que respeten la regla de Clean Architecture: `infrastructure` depende de `features`, `features` depende de `application`, todos pueden depender de `crosscutting` cuando aplica). Acompañar con la nota de que cada `<transaction>` contiene su propio `inputport` (con DTO, validador, interactor y mapper) y `usecase` (con domain, impl, mapper y rules).

![Diagrama de Paquetes Backend](./images/tp-package-backend.png)

<a id="sec-10-4-4"></a>
#### 10.4.4 Diagrama de Paquetes — Frontend

```
src
├── assets          (imágenes, íconos, estilos globales)
├── utils           (formateo de fechas, cálculo de plazos, coordenadas GPS)
├── pages           (Inventario, Podas, PQR, Reportes, Administración)
├── components      (formularios Bootstrap, tablas, mapa Google Maps, modales)
├── router          (rutas con guards por rol)
├── store           (Pinia: token JWT, rol, módulos habilitados)
├── services        (Axios con interceptores JWT)
└── composables     (lógica reactiva: validación de formularios, mapa)
```

> **📷 Diagrama requerido — Diagrama de Paquetes Frontend**  
> **Archivo:** `./images/tp-package-frontend.png`  
> **Descripción esperada:** Diagrama UML de paquetes del Frontend Vue.js con los módulos `pages`, `components`, `router`, `store`, `services`, `composables`, `utils`, `assets` y sus dependencias internas.

![Diagrama de Paquetes Frontend](./images/tp-package-frontend.png)

<a id="sec-10-5"></a>
### 10.5 Vista de Procesos

La vista de procesos muestra los flujos de interacción dinámica entre los elementos del sistema durante la ejecución de casos de uso.

<a id="sec-10-5-1"></a>
#### 10.5.1 Diagrama de Secuencia — Backend (Transacción general)

El diagrama de secuencia es una representación dinámica del comportamiento del sistema que muestra la interacción entre objetos o componentes a lo largo del tiempo para llevar a cabo un escenario específico. Las llamadas entre participantes se representan como flechas horizontales ordenadas verticalmente según la cronología, lo que permite visualizar el flujo completo de una operación: desde la solicitud inicial hasta la respuesta final. Su motivación es complementar la vista estática (clases, componentes, paquetes) con una vista del **comportamiento en ejecución**, esencial para diseñar transacciones, validar reglas de negocio, identificar puntos de fallo y dimensionar los tiempos de respuesta. En Tree Pruning se documentan dos diagramas de secuencia transversales (uno del Backend y uno del Frontend) que aplican como patrón a la mayoría de operaciones del sistema, complementados con un diagrama de colaboración del caso de uso *Registro de Poda Ejecutada* en la sección 10.5.3.

| Participante | Descripción |
|---|---|
| Frontend | Cliente que envía la petición HTTP al API Gateway |
| Controller | Adaptador primario REST validado por Spring Security |
| DTO | Objeto de transferencia de datos para entrada/salida del API |
| Interactor | Orquesta el flujo hacia el caso de uso |
| Domain | Modelo de dominio con entidades y reglas de negocio |
| Use Case | Lógica transaccional específica del módulo |
| Validator | Aplica reglas de negocio antes de persistir |
| Entity | Representación JPA con tipos PostGIS |
| Repository | Puerto de acceso a PostgreSQL con Spring Data JPA |

| Paso | Origen | Destino | Descripción |
|---|---|---|---|
| 1 | Frontend | Controller | Solicitud HTTP con token JWT. Spring Security valida el token |
| 2 | Controller | DTO | Validación y transformación de la entrada |
| 3 | DTO | Controller | DTO validado retornado |
| 4 | Controller | Interactor | Invocación del interactor con el DTO |
| 5 | Interactor | Domain | Conversión del DTO a objeto de dominio |
| 6 | Domain | Interactor | Objeto de dominio preparado para el caso de uso |
| 7 | Interactor | Use Case | Invocación del caso de uso transaccional |
| 8 | Use Case | Validator | Validación de reglas de negocio específicas del módulo |
| 9 | Validator | Use Case | Confirmación o excepción de negocio |
| 10 | Use Case | Entity | Conversión del dominio a entidad JPA con tipos PostGIS |
| 11 | Entity | Use Case | Entidad validada y lista para persistir |
| 12 | Use Case | Repository | Operación CRUD dentro de la transacción activa |
| 13 | Use Case | Spring Events | Publicación asíncrona del evento de auditoría |
| 14 | Repository | Use Case | Resultado de la operación CRUD |
| 15 | Use Case | Controller | DTO de respuesta |
| 16 | Controller | Frontend | Respuesta HTTP con el resultado |

> **📷 Diagrama requerido — Diagrama de Secuencia Backend**  
> **Archivo:** `./images/tp-sequence-backend.png`  
> **Descripción esperada:** Diagrama UML de secuencia mostrando los 16 pasos de la transacción general del Backend con líneas de vida para Frontend, Controller, DTO, Interactor, Domain, Use Case, Validator, Entity, Repository y Spring Events. Marcar la transacción `@Transactional` con un frame.

![Diagrama de Secuencia Backend](./images/tp-sequence-backend.png)

<a id="sec-10-5-2"></a>
#### 10.5.2 Diagrama de Secuencia — Frontend (Transacción general)

| Participante | Descripción |
|---|---|
| Usuario (UI) | Actor que interactúa con la interfaz |
| Router | Gestiona navegación y verifica rol antes de renderizar |
| Pages | Pantallas principales por módulo |
| Components | Componentes Bootstrap reutilizables |
| Composables | Lógica reactiva: validación y mapa |
| Store (Pinia) | Estado global: token JWT, rol, módulos habilitados |
| Services (Axios) | Comunicación HTTPS con el API Gateway |
| API Gateway | Punto de entrada del Backend |

| Paso | Origen | Destino | Descripción |
|---|---|---|---|
| 1 | Usuario (UI) | Router | Navegación a una ruta. Router verifica rol en Store |
| 2 | Router | Pages | Autorización y renderizado de la página |
| 3 | Pages | Components | Ensamblaje de componentes del formulario o tabla |
| 4 | Pages | Composables | Inicialización de lógica de validación y handlers |
| 5 | Usuario (UI) | Components | Interacción con el formulario |
| 6 | Components | Composables | Validación reactiva con mensajes inline |
| 7 | Composables | Services | Invocación del servicio Axios con datos validados |
| 8 | Services | Store | Interceptor obtiene el token JWT del Store |
| 9 | Services | API Gateway | Solicitud HTTPS con token JWT en el header |
| 10 | API Gateway | Services | Respuesta del Backend |
| 11 | Services | Composables | Resultado procesado |
| 12 | Composables | Components | Notificación Bootstrap al usuario |
| 13 | Components | Pages | Actualización de la vista con datos más recientes |

> **📷 Diagrama requerido — Diagrama de Secuencia Frontend**  
> **Archivo:** `./images/tp-sequence-frontend.png`  
> **Descripción esperada:** Diagrama UML de secuencia con líneas de vida para Usuario (UI), Router, Pages, Components, Composables, Store (Pinia), Services (Axios) y API Gateway. Mostrar los 13 pasos del flujo general de una transacción del Frontend, incluyendo la inyección del token JWT vía interceptor.

![Diagrama de Secuencia Frontend](./images/tp-sequence-frontend.png)

<a id="sec-10-5-3"></a>
#### 10.5.3 Diagrama de Colaboración — Registro de Poda Ejecutada

El diagrama de colaboración muestra las mismas interacciones del diagrama de secuencia desde una perspectiva centrada en las relaciones entre objetos, enfatizando los enlaces estructurales que sustentan la conversación entre componentes. Para Tree Pruning se modela la colaboración del caso de uso CU-POD-004 (Registrar Ejecución de Poda).

| Vínculo | Origen | Destino | Mensaje | Notas |
|---|---|---|---|---|
| 1 | Encargado (UI) | PodasController | `POST /podas/{id}/ejecutar` con JWT | Vue + Axios |
| 1.1 | PodasController | PodaInteractor | `marcarEjecutada(podaId, dto)` | Adaptador primario |
| 1.1.1 | PodaInteractor | PodaUseCase | `ejecutar(podaId, fechaEjecutada, herramientas, foto)` | Caso de uso transaccional |
| 1.1.1.1 | PodaUseCase | PodaValidator | `validarEjecucion(poda, dto)` | RN-BIZ-004, RN-BIZ-005 |
| 1.1.1.2 | PodaUseCase | MinioAdapter | `subirEvidencia(foto)` → URL | Puerto de salida |
| 1.1.1.3 | PodaUseCase | PodaRepository | `actualizar(poda)` | JPA + transacción |
| 1.1.1.4 | PodaUseCase | SpringEvents | `publish(PodaEjecutada)` | Asíncrono |
| 1.1.1.4.1 | NotificacionListener | FcmAdapter | `enviarPush(destinatarios, mensaje)` | Listener evento |
| 1.1.1.4.2 | AuditoriaListener | AuditoriaRepository | `registrar(evento)` | Listener evento |
| 1.1.2 | PodaInteractor | PodasController | `PodaDTO` | Respuesta |
| 2 | PodasController | Encargado (UI) | `200 OK` con DTO | Mensaje Bootstrap de éxito |

La numeración decimal explicita la profundidad de la llamada y permite observar que los listeners de eventos (`NotificacionListener`, `AuditoriaListener`) operan en paralelo a la respuesta al cliente, lo que sostiene la decisión de desacoplar la trazabilidad y las notificaciones de la transacción principal de negocio.

> **📷 Diagrama requerido — Diagrama de Colaboración CU-POD-004**  
> **Archivo:** `./images/tp-collaboration-pod004.png`  
> **Descripción esperada:** Diagrama UML de colaboración del caso de uso "Registrar Ejecución de Poda" con los objetos Encargado(UI), PodasController, PodaInteractor, PodaUseCase, PodaValidator, MinioAdapter, PodaRepository, SpringEvents, NotificacionListener, FcmAdapter, AuditoriaListener, AuditoriaRepository. Numerar los mensajes con la convención decimal (1, 1.1, 1.1.1, 1.1.1.1, etc.).

![Diagrama de Colaboración](./images/tp-collaboration-pod004.png)

<a id="sec-10-6"></a>
### 10.6 Vista Física / Vista de Implantación

La vista física muestra el mapeo de los componentes de software sobre la infraestructura de hardware y red donde se despliegan.

<a id="sec-10-6-1"></a>
#### 10.6.1 Diagrama de Despliegue

**Infraestructura:**

> **📷 Diagrama requerido — Diagrama de Despliegue UML**  
> **Archivo:** `./images/tp-deployment-diagram.png`  
> **Descripción esperada:** Diagrama UML de despliegue mostrando los nodos físicos: navegador del cliente, internet con Cloudflare, Azure VM (Standard_B4ms) con todos los contenedores Docker (tp-traefik, tp-frontend, tp-kong, tp-keycloak, tp-strapi, tp-minio, tp-grafana, tp-sonarqube, tp-prometheus, tp-config-server, tp-backend, pg1, tp-redis), y los servicios SaaS externos (Infisical, Firebase, Google Maps, GitHub Actions, reCAPTCHA). Indicar protocolos y puertos.

![Diagrama de Despliegue UML](./images/tp-deployment-diagram.png)

```
Internet
  └── Cloudflare (WAF + CDN + DNS)
        └── Azure VM: vm-treepruning (Standard_B4ms, Ubuntu 22.04)
              IP pública: 20.118.241.158
              Dominio: treepruning.org
              │
              └── Docker Compose (red: treepruning-net)
                    ├── tp-traefik (traefik:v2.11) [80:80, 443:443]
                    │     SSL: Let's Encrypt vía Cloudflare DNS
                    │     Enruta: *.treepruning.org → contenedores
                    │
                    ├── tp-frontend (nginx:alpine) [80 interno]
                    │     Dominio: treepruning.org
                    │
                    ├── tp-kong (kong:3.7-ubuntu) [8000, 8001]
                    │     Dominio: api.treepruning.org
                    │     BD: PostgreSQL → kong
                    │
                    ├── tp-keycloak (keycloak:24.0) [8180]
                    │     Dominio: auth.treepruning.org
                    │     BD: PostgreSQL → keycloak
                    │
                    ├── tp-strapi (node:20-alpine) [1337]
                    │     Dominio: cms.treepruning.org
                    │     BD: PostgreSQL → strapi
                    │
                    ├── tp-minio (minio:latest) [9000, 9001]
                    │     Dominios: s3.treepruning.org, console.treepruning.org
                    │
                    ├── tp-grafana (grafana:11.0.0) [3000]
                    │     Dominio: grafana.treepruning.org
                    │     DataSource: tp-prometheus
                    │
                    ├── tp-sonarqube (sonarqube:10-community) [9010]
                    │     Dominio: sonar.treepruning.org
                    │     BD: PostgreSQL → sonarqube
                    │
                    ├── tp-prometheus (prom/prometheus) [9090]
                    │     Scrapea: tp-backend:8080/actuator/prometheus
                    │
                    ├── tp-config-server [8888]
                    │     Monta: ./docker/config-repo/treepruning.yml
                    │
                    ├── pg1 (postgres:16) [5432 interno]
                    │     Volumen: pg1_pgdata
                    │     BDs: treeprunning, kong, keycloak, strapi, sonarqube
                    │
                    └── tp-redis (redis:7-alpine) [6379 interno]
                          Caché de puntos georreferenciados

Servicios externos (SaaS — sin contenedor):
  ├── Infisical (app.infisical.com) — gestión de secretos
  ├── Firebase Cloud Messaging — notificaciones push
  ├── Google Maps Platform — mapas interactivos
  ├── GitHub Actions — CI/CD pipeline
  └── Google reCAPTCHA v3 — validación anti-bot
```

**CI/CD Pipeline:**

```
Developer PC
  └── git push → github.com/doo-dgm/Tree-Pruning
        │
        ├── .github/workflows/deploy-frontend.yml
        │     trigger: paths frontend/**
        │     steps: checkout → Infisical secrets → npm build
        │          → Docker build → GHCR push → SSH deploy → restart
        │
        └── .github/workflows/deploy-backend.yml
              trigger: paths backend/**
              steps: checkout → Infisical secrets → Java 26 setup
                   → mvn package → Docker build → GHCR push
                   → SSH deploy → docker run con variables
```

**Gestión de Secretos:**

```
Infisical SaaS (app.infisical.com)
  Project: tree-pruning-fb-tx
  Environment: dev
  Secrets: POSTGRES_USER, POSTGRES_PASSWORD, POSTGRES_DB,
           REDIS_PASSWORD, KEYCLOAK_ADMIN_USER, KEYCLOAK_ADMIN_PASSWORD,
           MINIO_ROOT_USER, MINIO_ROOT_PASSWORD, STRAPI_JWT_SECRET,
           STRAPI_ADMIN_JWT_SECRET, STRAPI_APP_KEYS, GRAFANA_PASSWORD,
           SERVER_IP, CF_DNS_API_TOKEN, PUBLIC_URL
  
  Machine Identities:
    ├── vm-azure-treepruning (Universal Auth) → acceso desde VM vía CLI
    └── github-actions-treepruning (Universal Auth) → acceso desde GitHub Actions
```

> **📷 Diagrama complementario — Pipeline CI/CD**  
> **Archivo:** `./images/tp-cicd-pipeline.png`  
> **Descripción esperada:** Diagrama del flujo CI/CD: developer push → GitHub → GitHub Actions (jobs paralelos: deploy-frontend, deploy-backend) → build Docker → GHCR push → SSH deploy a la VM Azure → docker run con variables de Infisical.

![Pipeline CI/CD](./images/tp-cicd-pipeline.png)

> **📷 Diagrama complementario — Flujo de Gestión de Secretos**  
> **Archivo:** `./images/tp-secrets-flow.png`  
> **Descripción esperada:** Flujo de cómo los secretos circulan desde Infisical SaaS hacia (1) la VM Azure vía CLI usando la Machine Identity `vm-azure-treepruning`, y hacia (2) los workflows de GitHub Actions usando `github-actions-treepruning`. Indicar la expiración de tokens cada 30 días.

![Flujo de Gestión de Secretos](./images/tp-secrets-flow.png)

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-11"></a>
## 11. Anexos

Los siguientes anexos complementan los escenarios de atributos de calidad priorizados en la sección 3.3. Son referenciados directamente desde los escenarios ESC-CAL-REN-0002, ESC-CAL-REN-0003, ESC-CAL-SEG-0005 y ESC-CAL-DIS-0001.

<a id="sec-anexo-a"></a>
### Anexo A — Matriz de Tiempos por Operación

La Matriz de Tiempos define los tiempos máximos de respuesta aceptables para cada operación del sistema, clasificados por tipo de operación y módulo. Es el criterio de medición de los escenarios de rendimiento ESC-CAL-REN-0002 y ESC-CAL-REN-0003.

**Clasificación UX de tiempos:**

| Categoría | Rango | Percepción del usuario |
|---|---|---|
| Instantáneo | < 300 ms | Sin percepción de espera |
| Rápido | 300 – 750 ms | Respuesta inmediata aceptable |
| Aceptable | > 750 ms | Perceptible; requiere indicador de carga |

**Tiempos por módulo y operación:**

| Módulo | Operación | Tipo | Tiempo UX (ms) |
|---|---|---|---|
| **Usuarios** | Crear usuario | Escritura | 600 |
| | Ver usuarios | Lectura | 300 |
| | Editar usuario | Escritura | 600 |
| | Eliminar usuario | Eliminación | 450 |
| | Cambiar rol de usuario | Escritura | 450 |
| | Activar / Desactivar usuario | Escritura | 300 |
| **Cuadrillas** | Crear cuadrilla | Escritura | 600 |
| | Ver cuadrillas | Lectura | 300 |
| | Editar cuadrilla | Escritura | 600 |
| | Eliminar cuadrilla | Eliminación | 450 |
| | Asignar integrantes | Escritura | 750 |
| **Herramientas** | Registrar herramienta | Escritura | 600 |
| | Ver herramientas | Lectura | 300 |
| | Editar herramienta | Escritura | 600 |
| | Eliminar herramienta | Eliminación | 450 |
| | Asignar herramienta a cuadrilla | Escritura | 525 |
| **Podas** | Registrar poda | Escritura | 900 |
| | Ver podas | Lectura | 450 |
| | Editar poda | Escritura | 750 |
| | Eliminar poda | Eliminación | 450 |
| | Cambiar estado de poda | Escritura | 300 |
| **PQR** | Crear PQR | Escritura | 750 |
| | Ver PQR | Lectura | 450 |
| | Editar PQR | Escritura | 600 |
| | Eliminar PQR | Eliminación | 450 |
| | Cambiar estado de PQR | Escritura | 300 |
| | Responder PQR | Escritura | 600 |
| **Árboles** | Registrar árbol | Escritura | 1050 |
| | Ver árboles | Lectura | 600 |
| | Editar árbol | Escritura | 750 |
| | Eliminar árbol | Eliminación | 450 |
| | Ver historial de árbol | Lectura | 750 |
| **Familias** | Crear familia | Escritura | 450 |
| | Ver familias | Lectura | 225 |
| | Editar familia | Escritura | 450 |
| | Eliminar familia | Eliminación | 450 |
| **Países** | Ver países | Lectura | 150 |
| | Editar país | Escritura | 450 |
| **Departamentos** | Ver departamentos | Lectura | 150 |
| | Editar departamento | Escritura | 450 |
| **Sectores** | Crear sector | Escritura | 600 |
| | Ver sectores | Lectura | 300 |
| | Editar sector | Escritura | 600 |
| **Configuración** | Ver configuración general | Lectura | 225 |
| | Editar configuración general | Escritura | 600 |
| | Gestionar notificaciones | Escritura | 450 |
| **Reportes** | Ver reportes básicos | Lectura | 1200 |
| | Ver reportes avanzados | Lectura | 2250 |
| | Exportar reportes | Proceso | 3000 |

<a id="sec-anexo-b"></a>
### Anexo B — Matriz de Permisos por Rol

La Matriz de Permisos define las acciones habilitadas para cada rol del sistema (Administrador, Encargado de Cuadrilla, Ciudadano). Es el referente de implementación del control de acceso RBAC y el criterio de validación del escenario ESC-CAL-SEG-0005.

**Convención:** S = Permitido · N = No permitido

| Módulo | Acción | Administrador | Encargado | Ciudadano |
|---|---|---|---|---|
| **Usuarios** | Crear usuario | S | N | N |
| | Ver usuarios | S | N | N |
| | Editar usuario | S | N | N |
| | Eliminar usuario | S | N | N |
| | Cambiar rol de usuario | S | N | N |
| | Activar / Desactivar usuario | S | N | N |
| **Cuadrillas** | Crear cuadrilla | S | S | N |
| | Ver cuadrillas | S | S | N |
| | Editar cuadrilla | S | S | N |
| | Eliminar cuadrilla | S | N | N |
| | Asignar integrantes | S | S | N |
| **Herramientas** | Registrar herramienta | S | S | N |
| | Ver herramientas | S | S | N |
| | Editar herramienta | S | S | N |
| | Eliminar herramienta | S | N | N |
| | Asignar herramienta a cuadrilla | S | S | N |
| **Podas** | Registrar poda | S | S | N |
| | Ver podas | S | S | N |
| | Ver poda relacionada a la PQR del usuario | S | S | S |
| | Editar poda | S | S | N |
| | Eliminar poda | S | N | N |
| | Cambiar estado de poda | S | S | N |
| **PQR** | Crear PQR | S | S | S |
| | Ver PQR | S | S | N |
| | Ver PQR creada por el usuario | S | S | S |
| | Editar PQR | S | S | N |
| | Cambiar estado de PQR | S | S | N |
| | Responder PQR | S | S | N |
| **Árboles** | Registrar árbol | S | S | N |
| | Ver árboles | S | S | N |
| | Editar árbol | S | S | N |
| | Eliminar árbol | S | N | N |
| | Ver historial de árbol | S | S | N |
| **Familias de Árboles** | Crear familia | S | N | N |
| | Ver familias | S | S | N |
| | Editar familia | S | S | N |
| | Eliminar familia | S | N | N |
| **Países** | Ver países | S | S | S |
| | Editar país | S | N | N |
| **Departamentos** | Ver departamentos | S | S | S |
| | Editar departamento | S | N | N |
| **Sectores** | Crear sector | S | N | N |
| | Ver sectores | S | S | S |
| | Editar sector | S | S | N |
| **Configuración** | Ver configuración general | S | S | N |
| | Editar configuración general | S | N | N |
| | Gestionar notificaciones | S | S | N |
| **Reportes** | Ver reportes básicos | S | S | N |
| | Ver reportes avanzados | S | N | N |
| | Exportar reportes | S | S | N |

<a id="sec-anexo-c"></a>
### Anexo C — Disponibilidad y SLA

Este anexo define los objetivos de disponibilidad, las ventanas de mantenimiento y la clasificación de incidentes del sistema. Es el referente de medición del escenario ESC-CAL-DIS-0001.

#### C.1 Objetivo de Disponibilidad

Asegurar que el sistema se encuentre disponible y responda correctamente a las solicitudes de los usuarios, garantizando la continuidad operativa sin interrupciones no planificadas. El sistema operará como una unidad única, por lo que la disponibilidad aplica de forma uniforme a todos los módulos.

#### C.2 Métrica de Disponibilidad

| Indicador | Valor | Equivalencia anual | Equivalencia mensual | Observación |
|---|---|---|---|---|
| Disponibilidad objetivo | 99.5 % | ≤ 43.8 horas de downtime/año | ≤ 3.6 horas de downtime/mes | Aplica a todos los módulos |
| Cómputo de downtime | 24h / 365 días | — | — | Se cuenta todo el tiempo, incluyendo horario nocturno y fines de semana |

#### C.3 Horarios de Operación y Mantenimiento

| Franja | Horario | Días | Criticidad | Acción permitida |
|---|---|---|---|---|
| Horario laboral | 6:00 AM – 6:00 PM | Lunes a viernes | Crítico | Sin mantenimiento. Solo monitoreo. |
| Noche entre semana | 10:00 PM – 5:00 AM | Lunes a viernes | Moderado | Mantenimiento programado permitido (máx. 2 horas continuas). |
| Fin de semana, día | 6:00 AM – 6:00 PM | Sábado y domingo | Moderado | Mantenimiento breve permitido. |
| Fin de semana, noche | 6:00 PM – 6:00 AM | Sábado y domingo | Moderado | Ventana ideal para mantenimiento mayor, migraciones o actualizaciones. |

#### C.4 Clasificación de Incidentes

| Severidad | Descripción | Detección máx. | Resolución máx. | Notificación |
|---|---|---|---|---|
| **P1 — Crítico** | Sistema completamente caído en horario laboral (6AM–6PM) | 5 min | 1 hora | Inmediata al equipo técnico |
| **P2 — Alto** | Módulo caído o error generalizado en horario laboral | 10 min | 2 horas | Dentro de 15 min al administrador |
| **P3 — Medio** | Degradación de rendimiento o fallo en módulo secundario | 30 min | 4 horas | Dentro de 1 hora al administrador |
| **P4 — Bajo** | Cualquier fallo ocurrido fuera del horario laboral | 2 horas | 8 horas | Al inicio del siguiente día hábil |

---


[ Volver a la tabla de contenido](#toc)

<a id="sec-12"></a>
## 12. Índice de Imágenes Requeridas

Esta sección resume todas las imágenes que deben colocarse en la carpeta `./images/` para que el documento renderice completo. Permite al equipo verificar qué diagramas faltan por elaborar.

| # | Sección | Archivo | Tipo |
|---|---|---|---|
| 1 | 5. Modelo de Contexto | `tp-context-model.png` | Diagrama de Contexto |
| 2 | 6. Arquetipo de Solución | `tp-archetype.png` | Diagrama agnóstico |
| 3 | 7. Arquitectura de Solución | `tp-solution-architecture.png` | Diagrama con tecnologías |
| 4 | 10.1 Modelo de Contextos Acotados | `tp-bounded-contexts.png` | Bounded Contexts |
| 5 | 10.1 Mapeo de Contextos | `tp-context-mapping.png` | Context Mapping |
| 6 | 10.1 Caracterización de Dominio | `tp-domain-class-diagram.png` | Diagrama de Clases del Dominio |
| 7 | 10.1 Event Storming | `tp-event-storming.png` | Event Storming |
| 8 | 10.1 CU Módulo Administración | `tp-uc-admin.png` | Diagrama de CU |
| 9 | 10.1 CU Módulo Inventario | `tp-uc-inventario.png` | Diagrama de CU |
| 10 | 10.1 CU Módulo Podas | `tp-uc-podas.png` | Diagrama de CU |
| 11 | 10.1 CU Módulo PQR | `tp-uc-pqr.png` | Diagrama de CU |
| 12 | 10.1 CU Módulo Reportes | `tp-uc-reportes.png` | Diagrama de CU |
| 13 | 10.1 CU Módulo Transversal | `tp-uc-transversal.png` | Diagrama de CU |
| 14 | 10.1 CU-12 Registrar PQR | `tp-cu-12-actividades.png` | Diagrama de actividades |
| 15 | 10.1 CU-12 Estados PQR | `tp-cu-12-estados.png` | Diagrama de estados |
| 16 | 10.1 CU-13 Consultar PQR | `tp-cu-13-actividades.png` | Diagrama de actividades |
| 17 | 10.1 CU-14 Actualizar PQR | `tp-cu-14-actividades.png` | Diagrama de actividades |
| 18 | 10.1 CU-15 Generar Reportes | `tp-cu-15-actividades.png` | Diagrama de actividades |
| 19 | 10.1 CU-16 Dashboard | `tp-cu-16-actividades.png` | Diagrama de actividades |
| 20 | 10.1 CU-17 Informes Automáticos | `tp-cu-17-actividades.png` | Diagrama de actividades |
| 21 | 10.1 CU-18 Historial Envíos | `tp-cu-18-actividades.png` | Diagrama de actividades |
| 22 | 10.2 Caja de Producto | `tp-product-box.png` | Imagen de packaging |
| 23 | 10.2 Mapa de Historias | `tp-user-story-map.png` | Mapa de historias |
| 24 | 10.3 Diagrama de Clases UML | `tp-class-diagram-uml.png` | Diagrama de clases UML |
| 25 | 10.3 Diagrama de Objetos | `tp-object-diagram.png` | Diagrama de objetos |
| 26 | 10.4 Componentes | `tp-component-diagram.png` | Diagrama de componentes |
| 27 | 10.4 Paquetes Backend | `tp-package-backend.png` | Diagrama de paquetes |
| 28 | 10.4 Paquetes Frontend | `tp-package-frontend.png` | Diagrama de paquetes |
| 29 | 10.5 Secuencia Backend | `tp-sequence-backend.png` | Diagrama de secuencia |
| 30 | 10.5 Secuencia Frontend | `tp-sequence-frontend.png` | Diagrama de secuencia |
| 31 | 10.5 Colaboración CU-POD-004 | `tp-collaboration-pod004.png` | Diagrama de colaboración |
| 32 | 10.6 Despliegue UML | `tp-deployment-diagram.png` | Diagrama de despliegue |
| 33 | 10.6 Pipeline CI/CD | `tp-cicd-pipeline.png` | Diagrama de flujo |
| 34 | 10.6 Gestión de Secretos | `tp-secrets-flow.png` | Diagrama de flujo |

**Convenciones recomendadas para las imágenes:**

- **Formato:** PNG con fondo blanco o transparente. Resolución mínima recomendada: 1600 px de ancho para garantizar nitidez al imprimir.
- **Herramienta sugerida:** draw.io / diagrams.net para todos los diagramas UML (es gratuito y exporta directamente a PNG). Para Event Storming y Story Mapping, Miro o FigJam con export a PNG.
- **Ubicación:** Todas las imágenes deben guardarse en `./images/` (carpeta hermana del archivo .md), con el nombre exacto indicado en la columna "Archivo".
- **Estilo:** Mantener consistencia visual entre diagramas — paleta sugerida: azul (#2E75B6) para contenedores principales, verde (#70AD47) para servicios externos, gris (#A5A5A5) para componentes de soporte.



[ Volver a la tabla de contenido](#toc)