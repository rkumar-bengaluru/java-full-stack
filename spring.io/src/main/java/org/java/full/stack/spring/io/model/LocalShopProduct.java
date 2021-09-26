package org.java.full.stack.spring.io.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class LocalShopProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productID;
	private String name;
	private String sku;
	private String mpn;
	@OneToMany(targetEntity=LocalShopOffer.class,cascade=CascadeType.ALL)
	private Set<LocalShopOffer> offers = new HashSet<>();
	private int price;

	protected LocalShopProduct() {
	}

	public LocalShopProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productID=" + productID + ", name=" + name + ", sku=" + sku + ", mpn=" + mpn
				+ ", offers=" + offers + ", price=" + price + "]";
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

	public void addOffer(LocalShopOffer offer) {
		getOffers().add(offer);
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

	public void setOffers(Set<LocalShopOffer> offers) {
		this.offers = offers;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Collection<LocalShopOffer> getOffers() {
		return offers;
	}

	public static LocalShopProduct createProduct(String productID, String name, String sku, String mpn, int price) {
		return new LocalShopProduct(productID, name, sku, mpn, price);
	}

	private LocalShopProduct(String productID, String name, String sku, String mpn, int price) {
		super();
		this.productID = productID;
		this.name = name;
		this.sku = sku;
		this.mpn = mpn;
		this.price = price;
	}

}