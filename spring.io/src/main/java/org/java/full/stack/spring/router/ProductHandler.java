package org.java.full.stack.spring.router;

import org.springframework.stereotype.Component;

@Component
public class ProductHandler {

//	public Mono<ServerResponse> hello(ServerRequest request) {
//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//				.body(BodyInserters.fromValue("Hello, Spring!"));
//	}
//
//	public Mono<ServerResponse> findProduct(ServerRequest request) {
//		Mono<LocalShopProduct3> oneProduct = Mono.just(new LocalShopProduct3("2002", "Yonex 18i"));
//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(oneProduct, LocalShopProduct3.class);
//	}
//
//	public Mono<ServerResponse> findAll(ServerRequest request) {
//		Flux<LocalShopProduct3> all = Flux.just(new LocalShopProduct3("2001", "Apacs Ziggler"),
//				new LocalShopProduct3("2002", "Yonex 18i"));
//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(all, LocalShopProduct3.class);
//	}
}
