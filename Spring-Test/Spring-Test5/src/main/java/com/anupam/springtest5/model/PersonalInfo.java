package com.anupam.springtest5.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonalInfo implements InitializingBean, DisposableBean{

	String name;
	int number;
	
	@Resource(name = "address")
	Address addr;	//byName
	
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

	@Override
	public void destroy() throws Exception {
		System.out.println("PersonalInfo.destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("PersonalInfo.afterPropertiesSet()");
	}
}
