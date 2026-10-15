-- =============================================================================
-- Tablas de Herramienta, Operario, PodaHerramienta y Administrador
-- =============================================================================
--
-- Crea las cuatro tablas que faltaban para los repositorios agregados en la
-- capa de persistencia. Las otras 18 tablas del modelo ya existen en la base
-- de datos y quedan fuera de este script.
--
-- El proyecto todavia no usa Flyway ni Liquibase, asi que por ahora el script
-- se ejecuta a mano:
--
--   psql -h localhost -U $POSTGRES_USER -d $POSTGRES_DB \
--        -f src/main/resources/db/migration/V1__tablas_herramienta_operario_podaherramienta_administrador.sql
--
-- El nombre sigue la convencion de Flyway para que adoptarlo despues sea
-- directo; en ese caso hay que hacer `flyway baseline` primero, porque el
-- esquema previo no esta versionado.
--
-- Volver a ejecutarlo no falla: los CREATE llevan IF NOT EXISTS. Pero ojo,
-- tampoco modifica una tabla que ya exista: si hay que cambiar un constraint
-- de una tabla ya creada, toca un ALTER aparte.
--
-- Longitudes, obligatoriedad, valores por defecto y combinaciones unicas
-- salen de la caracterizacion en Documentacion_TreePrunning.xlsx, hojas
-- 4.Herramienta_Caract, 4.Operario_Caract, 4.PodaHerramienta_Caract y
-- 4.Administrador_Caract.
-- =============================================================================

BEGIN;

-- -----------------------------------------------------------------------------
-- Herramienta (tool)
--   nombre      : alfanumerico 2-50, obligatorio, no se puede repetir
--   descripcion : alfanumerico 10-200, opcional, por defecto nulo
--
-- El check de descripcion acepta tambien la cadena vacia: TextHelper nunca
-- devuelve null, asi que una herramienta sin descripcion llega como ''.
-- -----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS tool (
    id          uuid         NOT NULL,
    name        varchar(50)  NOT NULL,
    description varchar(200) NULL DEFAULT NULL,
    CONSTRAINT pk_tool PRIMARY KEY (id),
    CONSTRAINT uq_tool_name UNIQUE (name),
    CONSTRAINT ck_tool_name_longitud        CHECK (char_length(btrim(name)) >= 2),
    CONSTRAINT ck_tool_description_longitud CHECK (description IS NULL
                                                   OR btrim(description) = ''
                                                   OR char_length(btrim(description)) >= 10)
);

-- -----------------------------------------------------------------------------
-- Operario (operator)
--   persona   : referencia a Persona, requerido
--   cuadrilla : referencia a Cuadrilla, requerido
--   unica     : una misma persona no se repite como operario en una cuadrilla
--
-- Nota: la celda "Atributos" de la combinacion unica en el Excel dice
-- "tipoDocumento, numeroDocumento, cuadrilla", pero esos no son atributos de
-- Operario (vienen de Persona). Se tomo la descripcion de la combinacion, que
-- si es consistente con el modelo: (persona, cuadrilla).
--
-- OPERATOR es palabra clave en SQL, por eso el nombre va entrecomillado aqui
-- y en @Table(name = "`operator`") de OperatorJPAEntity.
-- -----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS "operator" (
    id           uuid NOT NULL,
    person_id    uuid NOT NULL,
    quadrille_id uuid NOT NULL,
    CONSTRAINT pk_operator PRIMARY KEY (id),
    CONSTRAINT uq_operator_person_quadrille UNIQUE (person_id, quadrille_id),
    CONSTRAINT fk_operator_person
        FOREIGN KEY (person_id)    REFERENCES person (id)    ON DELETE RESTRICT,
    CONSTRAINT fk_operator_quadrille
        FOREIGN KEY (quadrille_id) REFERENCES quadrille (id) ON DELETE RESTRICT
);

CREATE INDEX IF NOT EXISTS idx_operator_person_id    ON "operator" (person_id);
CREATE INDEX IF NOT EXISTS idx_operator_quadrille_id ON "operator" (quadrille_id);

-- -----------------------------------------------------------------------------
-- PodaHerramienta (pruning_tool)
--   poda        : referencia a Poda, requerido
--   herramienta : referencia a Herramienta, requerido
--   unica       : la asociacion poda-herramienta no se registra dos veces
--
-- El RESTRICT sobre tool_id implementa Herramienta-POL-05: no se puede borrar
-- una herramienta que este siendo usada en una poda. El CASCADE sobre
-- pruning_id es una decision nuestra, no sale del Excel: al borrar una poda se
-- borran sus asociaciones con herramientas, que por si solas no significan
-- nada. Cambialo a RESTRICT si prefieres que borrar una poda falle mientras
-- tenga herramientas asociadas.
-- -----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS pruning_tool (
    id         uuid NOT NULL,
    pruning_id uuid NOT NULL,
    tool_id    uuid NOT NULL,
    CONSTRAINT pk_pruning_tool PRIMARY KEY (id),
    CONSTRAINT uq_pruning_tool_pruning_tool UNIQUE (pruning_id, tool_id),
    CONSTRAINT fk_pruning_tool_pruning
        FOREIGN KEY (pruning_id) REFERENCES pruning (id) ON DELETE CASCADE,
    CONSTRAINT fk_pruning_tool_tool
        FOREIGN KEY (tool_id)    REFERENCES tool (id)    ON DELETE RESTRICT
);

CREATE INDEX IF NOT EXISTS idx_pruning_tool_pruning_id ON pruning_tool (pruning_id);
CREATE INDEX IF NOT EXISTS idx_pruning_tool_tool_id    ON pruning_tool (tool_id);

-- -----------------------------------------------------------------------------
-- Administrador (administrator)
--   nombreUsuario     : alfanumerico 2-60, obligatorio, unico
--   correoElectronico : alfanumerico 2-60, obligatorio, unico
--   correoConfirmado  : logico, obligatorio, por defecto falso
--   numeroCelular     : alfanumerico 10-16, obligatorio, unico, dato sensible
--   celularConfirmado : logico, obligatorio, por defecto falso
--
-- Nota: para numeroCelular el Excel marca "Obligatorio = SI" pero tambien
-- "Valor por defecto = NULL", que se contradicen. Se dejo NOT NULL por el
-- obligatorio, que ademas es lo coherente con que sea unico. Si lo que vale
-- es el default, basta con:
--   ALTER TABLE administrator ALTER COLUMN phone DROP NOT NULL;
-- -----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS administrator (
    id              uuid        NOT NULL,
    username        varchar(60) NOT NULL,
    email           varchar(60) NOT NULL,
    email_confirmed boolean     NOT NULL DEFAULT false,
    phone           varchar(16) NOT NULL,
    phone_confirmed boolean     NOT NULL DEFAULT false,
    CONSTRAINT pk_administrator PRIMARY KEY (id),
    CONSTRAINT uq_administrator_username UNIQUE (username),
    CONSTRAINT uq_administrator_email    UNIQUE (email),
    CONSTRAINT uq_administrator_phone    UNIQUE (phone),
    CONSTRAINT ck_administrator_username_longitud CHECK (char_length(username) >= 2),
    CONSTRAINT ck_administrator_email_longitud    CHECK (char_length(email)    >= 2),
    CONSTRAINT ck_administrator_phone_longitud    CHECK (char_length(phone)    >= 10)
);

COMMIT;
