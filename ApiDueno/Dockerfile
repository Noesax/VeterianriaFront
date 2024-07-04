FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/ApiDueno-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ApiDueno.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ApiDueno.jar"]