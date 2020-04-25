package com.anupam.springtest2.model;

public class Customer {

	int id;
	PersonalInfo info;					//Constructor Injection
	ShoppingCart shoppingCart;			//Constructor Injection
	
	public Customer(PersonalInfo info, ShoppingCart shoppingCart) {
		super();
		this.info = info;
		this.shoppingCart = shoppingCart;
		
		System.out.println("2-arg Customer.Customer()");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("Customer.setId()");
		this.id = id;
	}

	public PersonalInfo getInfo() {
		return info;
	}

	public void setInfo(PersonalInfo info) {
		System.out.println("Customer.setInfo()");
		this.info = info;
	}

	public ShoppingCart getShoppingCart() {
		System.out.println("Customer.getShoppingCart()");
		return shoppingCart;
	}
}
