FROM openjdk:8u212-jre-alpine3.9
WORKDIR usr/folder/practice
ADD target/libs libs
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD testng.xml testng.xml
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBrowser=$browser -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
