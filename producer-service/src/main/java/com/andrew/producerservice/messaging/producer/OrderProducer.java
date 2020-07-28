package com.andrew.producerservice.messaging.producer;

import com.andrew.producerservice.dto.Address;
import com.andrew.producerservice.dto.Order;
import com.andrew.producerservice.messaging.config.MessageChannelConfig;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 */
@Component
public class OrderProducer {

  private Logger log = LoggerFactory.getLogger(getClass());

  private final ProducerTemplate producerTemplate;
  private final MessageChannelConfig messageChannelConfig;

  @Autowired
  public OrderProducer(ProducerTemplate producerTemplate, MessageChannelConfig messageChannelConfig) {
    this.producerTemplate = producerTemplate;
    this.messageChannelConfig = messageChannelConfig;
  }

  public void publishOrderCreatedMessage(Order order) {
    final var message = toProtoBufOrder(order);

    log.info("Producing order-created ProtoBuf message!");

    producerTemplate.sendBody(messageChannelConfig.getOrderCreatedChannel(), message.toByteArray());
  }

  private com.andrew.messagedefinition.Order toProtoBufOrder(Order order) {
    return com.andrew.messagedefinition.Order.newBuilder()
        .setItemId(order.getItemId())
        .setQuantity(order.getQuantity())
        .setShippingAddress(toProtoBufAddress(order.getShippingAddress()))
        .build();
  }

  private com.andrew.messagedefinition.Address toProtoBufAddress(Address address) {
    return com.andrew.messagedefinition.Address.newBuilder()
        .setStreet(address.getStreet())
        .setStreetNumber(address.getStreetNumber())
        .setCity(address.getCity())
        .setPostalCode(address.getPostalCode())
        .setCountry(address.getCountry())
        .build();
  }
}
