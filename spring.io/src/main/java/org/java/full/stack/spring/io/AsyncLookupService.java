package org.java.full.stack.spring.io;

import java.util.concurrent.CompletableFuture;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class AsyncLookupService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RestTemplate restTemplate;

	@Async
	public CompletableFuture<LocalShopOrder[]> fetchOrders() {
		logger.debug("fetching orders");
		LocalShopOrder[] orders = restTemplate.getForObject("http://localhost:8080/orders", LocalShopOrder[].class);
		try {
			logger.info("waiting 3 sec for orders..." + Thread.currentThread().getName());
			Thread.sleep(5000L);
			logger.info("waiting over 3 sec for orders..." + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(orders);
	}

	@Async
	public CompletableFuture<LocalShopProduct[]> fetchProducts() {
		logger.debug("fetching producst");
		LocalShopProduct[] orders = restTemplate.getForObject("http://localhost:8080/products",
				LocalShopProduct[].class);
		try {
			logger.info("waiting 2 sec for products..." + Thread.currentThread().getName());
			Thread.sleep(3000L);
			logger.info("waiting over 2 sec for products..." + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(orders);
	}

	@Async
	public void fetchCustomers() {
		logger.debug("fetching customers");
		CompletableFuture.runAsync(() -> {
			LocalShopCustomer[] orders = restTemplate.getForObject("http://localhost:8080/customers",
					LocalShopCustomer[].class);
			try {
				logger.info("waiting 1 sec for customers..." + Thread.currentThread().getName());
				Thread.sleep(1000L);
				logger.info("waiting over 1 sec for customers..." + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("recvd customers is : " + orders.length);
		});
	}
}