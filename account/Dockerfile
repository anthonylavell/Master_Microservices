#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

#Information around who maintains the image
MAINTAINER anthonylavell

#Add the application's jar to the container
COPY target/account-0.0.1-SNAPSHOT-execute.jar account-0.0.1-SNAPSHOT-execute.jar

#execute the application
ENTRYPOINT ["java","-jar","/account-0.0.1-SNAPSHOT-execute.jar"]