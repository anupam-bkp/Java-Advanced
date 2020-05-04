package com.anupam.springboottest4.database.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anupam.springboottest4.database.entity.Customer;

public interface CustomerSpringDataRepository 
			extends JpaRepository<Customer, Integer> {

	
	
}
