package com.anupam.springboottest4.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anupam.springboottest4.database.entity.Customer;
import com.anupam.springboottest4.database.jpa.CustomerJpaRepository;

//@SpringBootApplication
public class SpringBootJpaDemoApplication implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerJpaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Customer with Specific id : {}", repo.retrieveCustomerById(10001));
		
		logger.info("Insert new Customer {}", 
				repo.insertCustomer(new Customer("Tara", "Berlin", new Date())));
		
		logger.info("Update Customer {}", 
				repo.updateCustomer(new Customer("Pieter", "Utrecht", new Date())));

		logger.info("All Customers : {}", repo.retrieveAllCustomer());
		
		repo.deleteById(1);
		
		}

}
