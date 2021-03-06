package com.anupam.springtest6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anupam.springtest6.beansrepo.SpringTest6BeansC;
import com.anupam.springtest6.model.Customer;

public class SpringTest6C {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringTest6BeansC.class);
		
		System.out.println("=====Container Started========");
		
		Customer cust = (Customer)ctx.getBean("cust");
		
		System.out.println(cust.getInfo().getAddr().getCity());
		System.out.println(cust.getShoppingCart().getProduct().getName());
		
		ctx.close();
	}
}
