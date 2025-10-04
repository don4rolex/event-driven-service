package com.andrew.producerservice.producer;

import com.andrew.producerservice.dto.Address;
import com.andrew.producerservice.dto.Order;
import com.andrew.producerservice.config.EventQueueConfig;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 */
@Component
public class OrderCreatedProducer {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final ProducerTemplate producerTemplate;
  private final EventQueueConfig eventQueueConfig;

  public OrderCreatedProducer(ProducerTemplate producerTemplate, EventQueueConfig eventQueueConfig) {
    this.producerTemplate = producerTemplate;
    this.eventQueueConfig = eventQueueConfig;
  }

  public void publishOrderCreatedMessage(Order order) {
    final var message = toProtoBufOrder(order);

    log.info("Producing order-created ProtoBuf message!");

    producerTemplate.sendBody(eventQueueConfig.getOrderCreatedQueue(), message.toByteArray());
  }

  private com.andrew.messagedefinition.Order toProtoBufOrder(Order order) {
    return com.andrew.messagedefinition.Order.newBuilder()
        .setItemId(order.itemId())
        .setQuantity(order.quantity())
        .setShippingAddress(toProtoBufAddress(order.shippingAddress()))
        .build();
  }

  private com.andrew.messagedefinition.Address toProtoBufAddress(Address address) {
    return com.andrew.messagedefinition.Address.newBuilder()
        .setStreet(address.street())
        .setStreetNumber(address.streetNumber())
        .setCity(address.city())
        .setPostalCode(address.postalCode())
        .setCountry(address.country())
        .build();
  }
}
