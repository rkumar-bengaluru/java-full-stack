package org.java.full.stack.spring.io;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class CustomerDataInit implements ApplicationRunner {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CustomerService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("ProductDataInit2..................");
		service.save(LocalShopCustomer.createCustomer("Rupak Kumar", "Bangalore"));
		service.save(LocalShopCustomer.createCustomer("Raj Aryan", "Kerala"));
		service.findAll().forEach(e -> {
			System.out.println("customer name -->" + e.getName());
		});
		service.findByName("Rupak").stream().forEach(e -> {
			System.out.println("Customer name -->" + e.getName());
		});;

	}

}
