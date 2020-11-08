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
	public String producer(@RequestBody String messageData) {

		amqpTemplate.convertAndSend(RabbitMQDirectConfig.DEFAULT_EXCHANGE_NAME,
				RabbitMQDirectConfig.DEFAULT_ROUTING_KEY, messageData);

		return "Message sent to the RabbitMQ Successfully";
	}
}
