package com.capstone.diary.common;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RabbitMQConfig {

    @Value("${mq.queue-name}")
    private String QUEUE_NAME;

    @Value("${mq.exchange_name}")
    private String EXCHANGE_NAME;

    @Value("${mq.routing-key}")
    private String ROUTING_KEY;



    @Bean
    public Queue testQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public DirectExchange testExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
