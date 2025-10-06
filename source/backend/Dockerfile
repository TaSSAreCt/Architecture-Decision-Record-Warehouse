FROM maven AS build

WORKDIR /app

COPY . .

RUN mvn -f pom.xml clean package -DskipTests

FROM openjdk:25-jdk

WORKDIR /app

COPY --from=build /app/target/backend-0.0.1.jar ./backend-0.0.1.jar

COPY --from=build /app/src/main/resources/application.properties ./application.properties

CMD ["java", "-jar", "backend-0.0.1.jar", "--spring.config.location=application.properties"]
