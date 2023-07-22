package com.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import com.stream.Service.StreamService;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamApplication {
    
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamApplication.class, args);
	}

}
