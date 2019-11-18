package com.anupam.springtest3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {

	int id;
	PersonalInfo info;					//Constructor Injection
	ShoppingCart shoppingCart;			//Setter Injection
	
	@Autowired
	public Customer(@Qualifier("personalInfo")PersonalInfo info, ShoppingCart shoppingCart) {
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
