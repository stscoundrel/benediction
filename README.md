# Benediction

Simple Kotlin / Spring / Cassandra API for storing & serving page view data without tracking the users.

Proof of concept for personal use. Mainly stores event data & allows queries by projects & time intervals. As far as "tracking" portion is concerned, the data model includes `user_identifier` which may or may not be used. Benediction trusts that the calling client either uses GDRP approved identifier (=hash that can't be turned back to personal data).

## Development

`mvn clean && mvn spring-boot:run`

## Build

Build App Docker image:

`docker-compose build`

Setup Cassandra DB:

`sh scripts/setup-db.sh`

Run app & DB:

`docker-compose up`

## Generate test data for queries

Should you wish to automatically populate your DB with event data, see [Benediction Ritual](https://github.com/stscoundrel/benediction-ritual)

## Whats in the name

A benediction is a short invocation for divine help, blessing and guidance. Divine help is what one might need should they wish to do analytics without GDPR acceptances.
