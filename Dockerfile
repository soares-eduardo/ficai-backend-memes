FROM openjdk

WORKDIR /app

COPY target/backend-0.0.1-SNAPSHOT.jar /app/ficai4-backend.jar

ENTRYPOINT [ "java", "-jar", "ficai4-backend.jar" ]