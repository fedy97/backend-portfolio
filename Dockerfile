FROM openjdk:8-jdk

WORKDIR /app

COPY /staging/app.jar /app/project.jar

CMD java -jar project.jar

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=15s --retries=3 CMD curl -f localhost:8080/actuator/health || exit 1