package com.anupam.springtest1;

public class Customer {

	int id;
	PersonalInfo info;					//Constructor Injection
	ShoppingCart shoppingCart;			//Setter Injection
	
	public Customer(int id, PersonalInfo info) {
		super();
		this.id = id;
		this.info = info;
		
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
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		System.out.println("Customer.setShoppingCart()");
		this.shoppingCart = shoppingCart;
	}
}
