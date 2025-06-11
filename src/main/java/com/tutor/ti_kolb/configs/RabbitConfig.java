package com.tutor.ti_kolb.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${kolb.queue.name}")
    private String queueName;

    @Bean
    public Queue kolbTestQueue() {
        return new Queue(queueName, true);
    }
}
