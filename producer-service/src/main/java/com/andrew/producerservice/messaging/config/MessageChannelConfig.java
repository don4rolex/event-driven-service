package com.andrew.producerservice.messaging.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 */
@Component
public class MessageChannelConfig {

  @Value("${message-channels.order-created}")
  private String orderCreatedChannel;


  public String getOrderCreatedChannel() {
    return toQueue(orderCreatedChannel);
  }

  private String toQueue(String channel) {
    return String.format("activemq:%s", channel).toLowerCase();
  }
}
