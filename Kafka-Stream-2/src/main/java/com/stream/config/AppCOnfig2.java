package com.stream.config;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppCOnfig2 {
	
	@Autowired
	StreamsBuilder streamsBuilder;

	@PostConstruct
	 void start()
	{
		KStream<String, String> kStream = streamsBuilder.stream("check10", Consumed.with(Serdes.String(),Serdes.String() ));

		kStream. filter(((key, value)-> value.startsWith("test")))
		 .mapValues((k, v) -> v.toUpperCase())
		 .peek((key,value)-> System.out.print("key"+ key+"value"+ value))
		 .to("check1", Produced.with(Serdes.String(), Serdes.String()));
		
		System.out.println("stream started");
	}

}
