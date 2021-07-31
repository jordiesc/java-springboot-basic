FROM maven:3.8.1-jdk-11 AS mavenbuild
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11
ARG JAR_FILE=/usr/src/app/target/*.jar
COPY --from=mavenbuild ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]