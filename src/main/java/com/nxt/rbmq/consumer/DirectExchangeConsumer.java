package com.nxt.rbmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.nxt.rbmq.config.RabbitMQDirectConfig;

@Service
public class DirectExchangeConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(DirectExchangeConsumer.class);

	@RabbitListener(queues = RabbitMQDirectConfig.QUEUE_PRIVATE)
	public void receiveMessageFromPrivate(Message message) {
		LOGGER.info("Consuming message from Direct Exchange - Queue private: " + new String(message.getBody()));
	}
	
	@RabbitListener(queues = RabbitMQDirectConfig.QUEUE_PUBLIC)
	public void receiveMessageFromPublic(Message message) {
		LOGGER.info("Consuming message from Direct Exchange - Queue public: " + new String(message.getBody()));
	}

}
