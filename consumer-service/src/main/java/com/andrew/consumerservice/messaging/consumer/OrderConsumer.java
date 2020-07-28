package com.andrew.consumerservice.messaging.consumer;

import com.andrew.consumerservice.messaging.config.MessageChannelConfig;
import com.andrew.messagedefinition.Order;
import com.google.gson.Gson;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 */
@Component
public class OrderConsumer extends RouteBuilder {

  private final MessageChannelConfig messageChannelConfig;

  public OrderConsumer(MessageChannelConfig messageChannelConfig) {
    this.messageChannelConfig = messageChannelConfig;
  }

  @Override
  public void configure() {
    from(messageChannelConfig.getOrderCreatedChannel())
        .unmarshal().protobuf(Order.class.getName())
        .process(this::processOrderCreatedMessage);
  }

  private void processOrderCreatedMessage(Exchange exchange) {
    final Order message = exchange.getIn().getBody(Order.class);

    //Handle business logic with received order message

    log.info("Consuming order-created message!");
    log.info(new Gson().toJson(message));
  }
}