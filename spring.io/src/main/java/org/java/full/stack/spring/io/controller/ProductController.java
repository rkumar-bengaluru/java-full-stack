package org.java.full.stack.spring.io.controller;

import java.util.List;
import java.util.Set;

import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.java.full.stack.spring.io.service.ProductService;
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
@RequestMapping("/products")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<LocalShopProduct> all() {
		return productService.findAll();
	}

	@GetMapping("name/{name}")
	public Set<LocalShopProduct> findByName(@PathVariable String name) {
		logger.info("/name->" + name);
		return productService.findByName(name);
	}

	@PostMapping("/create")
	public LocalShopProduct newEmployee(@RequestBody LocalShopProduct newProduct) {
		logger.debug("product recvd-->" + newProduct.getName());
		return productService.save(newProduct);
	}

	@GetMapping("id/{id}")
	public LocalShopProduct findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@PutMapping("/update")
	public LocalShopProduct update(@RequestBody LocalShopProduct newProduct) {
		return productService.save(newProduct);
	}

	@DeleteMapping("/{id}")	
	public void delete(@PathVariable Long id) {
		productService.repo().getProductRepo().deleteById(id);
	}
	@GetMapping("/hangapi")
	public List<LocalShopProduct> hangapi() {
		logger.info("this api will take 2 minutes to execute");
		try {
			Thread.sleep(120000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productService.findAll();
	}
}
