package com.anupam.springtest2.model;

public class ShoppingCart {
	
	int numOfItems;
	
	Product product; //autowire byType
	
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

	public void setProduct(Product product) {
		System.out.println("ShoppingCart.setProduct()");
		this.product = product;
	}
}
