package com.kafka.EmailService.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.BaseDomains.dto.OrderEvent;

@Service
public class OrderConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "order_topics" ,id = "email" )
	public void consume(OrderEvent orderEvent)
	{
		LOGGER.info(String.format("message received in email->  %s", orderEvent.toString()));
	}
	
}
