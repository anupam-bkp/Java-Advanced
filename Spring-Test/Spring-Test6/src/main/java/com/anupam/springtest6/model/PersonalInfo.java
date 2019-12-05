package com.anupam.springtest6.model;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;

public class PersonalInfo {

	String name;
	int number;
	
	@Inject
	@Qualifier("address")
	Address addr;
	
	public PersonalInfo() {
		System.out.println("PersonalInfo.PersonalInfo()");
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

	/*public void setAddr(Address addr) {
		System.out.println("PersonalInfo.setAddr()");
		this.addr = addr;
	}
	*/
}
