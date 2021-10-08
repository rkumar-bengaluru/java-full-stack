package org.java.full.stack.spring.io;

import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AsyncWebClient {
	private final WebClient client;
	private final String baseUrl = "http://localhost:8080";

	public AsyncWebClient(WebClient.Builder webClientBuilder) {
		this.client = webClientBuilder.baseUrl(baseUrl).build();
	}

	public Mono<LocalShopProduct> findByName(String name) {
		return this.client.get().uri("/name/{name}", name)
				.retrieve().bodyToMono(LocalShopProduct.class);
	}

	public Flux<LocalShopProduct> findAll() {
		Flux<LocalShopProduct> all = this.client.get().uri("/products").retrieve()
				.bodyToFlux(LocalShopProduct.class);
		return all;
	}
}
