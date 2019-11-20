package com.anupam.springtest5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anupam.springtest5.model.Address;
import com.anupam.springtest5.model.Customer;
import com.anupam.springtest5.model.PersonalInfo;
import com.anupam.springtest5.model.Product;

public class SpringTest5 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("Spring container started");
		System.out.println("=======================");
		
		Customer cust = (Customer)ctx.getBean("cust");
		System.out.println(cust.getId());
		cust.show();
		
		System.out.println("========================================");
		
		PersonalInfo info = cust.getInfo();
		System.out.println(info.getName());
		
		System.out.println("========================================");
		
		Address addr = info.getAddr();
		System.out.println(addr.getCity());
		addr.show();
		
		System.out.println("=======================================");
		
		Product product = cust.getShoppingCart().getProduct();
		System.out.println(product.getName());
	}
}
