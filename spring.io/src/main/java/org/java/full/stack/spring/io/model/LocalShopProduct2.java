package org.java.full.stack.spring.io.model;

import org.springframework.data.annotation.Id;

public class LocalShopProduct2 {

	@Id
	private Long id;
	private String productID;
	private String name;
	private String sku;
	private String mpn;
	private int price;

	protected LocalShopProduct2() {
	}

	public LocalShopProduct2(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productID=" + productID + ", name=" + name + ", sku=" + sku + ", mpn=" + mpn
				+ ", price=" + price + "]";
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static LocalShopProduct2 createProduct(String productID, String name, String sku, String mpn, int price) {
		return new LocalShopProduct2(productID, name, sku, mpn, price);
	}

	private LocalShopProduct2(String productID, String name, String sku, String mpn, int price) {
		super();
		this.productID = productID;
		this.name = name;
		this.sku = sku;
		this.mpn = mpn;
		this.price = price;
	}

}