FROM openjdk:21-slim

COPY target/*.jar client-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/client-service.jar"]