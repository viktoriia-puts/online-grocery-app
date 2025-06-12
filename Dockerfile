FROM amazoncorretto:21-alpine-jdk
LABEL maintainer="viktoriia.puts@gmail.com"
COPY build/libs/bachelor-thesis-valkova-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
