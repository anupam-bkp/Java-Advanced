package com.anupam.springtest5.model;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Customer implements BeanNameAware, BeanFactoryAware, ApplicationContextAware{

	ApplicationContext ctx;
	BeanFactory beanFactory;
	String beanName;
	
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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Customer.setApplicationContext()");
		this.ctx = applicationContext;
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("Customer.setBeanFactory()");
		this.beanFactory = arg0;
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Customer.setBeanName()");
		this.beanName = arg0;
	}
	
	public void show() {
		System.out.println("Customer.show()");
		System.out.println("ApplicationContext : " + ctx);
		System.out.println("BeanFactory : " + beanFactory);
		System.out.println("Bean Name : " + beanName);
	}
	
	
}
