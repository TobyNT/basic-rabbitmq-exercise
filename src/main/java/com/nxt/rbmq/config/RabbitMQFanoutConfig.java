package com.nxt.rbmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

	public static final String EXCHANGE_NAME = "fanout-exchange";
	public static final String QUEUE_ADMIN = "fanout.adminQueue";
	public static final String QUEUE_USER = "fanout.userQueue";

	@Bean
	Queue adminQueue() {
		return new Queue(QUEUE_ADMIN, false);
	}

	@Bean
	Queue userQueue() {
		return new Queue(QUEUE_USER, false);
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(EXCHANGE_NAME);
	}

	@Bean
	Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(adminQueue).to(exchange);
	}

	@Bean
	Binding userBinding(Queue userQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(userQueue).to(exchange);
	}

}
