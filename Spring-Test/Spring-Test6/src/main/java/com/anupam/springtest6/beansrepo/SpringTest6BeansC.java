package com.anupam.springtest6.beansrepo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.anupam.springtest6.model.Address;
import com.anupam.springtest6.model.Product;
import com.anupam.springtest6.model.ShoppingCart;

@Configuration
@Import(SpringTest6BeansA.class)
public class SpringTest6BeansC {
	
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
