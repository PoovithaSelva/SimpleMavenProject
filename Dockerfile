FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /usr/src
EXPOSE 8080
COPY pom.xml /usr/src
RUN mvn -f pom.xml clean package


FROM openjdk:17
WORKDIR /temp
COPY --from=build /usr/src/*.jar /temp/SimpleMavenProject-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","/temp/SimpleMavenProject-1.0-SNAPSHOT.jar"]