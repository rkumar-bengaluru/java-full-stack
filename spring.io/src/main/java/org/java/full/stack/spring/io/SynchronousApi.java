package org.java.full.stack.spring.io;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Order(value = 4)
@Component
public class SynchronousApi implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	private LocalShopOrder[] getOrders() {
		logger.debug("fetching orders");
		LocalShopOrder[] orders = restTemplate().getForObject("http://localhost:8080/orders", LocalShopOrder[].class);
		return orders;
	}
	
	private LocalShopProduct[] getProducts() {
		logger.debug("fetching products");
		LocalShopProduct[] orders = restTemplate().getForObject("http://localhost:8080/products", LocalShopProduct[].class);
		return orders;
	}
	
	private LocalShopCustomer[] getCustomers() {
		logger.debug("fetching customers");
		LocalShopCustomer[] orders = restTemplate().getForObject("http://localhost:8080/customers", LocalShopCustomer[].class);
		return orders;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("rest template example....");
		LocalShopOrder[] orders = getOrders();
		LocalShopProduct[] products = getProducts();
		LocalShopCustomer[] customers = getCustomers();
		logger.info("recvd orders is : " + orders.length);
		logger.info("recvd products is : " + products.length);
		logger.info("recvd customers is : " + customers.length);
	}

}
