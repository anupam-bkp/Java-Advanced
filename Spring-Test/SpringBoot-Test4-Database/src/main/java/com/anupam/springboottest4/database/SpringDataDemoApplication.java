package com.anupam.springboottest4.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anupam.springboottest4.database.entity.Customer;
import com.anupam.springboottest4.database.springdata.CustomerSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerSpringDataRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		logger.info("Insert new Customer {}", 
				repo.save(new Customer("Tara", "Berlin", new Date())));
		
		logger.info("Update Customer {}", 
				repo.save(new Customer("Pieter", "Utrecht", new Date())));

		logger.info("Customer with Specific id : {}", repo.findById(1));
		
		logger.info("All Customers : {}", repo.findAll());
		
		repo.deleteById(1);
		}

}
