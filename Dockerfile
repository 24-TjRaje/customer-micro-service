FROM openjdk:17-alpine3.12
COPY target/Customers-0.0.1-SNAPSHOT.jar customer-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/customer-server-1.0.0.jar"]