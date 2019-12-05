package com.anupam.springtest1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {

	public static void main(String[] args) {
				
		//With IOC / DI
		
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
		
	}
}
