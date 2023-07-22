package com.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	
	@Bean
	NewTopic newTopic()
	{
		return TopicBuilder.name("demo")
				
				
				.build();
	}

	@Bean
	NewTopic newJsonTopic()
	{
		return TopicBuilder.name("jsondemo")
				
				.build();
	}
	

}
