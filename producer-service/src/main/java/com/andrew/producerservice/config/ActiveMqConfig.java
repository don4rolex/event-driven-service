package com.andrew.producerservice.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author andrew
 */
@Configuration
public class ActiveMqConfig {

  private static final List<String> TRUSTED_PACKAGES = List.of("com.andrew.messagedefinition", "java.util", "java.lang", "java.time");
  private static final String FORMAT_URL = "tcp://%s:%s";

  @Value("${amq.username}")
  private String username;

  @Value("${amq.password}")
  private String password;

  @Value("${amq.port}")
  private String port;

  @Value("${amq.host}")
  private String host;

  @Bean
  public ActiveMQConnectionFactory activeMQConnectionFactory() {
    final var connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(String.format(FORMAT_URL, host, port));
    connectionFactory.setTrustedPackages(TRUSTED_PACKAGES);
    connectionFactory.setUserName(username);
    connectionFactory.setPassword(password);

    return connectionFactory;
  }
}