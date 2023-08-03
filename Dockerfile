FROM maven:3.9.1-eclipse-temurin-8 as builder

COPY . .

RUN mvn -B -DskipTests clean package

############################# FINAL IMAGE #############################

FROM openjdk:8-jdk-alpine

COPY --from=builder *-main/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
