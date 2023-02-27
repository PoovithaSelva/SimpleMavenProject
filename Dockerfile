FROM openjdk:17
WORKDIR /temp
COPY /target/SimpleMavenProject-1.0-SNAPSHOT.jar /temp/SimpleMavenProject-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","/temp/SimpleMavenProject-1.0-SNAPSHOT.jar"]