package org.java.full.stack.spring.router;

import org.java.full.stack.spring.io.model.LocalShopProduct3;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue("Hello, Spring!"));
	}

	public Mono<ServerResponse> findProduct(ServerRequest request) {
		Mono<LocalShopProduct3> oneProduct = Mono.just(new LocalShopProduct3("2002", "Yonex 18i"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(oneProduct, LocalShopProduct3.class);
	}

	public Mono<ServerResponse> findAll(ServerRequest request) {
		Flux<LocalShopProduct3> all = Flux.just(new LocalShopProduct3("2001", "Apacs Ziggler"),
				new LocalShopProduct3("2002", "Yonex 18i"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(all, LocalShopProduct3.class);
	}
}
