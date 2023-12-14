FROM openjdk:17-alpine3.12
WORKDIR /app
COPY target/Customers-0.0.1-SNAPSHOT.jar .
CMD ['java','-jar','Customers-0.0.1-SNAPSHOT.jar']