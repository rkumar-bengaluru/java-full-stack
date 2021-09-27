package org.java.full.stack.spring.io;

import java.time.Duration;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication (scanBasePackages = { "org.java.full.stack.spring.io"})
@ComponentScan(basePackages = {"org.java.full.stack.spring.io"})
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(
	            id -> new Resilience4JConfigBuilder(id)
	            .timeLimiterConfig(TimeLimiterConfig.custom()
	                .timeoutDuration(Duration.ofSeconds(2)).build())
	            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
	            .build());
	}
	
	@Bean
	public WebClient webClient() {
	    return WebClient.builder()
	      .baseUrl("http://localhost:8080")
	      .clientConnector(new ReactorClientHttpConnector(
	        HttpClient.create().responseTimeout(Duration.ofMillis(250))
	      ))
	      .build();
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
