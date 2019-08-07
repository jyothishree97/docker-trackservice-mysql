FROM openjdk:11
# ENV MYSQL_DATABASE=track
# ENV MYSQL_USER=root_app
# ENV MYSQL_PASSWORD=root@123
# ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/track
ADD ./target/track-service-0.0.1-SNAPSHOT.jar /usr/src/track-service.jar
EXPOSE 8082
WORKDIR usr/src
ENTRYPOINT ["java","-jar","track-service.jar"]

