FROM openjdk:8u212-jre-alpine3.9
RUN apk add curl jq
WORKDIR /usr/folder/practice
ADD target/libs libs
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD testng.xml testng.xml
ADD healthcheck.sh healthcheck.sh
ENTRYPOINT sh healthcheck.sh