package com.andrew.producerservice.dto;

import java.math.BigDecimal;

/**
 * @author andrew
 */
public record Order(
    String itemId,
    String itemName,
    long quantity,
    BigDecimal total,
    Address shippingAddress,
    Address billingAddress
) {}
