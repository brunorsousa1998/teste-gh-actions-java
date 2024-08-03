FROM amazoncorretto:17.0.2-alpine

LABEL authors="bruno"

WORKDIR /app

COPY target/todo-0.0.1-SNAPSHOT.jar todo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "todo.jar"]