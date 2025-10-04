# Event-Driven Microservices

Set of services for demoing an event-driven architecture.

This project uses
* Spring Boot
* ActiveMQ as the message broker
* Apache Camel as the Integration tool
* Maven as the build tool

# Build

## What you'll need

* JDK 21
* Docker and Docker Compose
* Maven 3.5+

## API Usage

1. Start the ActiveMQ message broker using Docker Compose:
   ```bash
   docker-compose up -d
   ```
   The ActiveMQ web console will be available at `http://localhost:8161` (username: admin, password: admin).

2. The project is broken down into different subprojects.

* `event-definition`: This is the ProtoBuf event definition shared between both services.
  It is used to enforce strict typing between the services. Run `./mvnw clean install` to generate and install the
  `event-definition.jar` in your local maven repository.

* `producer-service`: The producer microservice generates events/messages that are published to the `order-created` queue<br>
  You can start this by running `ProducerApplication.java`.

* `consumer-service`: This service consumes events/messages that were published to the `order-created` queue. <br>
  To begin consuming the messages run `ConsumerApplication.java`



