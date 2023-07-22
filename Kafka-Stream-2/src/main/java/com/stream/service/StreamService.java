package com.stream.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StreamService {
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage()
	{
		kafkaTemplate.send("check10", "test data");
		System.out.println("message sent");
	}
	
	
	@KafkaListener(topics = "check1")
	public void consume(String msg)
	{
		System.out.println("from consumer: "+msg);
	}

}
