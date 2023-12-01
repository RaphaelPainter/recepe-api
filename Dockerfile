FROM public.ecr.aws/bitnami/java:latest
EXPOSE 8080
ARG JAR_FILE=target/api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
RUN apt-get update
ENTRYPOINT ["java","-jar","/app.jar"]