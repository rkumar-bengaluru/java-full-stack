package org.java.full.stack.spring.io.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class LocalShopOffer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	private String name;
	private String availability;
	private Integer price;
	private String[] images;

	public static LocalShopOffer createOffer(String name, String availability, Integer price, String[] images) {
		return new LocalShopOffer(name, availability, price, images);
	}

	public LocalShopOffer() {
	}

	private LocalShopOffer(String name, String availability, Integer price, String[] images) {
		super();
		this.name = name;
		this.availability = availability;
		this.price = price;
		this.images = images;
	}

}
