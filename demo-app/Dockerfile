FROM openjdk:8

MAINTAINER com.demo

EXPOSE 8080

ADD target/*.jar /

ADD src/main/resources /resources

ENV PATH /:$PATH
ENTRYPOINT java -jar /demo-app-0.0.1-SNAPSHOT.jar
