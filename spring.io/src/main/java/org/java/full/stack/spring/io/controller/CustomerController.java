package org.java.full.stack.spring.io.controller;

import java.util.List;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.service.CustomerService;
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
@RequestMapping("/customers")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerService svc;

	@GetMapping("")
	public List<LocalShopCustomer> all() {
		return svc.findAll();
	}

	@GetMapping("/{name}")
	public List<LocalShopCustomer> findByName(@PathVariable String name) {
		logger.info("/name->" + name);
		return svc.findByName(name);
	}

	@PostMapping("/create")
	public LocalShopCustomer newEmployee(@RequestBody LocalShopCustomer newProduct) {
		return svc.save(newProduct);
	}

	@GetMapping("/{id}")
	public LocalShopCustomer findById(@PathVariable Long id) {
		return svc.findById(id);
	}

	@PutMapping("/update")
	public LocalShopCustomer update(@RequestBody LocalShopCustomer newProduct) {
		return svc.save(newProduct);
	}

	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable Long id) {
		svc.repo().getProductRepo().deleteById(id);
	}

}
