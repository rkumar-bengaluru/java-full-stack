package org.java.full.stack.spring.io.controller;

import java.util.List;

import org.java.full.stack.spring.io.model.Product;
import org.java.full.stack.spring.io.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public String hello() {
		return "hello";
	}

	@GetMapping("/findByName")
	public List<Product> findByName(@RequestParam(value = "name") String name) {
		logger.info("/name->" + name);
		return productService.findByName(name);
	}

	@GetMapping("/findById")
	public Product findById(@RequestParam(value = "id") Long id) {
		logger.info("/findById->" + id);
		return productService.findById(id);
	}

}
