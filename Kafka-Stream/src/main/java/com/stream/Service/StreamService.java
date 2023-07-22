package com.stream.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class StreamService {

	@Autowired
    KafkaTemplate<String, String> kafkaTemplate;
	
	@PostConstruct
	public  void sendMessage()
	{
		kafkaTemplate.send("sourceTopic", "1", "Message_ first message");
	}
	
	@KafkaListener(topics = "sinkTopic", groupId = "uppercase")
	public void consumer(String msg)
	{
		System.out.println("message received" + msg);
	}
	
}
