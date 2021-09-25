package org.java.full.stack.spring.io;

import org.java.full.stack.spring.io.model.Offer;
import org.java.full.stack.spring.io.model.Product;
import org.java.full.stack.spring.io.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ProductDataInit implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p = Product.createProduct("20001", "Lakmé™ Absolute 3D Lip Definer", "20001", "20001", 2999);
		String[] images = {"/images/20001/01.webp","/images/20001/02.webp"};
		Offer o1 = Offer.createOffer("Ruby", "https://schema.org/InStock", 700, images);
		Offer o2 = Offer.createOffer("Rail", "https://schema.org/InStock", 750, images);
		p.addOffer(o1);
		p.addOffer(o2);
		productService.save(p);
		productService.findAll().forEach(e -> {
			System.out.println("fetched product name ->" + e.getName());
		});
	}

}
