FROM openjdk:17-ea
COPY /build/libs/RCAAgent-0.0.1-SNAPSHOT.jar RCAAgent-0.0.1.jar
ENTRYPOINT ["java","-jar","/RCAAgent-0.0.1.jar"]