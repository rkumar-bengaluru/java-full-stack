package org.java.full.stack.spring.io;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.java.full.stack.spring.io.service.CustomerService;
import org.java.full.stack.spring.io.service.OrderService;
import org.java.full.stack.spring.io.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 3)
public class OrderDataInit implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrderService service;
	@Autowired
	private CustomerService cservice;
	@Autowired
	private ProductService pservice;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		logger.info("ProductDataInit3..................");
		
		cservice.save(LocalShopCustomer.createCustomer("Amrita", "Bangalore"));
		List<LocalShopCustomer> c = cservice.findByName("Amrita");
		Set<LocalShopProduct> p = pservice.findByName("Ziggler");
		
		logger.info("found products :" + p.size());
		logger.info("found customer :" + c.size());
		service.save(LocalShopOrder.createOrder(p, c.get(0)));
		service.findAll().forEach(e -> {
			System.out.println("order customer name ->" +e.getCustomer().getName());
		});
	}

}
