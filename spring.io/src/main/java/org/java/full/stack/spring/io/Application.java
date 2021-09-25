package org.java.full.stack.spring.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (scanBasePackages = { "org.java.full.stack.spring.io"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public ProductDataInit schedulerRunner() {
        return new ProductDataInit();
    }

}
