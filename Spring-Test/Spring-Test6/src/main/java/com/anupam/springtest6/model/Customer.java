package com.anupam.springtest6.model;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {

	int id;
	
	@Autowired
	PersonalInfo info;
	
	@Inject
	ShoppingCart shoppingCart;
	
	public Customer() {
		
	}
	
/*	public Customer(PersonalInfo info, ShoppingCart shoppingCart) {
		super();
		this.info = info;
		this.shoppingCart = shoppingCart;
		
		System.out.println("3-arg Customer.Customer()");
	}*/

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

	/*public void setInfo(PersonalInfo info) {
		System.out.println("Customer.setInfo()");
		this.info = info;
	}*/

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
}
