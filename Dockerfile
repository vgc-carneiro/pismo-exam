FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ENV APP_HOME /opt/app

WORKDIR $APP_HOME

ARG JAR_FILE=build/libs/pismo-0.0.1.jar
COPY ${JAR_FILE} app.jar

ARG env=dev
RUN echo $env
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${env}","app.jar"]