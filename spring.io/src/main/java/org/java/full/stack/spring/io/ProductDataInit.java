package org.java.full.stack.spring.io;

import org.java.full.stack.spring.io.model.LocalShopOffer;
import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.java.full.stack.spring.io.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(value = 1)
@Component
public class ProductDataInit implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;

	@Override
	public void run(String... args) throws Exception {
		LocalShopProduct p = LocalShopProduct.createProduct("20001", "Lakmé™ Absolute 3D Lip Definer", "20001", "20001", 2999);
		String[] images = {"/images/20001/01.webp","/images/20001/02.webp"};
		LocalShopOffer o1 = LocalShopOffer.createOffer("Ruby", "https://schema.org/InStock", 700, images);
		LocalShopOffer o2 = LocalShopOffer.createOffer("Rail", "https://schema.org/InStock", 750, images);
		p.addOffer(o1);
		p.addOffer(o2);
		productService.save(p);
		LocalShopProduct p2 = LocalShopProduct.createProduct("20002", "Apacs Ziggler", "20002", "20002", 2999);
		LocalShopOffer o3 = LocalShopOffer.createOffer("White", "https://schema.org/InStock", 2999, images);
		p2.addOffer(o3);
		productService.save(p2);
		productService.findAll().forEach(e -> {
			System.out.println("fetched product name ->" + e.getName());
		});
		
		productService.findByName("Lip").forEach(e -> {
			System.out.println("fetched product name ->" + e.getName());
		});
	}

}
