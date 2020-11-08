package com.nxt.rbmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.nxt.rbmq.config.RabbitMQTopicConfig;

@Service
public class TopicExchangeConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicExchangeConsumer.class);

	@RabbitListener(queues = RabbitMQTopicConfig.QUEUE_MARKETING)
	public void receiveMessageFromTopicMarketing(Message message) {
		LOGGER.info("Consuming Message from Topic Exchange - Queue marketing: " + new String(message.getBody()));
	}

	@RabbitListener(queues = RabbitMQTopicConfig.QUEUE_FINANCE)
	public void receiveMessageFromTopicFinance(Message message) {
		LOGGER.info("Consuming Message from Topic Exchange - Queue finance: " + new String(message.getBody()));
	}

	@RabbitListener(queues = RabbitMQTopicConfig.QUEUE_ALL)
	public void receiveMessageFromTopicAll(Message message) {
		LOGGER.info("Consuming Message from Topic Exchange - Queue all: " + new String(message.getBody()));
	}
}
