FROM java:8

COPY build/libs /usr/local

WORKDIR /usr/local

EXPOSE 9090

RUN ["java", "-jar", "motherlan-1.0-SNAPSHOT.jar"]