FROM adoptopenjdk/openjdk15:latest
VOLUME /tmp
EXPOSE 8080
COPY target/api-1.0.jar /app.jar
ENTRYPOINT exec java -jar /app.jar