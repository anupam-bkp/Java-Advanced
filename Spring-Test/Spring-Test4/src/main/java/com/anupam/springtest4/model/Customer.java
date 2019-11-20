package com.anupam.springtest4.model;

import javax.annotation.Resource;

public class Customer {

	int id;
	
	@Resource(name = "personalInfo")
	PersonalInfo info;					
	
	@Resource
	ShoppingCart shoppingCart;	
	
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
