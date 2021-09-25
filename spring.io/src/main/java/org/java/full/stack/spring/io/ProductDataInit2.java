package org.java.full.stack.spring.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(value=2)
public class ProductDataInit2 implements ApplicationRunner{
	
	Logger logger = LoggerFactory.getLogger(getClass());

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("ProductDataInit2..................");
	}

}
