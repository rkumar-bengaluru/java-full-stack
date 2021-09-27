package org.java.full.stack.spring.io.cb;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
public class BookService {

	private static final Logger LOG = LoggerFactory.getLogger(BookService.class);

	private final WebClient webClient;
	private final ReactiveCircuitBreaker readingListCircuitBreaker;

	public BookService(ReactiveCircuitBreakerFactory circuitBreakerFactory) {
		this.webClient = WebClient.builder()
			      .baseUrl("http://localhost:8080")
			      .clientConnector(new ReactorClientHttpConnector(
			        HttpClient.create().responseTimeout(Duration.ofMillis(5000L))
			      ))
			      .build();
		this.readingListCircuitBreaker = circuitBreakerFactory.create("recommended");
	}

	public Mono<String> fetchAllProducts() {
		return readingListCircuitBreaker.run(webClient.get().uri("/products/hangapi").retrieve().bodyToMono(String.class),
				throwable -> {
					LOG.warn("Error making request to book service", throwable);
					return Mono.just("Cloud Native Java (O'Reilly)");
				});
	}
}