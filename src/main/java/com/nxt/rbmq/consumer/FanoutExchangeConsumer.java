package com.nxt.rbmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.nxt.rbmq.config.RabbitMQFanoutConfig;

@Service
public class FanoutExchangeConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(FanoutExchangeConsumer.class);

	@RabbitListener(queues = RabbitMQFanoutConfig.QUEUE_ADMIN)
	public void receiveMessageFromFanoutMarketing(Message message) {
		LOGGER.info("Consuming Message from Fanout Exchange - Queue admin: " + new String(message.getBody()));
	}

	@RabbitListener(queues = RabbitMQFanoutConfig.QUEUE_USER)
	public void receiveMessageFromFanoutFinance(Message message) {
		LOGGER.info("Consuming Message from Fanout Exchange - Queue user: " + new String(message.getBody()));
	}

}
