FROM adoptopenjdk/openjdk11:latest

RUN mkdir /opt/app
COPY target/spring-boot-tutorial-0.0.1-SNAPSHOT.jar /opt/app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]

