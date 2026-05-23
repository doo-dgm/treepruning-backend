# syntax=docker/dockerfile:1.7

# ─── Build stage ─────────────────────────────────────────────────────────────
FROM eclipse-temurin:26-jdk AS build
WORKDIR /app

# Instalar Maven (no usamos el wrapper porque .mvn/ no está versionado).
ARG MAVEN_VERSION=3.9.9
RUN apt-get update \
 && apt-get install -y --no-install-recommends curl ca-certificates \
 && curl -fsSL "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
      | tar -xz -C /opt \
 && ln -s "/opt/apache-maven-${MAVEN_VERSION}/bin/mvn" /usr/local/bin/mvn \
 && rm -rf /var/lib/apt/lists/*

# Cache de dependencias
COPY pom.xml ./
RUN mvn dependency:go-offline -q -B

# Código fuente y build
COPY src ./src
RUN mvn package -DskipTests -q -B

# ─── Runtime stage ───────────────────────────────────────────────────────────
FROM eclipse-temurin:26-jre AS runtime
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
