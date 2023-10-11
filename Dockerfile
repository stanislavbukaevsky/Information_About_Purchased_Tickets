FROM maven:3-openjdk-17 AS build
WORKDIR /consumer/
COPY src /consumer/src
COPY /pom.xml /
RUN mvn -f /pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]