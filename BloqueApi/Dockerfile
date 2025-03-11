# Usamos OpenJDK 21
FROM openjdk:21-jdk-slim

# Definimos el directorio de trabajo
WORKDIR /app

#ARG JAR_FILE=target/UsuarioJPARest-1.0.0.jar
# Copiamos el JAR al contenedor
COPY target/UsuarioJPARest-1.0.0.jar app.jar

# Exponemos el puerto de la API
EXPOSE 8089

# Comando para ejecutar la API
ENTRYPOINT ["java", "-jar", "app.jar"]