package com.kafka.OrderService.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicCreator {
	
	@Bean
	NewTopic newTopic()
	{
		System.out.println("inside topic creator");
		return TopicBuilder.name("order_topics").build();
	}

}
