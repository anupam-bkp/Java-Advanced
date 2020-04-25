package com.anupam.springtest2.model;

public class Product {

	String name;
	
	long price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Product.setName()");
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		System.out.println("Product.setPrice()");
		this.price = price;
	}

}
