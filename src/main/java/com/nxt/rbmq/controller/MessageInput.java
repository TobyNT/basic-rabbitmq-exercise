package com.nxt.rbmq.controller;

import javax.validation.constraints.NotBlank;

public class MessageInput {
	@NotBlank(message = "Exchange name must not be blank!")
	private String exchangeName;

	@NotBlank(message = "Exchange name must not be blank!")
	private String routingKey;

	@NotBlank(message = "Message data must not be blank!")
	private String messageData;

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}

}
