package com.nxt.rbmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

	public static final String DEFAULT_EXCHANGE_NAME = "direct-exchange";
	public static final String QUEUE_PRIVATE = "direct.privateQueue";
	public static final String QUEUE_PUBLIC = "direct.publicQueue";

	@Bean
	Queue privateQueue() {
		return new Queue(QUEUE_PRIVATE, false);
	}

	@Bean
	Queue publicQueue() {
		return new Queue(QUEUE_PUBLIC, false);
	}

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(DEFAULT_EXCHANGE_NAME);
	}

	@Bean
	Binding privateBinding(Queue privateQueue, DirectExchange exchange) {
		return BindingBuilder.bind(privateQueue).to(exchange).with("private");
	}

	@Bean
	Binding publicBinding(Queue publicQueue, DirectExchange exchange) {
		return BindingBuilder.bind(publicQueue).to(exchange).with("public");
	}
}
