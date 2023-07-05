package com.kafka.OrderService;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderAppApplication {

	@Autowired
	private NewTopic newTopic;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	   
	
	}

}
