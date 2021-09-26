package org.java.full.stack.spring.io;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication (scanBasePackages = { "org.java.full.stack.spring.io"})
@ComponentScan(basePackages = {"org.java.full.stack.spring.io"})
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public ProductDataInit schedulerRunner() {
        return new ProductDataInit();
    }
	
	@Bean
	  public Executor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(3);
	    executor.setMaxPoolSize(3);
	    executor.setQueueCapacity(500);
	    executor.setThreadNamePrefix("AyncLookupService-");
	    executor.initialize();
	    return executor;
	  }

}
