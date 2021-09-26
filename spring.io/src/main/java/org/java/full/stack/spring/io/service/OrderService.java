package org.java.full.stack.spring.io.service;

import java.util.List;

import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.java.full.stack.spring.io.repository.LocalShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private LocalShopRepository repo;

	public LocalShopOrder save(LocalShopOrder order) {
		return repo.getOrderRepo().save(order);
	}

	// order
	public List<LocalShopOrder> findAll() {
		return repo.getOrderRepo().findAll();
	}

	public List<LocalShopOrder> findByName(String name) {
		return repo.getOrderRepo().findByCustomerName(name);
	}

	public LocalShopOrder findById(long id) {
		return repo.getOrderRepo().findById(id);
	}
}
