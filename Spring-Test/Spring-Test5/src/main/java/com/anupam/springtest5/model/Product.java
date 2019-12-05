package com.anupam.springtest5.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Product {

	String name;
	
	long price;

	@PostConstruct
	public void init() {
		System.out.println("Product.init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Product.destroy()");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
