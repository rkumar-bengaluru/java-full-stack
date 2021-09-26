package org.java.full.stack.spring.io.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LocalShopRepository {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private CustomerRepository customerRepo;
	
	public ProductRepository getProductRepo() {
		return productRepo;
	}
	public void setProductRepo(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	public OrderRepository getOrderRepo() {
		return orderRepo;
	}
	public void setOrderRepo(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	public void setCustomerRepo(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	public CustomerRepository getCustomerRepo() {
		return customerRepo;
	}

}
