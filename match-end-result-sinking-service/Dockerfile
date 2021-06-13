FROM openjdk:12
EXPOSE 8080
WORKDIR /app
COPY target/match-end-result-sinking-service-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "match-end-result-sinking-service-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=dev" ]