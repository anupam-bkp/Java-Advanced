package com.anupam.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anupam.ecommerce.dao.ProductRepository;
import com.anupam.ecommerce.entities.Product;

@SpringBootApplication
public class SpringBootECommerceApplication implements CommandLineRunner{

	@Autowired
	ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Product> products = productRepo.findAll();
		
		products.forEach(product -> {
			System.out.println(product.getId() + " : " + product.getName());
		});
		
	}

}
