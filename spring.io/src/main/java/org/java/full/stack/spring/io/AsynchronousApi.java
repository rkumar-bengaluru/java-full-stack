package org.java.full.stack.spring.io;

import java.util.concurrent.CompletableFuture;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 5)
public class AsynchronousApi implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private final AsyncLookupService l;

	public AsynchronousApi(AsyncLookupService gitHubLookupService) {
		this.l = gitHubLookupService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CompletableFuture<LocalShopOrder[]> orders = l.fetchOrders();
		CompletableFuture<LocalShopProduct[]> products = l.fetchProducts();
		l.fetchCustomers();
		CompletableFuture.allOf(orders, products).join();
		logger.info("recvd orders is : " + orders.get().length);
		logger.info("recvd products is : " + products.get().length);
	}

}
