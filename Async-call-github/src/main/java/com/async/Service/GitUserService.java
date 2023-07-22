package com.async.Service;


import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.async.entity.User;

@Service
public class GitUserService {
	
	private static final  Logger logger=LoggerFactory.getLogger(GitUserService.class);
    
	@Autowired
	 RestTemplate restTemplate;
	
	public CompletableFuture<User> findUser(String user) throws InterruptedException
	{
		logger.info("looking up"+ user);
		System.out.println(Thread.currentThread().getName());
		String url=String.format("https://api.github.com/users/%s", user);
		User results= restTemplate.getForObject(url, User.class);
		//System.out.println(Thread.currentThread().getName());
	    Thread.sleep(1000);
	    return CompletableFuture.completedFuture(results);
	
	
	}
	
}
