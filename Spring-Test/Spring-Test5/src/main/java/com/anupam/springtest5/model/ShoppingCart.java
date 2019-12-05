package com.anupam.springtest5.model;

import javax.annotation.Resource;

public class ShoppingCart {
	
	int numOfItems;
	
	@Resource
	Product product;
	
	public void myInit() {
		System.out.println("ShoppingCart.myInit()");
	}
	
	public void myDestroy() {
		System.out.println("ShoppingCart.myDestroy()");
	}
	
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
