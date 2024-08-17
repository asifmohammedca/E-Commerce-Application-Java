package com.Ecommerce.Payment.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder
                .name("payment-topic")
                .build();
    }
}
