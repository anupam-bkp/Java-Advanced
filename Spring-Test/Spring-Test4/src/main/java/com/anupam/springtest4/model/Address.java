package com.anupam.springtest4.model;

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
		System.out.println("Address.setCity()");
		this.city = city;
	}
	
	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		System.out.println("Address.setHouseNo()");
		this.houseNo = houseNo;
	}
}
