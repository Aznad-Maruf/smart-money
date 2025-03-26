FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY build/libs/smart-money-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /config
COPY src/main/resources/application-docker.properties /config/application-docker.properties  

ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

EXPOSE 8080 5005

CMD ["java", "-jar", "app.jar"]
