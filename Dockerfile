# Build stage
FROM gradle:8.11-jdk21 AS build
WORKDIR /app

COPY . .

RUN gradle bootJar -x test --no-daemon

# Runtime stage
FROM amazoncorretto:21-alpine-jdk
WORKDIR /

LABEL maintainer="viktoriia.puts@gmail.com"

COPY --from=build /app/build/libs/bachelor-thesis-valkova-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]