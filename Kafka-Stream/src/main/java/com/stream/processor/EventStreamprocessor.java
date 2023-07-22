package com.stream.processor;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Configuration
public class EventStreamprocessor {
	
	@Autowired
	private StreamsBuilder  streamsBuilder;
	
	
	@PostConstruct
	 void streamTopology()
	{
	KStream<String, String> kstream	=streamsBuilder.stream("UpperCase", Consumed.with(Serdes.String(), Serdes.String()));
	kstream.filter((key, value) -> value.startsWith("Message_"))
	
	.mapValues((k, v) -> v.toUpperCase())
	.peek((key, value) -> System.out.println("key:"+key+"value :"+value ))
	.to("UpperCase",Produced.with(Serdes.String(), Serdes.String()) );
	
	}

}
