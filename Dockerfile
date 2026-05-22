FROM eclipse-temurin:26-jdk AS build
WORKDIR /app

COPY mvnw ./
COPY .mvn .mvn/
RUN chmod +x mvnw

COPY pom.xml ./
RUN ./mvnw dependency:go-offline -q

COPY src ./src
RUN ./mvnw package -DskipTests -q

FROM eclipse-temurin:26-jre AS runtime
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]
