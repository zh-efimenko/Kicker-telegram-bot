# Build
FROM openjdk:11-jdk-slim as build
WORKDIR /root/application
COPY . .
RUN ./gradlew clean build installDist

# Image
FROM openjdk:11-jre-slim
WORKDIR /root
COPY --from=build /root/application/build/install /root/

ENTRYPOINT ["/root/kicker-telegram-bot/bin/kicker-telegram-bot"]