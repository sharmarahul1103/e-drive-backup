package com.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.Service.StreamService;

@RestController
public class KafkaController {
	
	@Autowired
	StreamService streamService;
	
	
	@GetMapping("test")
	public String test()
	{
		streamService.sendMessage();
		return "this is from test";
	}

}
