package org.java.full.stack.spring.io.service;

import java.util.List;
import java.util.Set;

import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.java.full.stack.spring.io.repository.LocalShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private LocalShopRepository repo;

	public LocalShopProduct save(LocalShopProduct p) {
		return repo.getProductRepo().save(p);
	}

	// product
	public List<LocalShopProduct> findAll() {
		return repo.getProductRepo().findAll();
	}

	public Set<LocalShopProduct> findByName(String name) {
		return repo.getProductRepo().findByName(name);
	}

	public LocalShopProduct findById(long id) {
		return repo.getProductRepo().findById(id);
	}
	
	public LocalShopRepository repo() {
		return repo;
	}
}
