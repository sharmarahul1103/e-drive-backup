package com.stream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	
	@GetMapping("test")
	public String test()
	{
		return "this is from test";
	}

}
