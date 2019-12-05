package com.anupam.springtest6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.anupam.springtest6.model.Address;
import com.anupam.springtest6.model.Customer;
import com.anupam.springtest6.model.PersonalInfo;
import com.anupam.springtest6.model.Product;
import com.anupam.springtest6.model.ShoppingCart;

@Configuration
public class SpringTestConfig {

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
	
	@Bean(name="address")
	@Lazy
	public Address getAddress() {
		Address address =  new Address();
		address.setCity("BLR");
		address.setHouseNo(10);
		return address;
	}
	
	@Bean
	public Product getProduct() {
		Product product = new Product();
		product.setName("TV");
		product.setPrice(1234l);
		return product;
	}
	
	@Bean
	public ShoppingCart getShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setNumOfItems(10);
		return shoppingCart;
	}
}





