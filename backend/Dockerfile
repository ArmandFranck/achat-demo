# Image du backend : le jar est construit par Maven (Jenkins) avant "docker build"
FROM eclipse-temurin:17-jre
LABEL maintainer="Franck Armand Djedji"
WORKDIR /app
COPY target/achat.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
