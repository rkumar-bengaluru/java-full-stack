package org.java.full.stack.spring.io.service;

import java.util.List;

import org.java.full.stack.spring.io.model.Product;
import org.java.full.stack.spring.io.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public void save(Product p) {
		productRepo.save(p);
	}

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public List<Product> findByName(String name) {
		return productRepo.findByName(name);
	}

	public Product findById(long id) {
		return productRepo.findById(id);
	}
}
