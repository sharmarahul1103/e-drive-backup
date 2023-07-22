package com.stream.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {
	
	@Bean
	StreamsConfig streamsConfig(KafkaProperties kafkaProperties)
	{
		return new StreamsConfig(kafkaProperties.buildStreamsProperties());
	}
	
	@Bean
	NewTopic newTopic()
	{
		return TopicBuilder.name("UpperCase").build();
	}
	
	
	
}
