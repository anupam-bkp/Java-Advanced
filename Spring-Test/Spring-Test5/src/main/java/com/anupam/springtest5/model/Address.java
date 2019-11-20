package com.anupam.springtest5.model;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class Address {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	BeanFactory factory;
	
	String city;
	int houseNo;	
	
	public Address() {
		System.out.println("no-arg constructo Address.Address()");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	public void show() {
		System.out.println("Address.show()");
		System.out.println("ApplicationContext : " + ctx);
		System.out.println("BeanFactory : " + factory);
	}
}
