package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@SpringBootApplication
@EnableCaching
public class RedisDemoApplication {

	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
