FROM openjdk:11.0.15-slim-buster
VOLUME /tmp
ARG JAR_FILE
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]