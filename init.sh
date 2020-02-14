#!/bin/sh

TECHCON_JDBC_URL=jdbc:mysql://localhost:13306/techcon?useSSL=false ./gradlew server:initializeDB