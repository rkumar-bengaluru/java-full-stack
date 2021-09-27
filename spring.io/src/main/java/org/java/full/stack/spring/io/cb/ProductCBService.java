package org.java.full.stack.spring.io.cb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ProductCBService {
	private static final Logger LOG = LoggerFactory.getLogger(ProductCBService.class);
	@Autowired
	private WebClient webClient;
	@Autowired 
	private RestTemplate restTemplate;
	private CircuitBreakerFactory cbFactory;

	public ProductCBService(CircuitBreakerFactory cbFactory) {
		this.cbFactory = cbFactory;
		this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
	}
	
//	public Mono<String> readingList() {
//	    return cbFactory.create("async").run(webClient.get().uri("/recommended").retrieve().bodyToMono(String.class), throwable -> {
//	      LOG.warn("Error making request to book service", throwable);
//	      return Mono.just("Cloud Native Java (O'Reilly)");
//	    });
//	  }

//	public String fetchAllProducts() {
//		LOG.info("hang api");
//		return cbFactory.create("sync").run(
//				() -> restTemplate.getForObject("http://localhost:8080/products/hangapi", String.class),
//				throwable -> {
//					throwable.printStackTrace();
//					return "fallback function";
//				});
//	}
}
