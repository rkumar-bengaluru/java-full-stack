package org.java.full.stack.spring.io.controller;

import java.util.List;
import java.util.Set;

import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.java.full.stack.spring.io.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller + @ResponseBody
 * @ResponseBody = Serializes JSON response to response body.
 * 
 * @author Rupak Kumar...
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderService service;

	@GetMapping("")
	public List<LocalShopOrder> all() {
		return service.findAll();
	}

	@PostMapping("/create")
	public LocalShopOrder newEmployee(@RequestBody LocalShopOrder newProduct) {
		return service.save(newProduct);
	}

	@GetMapping("/{id}")
	public LocalShopOrder findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping("/update")
	public LocalShopOrder update(@RequestBody LocalShopOrder newProduct) {
		return service.save(newProduct);
	}
}
