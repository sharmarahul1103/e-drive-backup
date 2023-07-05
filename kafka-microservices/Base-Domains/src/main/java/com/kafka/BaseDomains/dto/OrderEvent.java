package com.kafka.BaseDomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
	
	private String msg;
	private String status;
	private String order;
	

}
