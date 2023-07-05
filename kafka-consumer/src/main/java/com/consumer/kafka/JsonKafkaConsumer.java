package com.consumer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.consumer.entity.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "jsondemo", groupId = "consumer1")
	public void jsonConsume(User user)
	{
		LOGGER.info(String.format("message received-> %s", user.toString()));
	}
	
	
}
