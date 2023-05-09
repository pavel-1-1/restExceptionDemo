FROM openjdk:20

EXPOSE 8080

COPY target/authorization-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]