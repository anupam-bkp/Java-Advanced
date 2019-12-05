package com.anupam.springtest1;

public class PersonalInfo {

	String name;
	int number;
	Address addr;	//Constructor Injection
	
	public PersonalInfo(Address addr) {
		super();
		this.addr = addr;
		System.out.println("1-arg constructor - PersonalInfo.PersonalInfo()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("PersonalInfo.setName()");
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		System.out.println("PersonalInfo.setNumber()");
		this.number = number;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		System.out.println("PersonalInfo.setAddr()");
		this.addr = addr;
	}
	
}
