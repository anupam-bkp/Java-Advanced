package com.anupam.springtest3.model;

public class Product {

	String name;
	
	long price;
	
	public Product() {
		super();
		System.out.println("no-arg constructor Product.Product()");
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
