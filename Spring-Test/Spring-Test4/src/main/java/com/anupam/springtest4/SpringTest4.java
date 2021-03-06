package com.anupam.springtest4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anupam.springtest4.model.Address;
import com.anupam.springtest4.model.Customer;
import com.anupam.springtest4.model.PersonalInfo;
import com.anupam.springtest4.model.Product;

public class SpringTest4 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("Spring container started");
		System.out.println("=======================");
		
		Customer cust = (Customer)ctx.getBean("cust");
		System.out.println(cust.getId());
		
		PersonalInfo info = cust.getInfo();
		System.out.println(info.getName());
		
		Address addr = info.getAddr();
		System.out.println(addr.getCity());
		
		Product product = cust.getShoppingCart().getProduct();
		System.out.println(product.getName());
		
	}
	
}
