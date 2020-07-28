package com.andrew.producerservice.controller;

import com.andrew.producerservice.dto.Order;
import com.andrew.producerservice.messaging.producer.OrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 */
@RestController
public class OrderController {

  private final OrderProducer orderProducer;

  public OrderController(OrderProducer orderProducer) {
    this.orderProducer = orderProducer;
  }

  @PostMapping(value = {"/order"})
  @ResponseStatus(value = HttpStatus.OK)
  public void order(@RequestBody Order order) {
    orderProducer.publishOrderCreatedMessage(order);
  }
}
