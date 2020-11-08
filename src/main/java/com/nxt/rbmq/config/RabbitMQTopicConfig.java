package com.nxt.rbmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

	public static final String EXCHANGE_NAME = "topic-exchange";
	public static final String QUEUE_MARKETING = "topic.marketingQueue";
	public static final String QUEUE_FINANCE = "topic.financeQueue";
	public static final String QUEUE_ALL = "topic.allQueue";

	@Bean
	Queue marketingQueue() {
		return new Queue(QUEUE_MARKETING, false);
	}

	@Bean
	Queue financeQueue() {
		return new Queue(QUEUE_FINANCE, false);
	}

	@Bean
	Queue allQueue() {
		return new Queue(QUEUE_ALL, false);
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	Binding marketingBinding(Queue marketingQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
	}

	@Bean
	Binding financeBinding(Queue financeQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
	}

	@Bean
	Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
	}
}
