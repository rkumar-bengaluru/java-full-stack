package org.java.full.stack.spring.io.cb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class ProductControllerCircuitBreaker {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BookService circuitBreaker;

	@RequestMapping("/cb")
	public Mono<String> toCB() {
		logger.info("circuit breaker controller...");
		return circuitBreaker.fetchAllProducts();
	}
}
