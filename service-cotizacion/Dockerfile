FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/service-cotizacion-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8005

ENTRYPOINT ["java","-jar","app.jar"]