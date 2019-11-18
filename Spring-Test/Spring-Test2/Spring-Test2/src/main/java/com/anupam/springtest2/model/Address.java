package com.anupam.springtest2.model;

public class Address {

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
}
