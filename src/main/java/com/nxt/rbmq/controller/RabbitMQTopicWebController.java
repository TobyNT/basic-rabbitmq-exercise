package com.nxt.rbmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxt.rbmq.config.RabbitMQTopicConfig;

@RestController
@RequestMapping(value = "/topic/")
public class RabbitMQTopicWebController {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping("/producer")
	public String producer(@RequestBody MessageInput msgInput) {
		amqpTemplate.convertAndSend(RabbitMQTopicConfig.EXCHANGE_NAME, msgInput.getRoutingKey(),
				msgInput.getMessageData());

		return "Message sent to the RabbitMQ Topic Exchange Successfully";
	}
}
