package com.anupam.hibernatejpatest3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.anupam.hibernatejpatest3.model.Customer;
import com.anupam.hibernatejpatest3.model.Employee;
import com.anupam.hibernatejpatest3.model.Product;


public class ModelFactory {

	private static final String[] NAMES = new String[] {"abc", "yz", "stu", "def", "vwx"};
	
	public static List<Employee> getEmployees(){
		
		List<Employee> employees = new ArrayList<Employee>();
		
		for(int i=0; i<NAMES.length; i++) {
			employees.add(new Employee(NAMES[i]));
		}
		
		return employees;
	}
	
	private static Set<Product> getProducts(int custId){
		
		final Set<Product> products = new HashSet<>();
		
		if(custId == 1) {
			products.add(new Product(generateId(), "Product1A", "Beauty"));
			products.add(new Product(generateId(), "Product1B", "Sports"));
		}
		
		if(custId == 2) {
			products.add(new Product(generateId(), "Product2A", "Education"));
			products.add(new Product(generateId(), "Product2B", "Entertainment"));
		}
	
		return products;
	}

	public static Set<Customer> getCustomers(){
		
		final Set<Customer> customers = new HashSet<>();
		
		Customer cust1 = new Customer(generateId(), "Customer1", getProducts(1));
		customers.add(cust1);
		Customer cust2 = new Customer(generateId(), "Customer2", getProducts(2));
		customers.add(cust2);
		
		return customers;
	}
	
	private static String generateId() {
		return UUID.randomUUID().toString();
	}
}
