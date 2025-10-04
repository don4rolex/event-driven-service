package com.andrew.producerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 */
@Component
public class EventQueueConfig {

  @Value("${event-queues.order-created}")
  private String orderCreatedQueue;


  public String getOrderCreatedQueue() {
    return toQueue(orderCreatedQueue);
  }

  private String toQueue(String channel) {
    return String.format("activemq:%s", channel).toLowerCase();
  }
}
