package com.async;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.async.Service.GitUserService;
import com.async.entity.User;

@SpringBootApplication
@EnableAsync
public class AsyncCallGithubApplication implements CommandLineRunner{
   private static final Logger logger= LoggerFactory.getLogger(AsyncCallGithubApplication.class);
   
   @Autowired
   GitUserService gitUserService;
   @Bean
   TaskExecutor taskExecutor()
   {
	   ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
	   executor.setCorePoolSize(10);
	   executor.setMaxPoolSize(100);
	   executor.setWaitForTasksToCompleteOnShutdown(true);
	   executor.setThreadNamePrefix("Async-");
	   return executor;
   }
   
   @Bean
   RestTemplate restTemplate()
   {
	   return new RestTemplate();
   }
   
	public static void main(String[] args) {
		SpringApplication.run(AsyncCallGithubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Long start=System.currentTimeMillis();
		
		
		CompletableFuture<User> page1=gitUserService.findUser("PivotalSoftware");
		CompletableFuture<User> page2=gitUserService.findUser("Spring-Projects");
		CompletableFuture<User> page3=gitUserService.findUser("CloudFoundry");
	    CompletableFuture.allOf(page1,page2,page3).join();
		
		
		
		logger.info("Elapsed time:-" + (System.currentTimeMillis()-start));
	    logger.info("--->"+ page1.get());
	    logger.info("--->"+ page2.get());
	    logger.info("--->"+ page3.get());
	
	}

}
