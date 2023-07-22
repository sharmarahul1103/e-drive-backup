package com.stream.config;

import java.util.Properties;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import jakarta.annotation.PostConstruct;

@Configuration
public class AppConfig {

	
	
	@Autowired
	KafkaProperties kafkaProperties;
	
	@Bean
	StreamsConfig streamsConfig(KafkaProperties kafkaProperties)
	{
		return new StreamsConfig(kafkaProperties.buildStreamsProperties());
	}

	@Bean
	NewTopic newTopic() {
		return TopicBuilder.name("check10").build();
	}

//	@Bean
//	Properties properties() {
//		Properties props = new Properties();
//		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "test");
//		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//		props.put(StreamsConfig.producerPrefix(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG),
//				"org.apache.kafka.common.serialization.StringSerializer");
//		props.put(StreamsConfig.producerPrefix(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG),
//				"org.apache.kafka.common.serialization.StringSerializer");
//		props.put(StreamsConfig.consumerPrefix(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG),
//				"org.apache.kafka.common.serialization.StringDeserializer");
//		props.put(StreamsConfig.consumerPrefix(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG),
//				"org.apache.kafka.common.serialization.StringDeserializer");
//		props.put(StreamsConfig.consumerPrefix(ConsumerConfig.GROUP_ID_CONFIG), "streams");
//		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//		// props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
//
//		return props;
//	}

	

	

	
	
	
	
	

}
