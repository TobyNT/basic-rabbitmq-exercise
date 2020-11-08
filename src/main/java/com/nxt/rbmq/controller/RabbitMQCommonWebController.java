package com.nxt.rbmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class RabbitMQCommonWebController {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping
	public String producer(@RequestBody MessageInput msgInput) {

		amqpTemplate.convertAndSend(msgInput.getExchangeName(), msgInput.getRoutingKey(), msgInput.getMessageData());

		return "Message sent to the RabbitMQ Successfully";
	}
}
