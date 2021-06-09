FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} athentication-service-1.0.0.jar
ENTRYPOINT ["java","-jar","/athentication-service-1.0.0.jar"]