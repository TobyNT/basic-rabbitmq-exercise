package com.nxt.rbmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

	public static final String DEFAULT_EXCHANGE_NAME = "direct-exchange";
	public static final String DEFAULT_QUEUE_NAME = "Private Queue";
	public static final String DEFAULT_ROUTING_KEY = "private";

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Bean
	Queue privateQueue() {
		return new Queue(DEFAULT_QUEUE_NAME, false);
	}

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(DEFAULT_EXCHANGE_NAME);
	}

	@Bean
	Binding privateBinding(Queue privateQueue, DirectExchange exchange) {
		return BindingBuilder.bind(privateQueue).to(exchange).with("private");
	}

}
