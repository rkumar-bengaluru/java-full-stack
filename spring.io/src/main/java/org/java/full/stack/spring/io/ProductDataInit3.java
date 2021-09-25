package org.java.full.stack.spring.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(value=1)
public class ProductDataInit3 implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public void run(String... args) throws Exception {
		logger.info("ProductDataInit3..................");
	}

}
