FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/loginApp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} loginApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "loginApp.jar"]