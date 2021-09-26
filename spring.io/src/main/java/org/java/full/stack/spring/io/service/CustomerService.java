package org.java.full.stack.spring.io.service;

import java.util.List;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.repository.LocalShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private LocalShopRepository repo;

	public LocalShopCustomer save(LocalShopCustomer order) {
		return repo.getCustomerRepo().save(order);
	}

	// order
	public List<LocalShopCustomer> findAll() {
		return repo.getCustomerRepo().findAll();
	}

	public List<LocalShopCustomer> findByName(String name) {
		return repo.getCustomerRepo().findByName(name);
	}

	public LocalShopCustomer findById(long id) {
		return repo.getCustomerRepo().findById(id);
	}

	public LocalShopRepository repo() {
		return repo;
	}
}
