package org.java.full.stack.spring.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class ProductRouter {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Bean
	public RouterFunction<ServerResponse> route(ProductHandler greetingHandler) {
		return RouterFunctions
			.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
	}
	
	@Bean
	RouterFunction<ServerResponse> home(ProductHandler handler) {
		RouterFunction<ServerResponse> r =  RouterFunctions.route(GET("/products/findOne"),
				handler::findProduct);
		return r;
	}
	
	@Bean
	RouterFunction<ServerResponse> all(ProductHandler handler) {
		RouterFunction<ServerResponse> r =  RouterFunctions.route(GET("/products/all"),
				handler::findAll);
		return r;
	}
	
	@Bean
	RouterFunction<ServerResponse> nested(ProductHandler handler) {
		RouterFunction<ServerResponse> r =  RouterFunctions.route(GET("/nested/one"),
				handler::findProduct).and(RouterFunctions.route(GET("/nested/all"), handler::findAll));
		return r;
	}

}
