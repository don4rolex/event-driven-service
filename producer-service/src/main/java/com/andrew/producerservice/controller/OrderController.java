package com.andrew.producerservice.controller;

import com.andrew.producerservice.dto.Order;
import com.andrew.producerservice.producer.OrderCreatedProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 */
@RestController
public class OrderController {

  private final OrderCreatedProducer orderCreatedProducer;

  public OrderController(OrderCreatedProducer orderCreatedProducer) {
    this.orderCreatedProducer = orderCreatedProducer;
  }

  @PostMapping("/order")
  public void order(@RequestBody Order order) {
    orderCreatedProducer.publishOrderCreatedMessage(order);
  }
}
