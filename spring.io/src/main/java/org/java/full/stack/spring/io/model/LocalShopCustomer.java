package org.java.full.stack.spring.io.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "customers")
public class LocalShopCustomer {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String addresses;
	
	public LocalShopCustomer() {
		super();
	}

	@Override
	public String toString() {
		return "LocalShopCustomer [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddresses() {
		return addresses;
	}
	
	public LocalShopCustomer(String name, String addresses) {
		super();
		this.name = name;
		this.addresses = addresses;
	}

	public static LocalShopCustomer createCustomer(String name, String address) {
		LocalShopCustomer c = new LocalShopCustomer(name, address);
		return c;
	}
}
