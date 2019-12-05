package com.anupam.springtest2.model;

public class Customer {

	int id;
	PersonalInfo info;					//Constructor Injection
	ShoppingCart shoppingCart;			//Setter Injection
	
	public Customer(PersonalInfo info, ShoppingCart shoppingCart) {
		super();
		this.info = info;
		this.shoppingCart = shoppingCart;
		
		System.out.println("3-arg Customer.Customer()");
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
		return shoppingCart;
	}
}
