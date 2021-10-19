#!/bin/bash
# !/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - $HUB_HOST"
# if ready is not true, sleep for 1 second then continue
while [ "$( curl -s $HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
echo "Hub is not ready yet"
	sleep 1
done
# start the java command
echo "Hub ready and starting tests"
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DBROWSER=$BROWSER \
    org.testng.TestNG $MODULE