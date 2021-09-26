package org.java.full.stack.spring.io.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "orders")
public class LocalShopOrder {

	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(targetEntity = LocalShopProduct.class, cascade = CascadeType.ALL)
	private Set<LocalShopProduct> products = new HashSet<>();

	public Long getId() {
		return id;
	}

	public Set<LocalShopProduct> getProducts() {
		return products;
	}

	public LocalShopCustomer getCustomer() {
		return customer;
	}

	@OneToOne
	private LocalShopCustomer customer;

	public LocalShopOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalShopOrder(Set<LocalShopProduct> products, LocalShopCustomer customer) {
		super();
		this.products = products;
		this.customer = customer;
	}

	public static LocalShopOrder createOrder(Set<LocalShopProduct> products, LocalShopCustomer customer) {
		LocalShopOrder o = new LocalShopOrder(products, customer);
		return o;
	}

}
