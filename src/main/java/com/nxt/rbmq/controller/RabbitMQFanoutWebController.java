package com.nxt.rbmq.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxt.rbmq.config.RabbitMQFanoutConfig;

@RestController
@RequestMapping(value = "/fanout/")
public class RabbitMQFanoutWebController {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping("/producer")
	public String producer(@RequestBody MessageInput msgInput) {

		amqpTemplate.convertAndSend(RabbitMQFanoutConfig.EXCHANGE_NAME, Strings.EMPTY, msgInput.getMessageData());

		return "Message sent to the RabbitMQ Successfully";
	}
}
