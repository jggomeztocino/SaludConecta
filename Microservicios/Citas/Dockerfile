# Construcción del proyecto
FROM gradle:jdk22 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

# Ejecución del proyecto
FROM openjdk:22-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/citas.jar
EXPOSE 8080
CMD ["java", "-jar", "citas.jar"]