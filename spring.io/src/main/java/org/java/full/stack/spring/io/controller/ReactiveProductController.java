package org.java.full.stack.spring.io.controller;

import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.java.full.stack.spring.io.model.LocalShopProduct2;
import org.java.full.stack.spring.io.repository.ReactiveProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @RestController = @Controller + @ResponseBody
 * @ResponseBody = Serializes JSON response to response body.
 * 
 * @author Rupak Kumar...
 *
 */
@RestController
@RequestMapping("/rproducts")
public class ReactiveProductController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ReactiveProductRepository reactiveRepository;

	@GetMapping("")
	public Flux<LocalShopProduct2> all() {
		return reactiveRepository.findAll();
	}

	@GetMapping("name/{name}")
	public Flux<LocalShopProduct2> findByName(@PathVariable String name) {
		logger.info("/name->" + name);
		return reactiveRepository.findByName(name);
	}

	@PostMapping("/create")
	public Mono<LocalShopProduct2> newEmployee(@RequestBody LocalShopProduct2 newProduct) {
		logger.debug("product recvd-->" + newProduct.getName());
		return reactiveRepository.save(newProduct);
	}

	@GetMapping("id/{id}")
	public Mono<LocalShopProduct2> findById(@PathVariable Long id) {
		return reactiveRepository.findById(id);
	}

	@PutMapping("/update")
	public Mono<LocalShopProduct2> update(@RequestBody LocalShopProduct2 newProduct) {
		return reactiveRepository.save(newProduct);
	}

	@GetMapping("/hangapi")
	public Flux<LocalShopProduct2> hangapi() {
		logger.info("this api will take 2 minutes to execute");
		try {
			Thread.sleep(120000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reactiveRepository.findAll();
	}
}
