package com.streams;

import java.awt.RenderingHints.Key;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("application started");
        Properties props=new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-count");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); 
      //  props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, "0");
        
        
        StreamsBuilder streamsBuilder=new StreamsBuilder();
        KStream<String, String> kStream=streamsBuilder.stream("sourceTopic");
     // kStream.filter(((key, value) -> value.startsWith("Message_")))
     kStream  .flatMapValues((key,value)-> Arrays.asList(value.toUpperCase().split(" ")))
        // .mapValues((key,value)-> value.toUpperCase())
           .groupBy((key, value) -> value )
           .count(Materialized.with(Serdes.String(), Serdes.Long()))
           .toStream()
            .to("sinkTopic", Produced.with(Serdes.String(), Serdes.Long()));
                
                
    
    
        Topology topology=streamsBuilder.build();
        KafkaStreams kafkaStreams=new KafkaStreams(topology, props);
        kafkaStreams.start();
        
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        System.out.println(topology.describe());
       
        
    
    }
}
