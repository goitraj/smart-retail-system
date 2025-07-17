package com.smartretail.common.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic productEventsTopic() {
        return new NewTopic("product-events", 3, (short) 1);
    }

    @Bean
    public NewTopic orderEventsTopic() {
        return new NewTopic("order-events", 3, (short) 1);
    }

    @Bean
    public NewTopic inventoryEventsTopic() {
        return new NewTopic("inventory-events", 3, (short) 1);
    }

    @Bean
    public NewTopic userEventsTopic() {
        return new NewTopic("user-events", 3, (short) 1);
    }
}