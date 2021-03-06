package com.anupam.springtest3.model;

import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCart {
	
	int numOfItems;
	
	@Autowired
	Product product;
	
	public ShoppingCart() {
		System.out.println("no-arg constructor ShoppingCart.ShoppingCart()");
	}
	
	public int getNumOfItems() {
		return numOfItems;
	}
	
	public void setNumOfItems(int numOfItems) {
		System.out.println("ShoppingCart.setNumOfItems()");
		this.numOfItems = numOfItems;
	}

	public Product getProduct() {
		return product;
	}
}
