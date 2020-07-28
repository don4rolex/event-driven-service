# Event-Driven Microservices

Set of services for demoing an event-driven architecture.
This project uses 
* Spring Boot
* ActiveMQ as the message broker
* Apache Camel as the Integration tool
* Maven as the build tool

# Build
## What you’ll need
* JDK 14
* ActiveMQ
* Maven 3.5+

## API Usage
1. Download and run the ActiveMQ message broker from https://activemq.apache.org/download.html <br> It should be 
available at `localhost:8161`.
2. Open project in IDE of choice. The project is broken down into different sub-projects.
* `message-definition`: This is the ProtoBuf message definition that is shared between both services.<br>
It is used to enforce strict typing between the services. Run `mvn clean install` generate and install the
 `message-definition.jar` in your local maven repository.
 
* `producer-service`: The producer microservice generates events/messages that are published to the `order-created` queue<br>
You can start this by running `Application.java`.

* `consumer-service`: This service consumes events/messages that were published to the `order-created` queue. <br>
To begin consuming the messages run `Application.java`



