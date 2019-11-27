package com.anupam.springtest6.beansrepo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.anupam.springtest6.model.Customer;
import com.anupam.springtest6.model.PersonalInfo;

@Configuration
public class SpringTest6BeansA {

	@Bean(name="cust")
	public Customer getCustomer() {
		return new Customer();
	}
	
	@Bean
	@Scope("prototype")
	public PersonalInfo getPersonalInfo() {
		PersonalInfo info = new PersonalInfo();
		info.setName("Anupam");
		info.setNumber(1234);
		return info;
	}
	
	
}
