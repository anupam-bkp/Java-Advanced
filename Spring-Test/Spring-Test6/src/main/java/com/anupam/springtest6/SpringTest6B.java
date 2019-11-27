package com.anupam.springtest6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anupam.springtest6.beansrepo.SpringTest6BeansA;
import com.anupam.springtest6.beansrepo.SpringTest6BeansB;
import com.anupam.springtest6.model.Customer;

public class SpringTest6B {

	public static void main(String[] args) {
		/*
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringTest6BeansA.class, SpringTestBeansB.class);
		*/
		
		/*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SpringTest6BeansA.class);
		ctx.register(SpringTestBeansB.class);
		
		ctx.refresh();*/
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.anupam.springtest6.beansrepo");
		ctx.refresh();
		
		System.out.println("=========Container Started=============");
		
		Customer cust = (Customer)ctx.getBean("cust");
		System.out.println(cust.getInfo().getAddr().getCity());
		System.out.println(cust.getShoppingCart().getProduct().getName());
		
		ctx.close();
	}
	
}
