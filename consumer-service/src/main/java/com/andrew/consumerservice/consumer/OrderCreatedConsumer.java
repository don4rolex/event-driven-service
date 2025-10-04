package com.andrew.consumerservice.consumer;

import com.andrew.consumerservice.config.EventQueueConfig;
import com.andrew.messagedefinition.Order;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 */
@Component
public class OrderCreatedConsumer extends RouteBuilder {

  private final EventQueueConfig eventQueueConfig;

  public OrderCreatedConsumer(EventQueueConfig eventQueueConfig) {
    this.eventQueueConfig = eventQueueConfig;
  }

  @Override
  public void configure() {
    from(eventQueueConfig.getOrderCreatedQueue())
        .unmarshal()
        .protobuf(Order.class.getName())
        .process(this::processOrderCreatedEvent);
  }

  private void processOrderCreatedEvent(Exchange exchange) throws InvalidProtocolBufferException {
    final var event = exchange.getIn().getBody(Order.class);
    final var json = JsonFormat.printer().print(event);
    // Handle business logic related to the received order event
    log.info("Processing order-created event: {}", json);
  }
}