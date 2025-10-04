package com.andrew.producerservice.dto;

/**
 * @author andrew
 */
public record Address(
    String street,
    String streetNumber,
    String city,
    String postalCode,
    String country
) {}
