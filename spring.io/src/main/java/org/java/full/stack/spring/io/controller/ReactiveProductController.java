package org.java.full.stack.spring.io.controller;

import org.java.full.stack.spring.io.model.LocalShopProduct2;
import org.java.full.stack.spring.io.model.LocalShopProduct3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

/**
 * 
 * @author Rupak Kumar...
 *
 */
@RestController
@RequestMapping("/reactiveproducts")
public class ReactiveProductController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("")
	public Flux<LocalShopProduct3> all() {
		return Flux.just(new LocalShopProduct3("2001","Apacs Ziggler"),new LocalShopProduct3("2002","Yonex 18i"));
	}

}
