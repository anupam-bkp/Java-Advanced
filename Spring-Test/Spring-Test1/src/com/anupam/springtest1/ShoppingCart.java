package com.anupam.springtest1;

public class ShoppingCart {
	
	int numOfItems;
	String product;
	
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
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		System.out.println("ShoppingCart.setProduct()");
		this.product = product;
	}
}
