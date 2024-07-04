FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/ConsultasMascotas-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ConsultasMascotas.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ConsultasMascotas.jar"]