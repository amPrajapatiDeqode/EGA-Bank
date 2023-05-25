FROM openjdk:8-jdk-alpine
LABEL maintainer="EGA EGA@email.com>"

WORKDIR /app

# Copy the Maven project definition and dependencies
COPY pom.xml .
COPY src ./src


COPY target/docker-message-server-1.0.0.jar message-server-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]