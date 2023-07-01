# Benediction

Simple Kotlin / Spring / Cassandra API for storing & serving page view data without tracking the users. Proof of concept.

## Development

`mvn clean && mvn spring-boot:run`

## Build

Build App Docker image:

`docker-compose build`

Setup Cassandra DB:

`sh scripts/setup-db.sh`

Run app & DB:

`docker-compose up`

## Whats in the name

A benediction is a short invocation for divine help, blessing and guidance. Divine help is what one might need should they wish to do analytics without GDPR acceptances.