package com.nxt.rbmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxt.rbmq.config.RabbitMQDirectConfig;

@RestController
@RequestMapping(value = "/direct/")
public class RabbitMQDirectWebController {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping("/producer")
	public String producer(@RequestBody MessageInput msgInput) {

		amqpTemplate.convertAndSend(RabbitMQDirectConfig.DEFAULT_EXCHANGE_NAME, msgInput.getRoutingKey(),
				msgInput.getMessageData());

		return "Message sent to the RabbitMQ Successfully";
	}
}
