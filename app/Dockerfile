FROM openjdk:8
MAINTAINER com.demo
EXPOSE 8080
ADD target/*.jar /
ADD src/main/resources /resources
ADD entrypoint.sh /entrypoint.sh
ENV PATH /:$PATH
RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh","-jar","app-0.0.1-SNAPSHOT.jar"]
