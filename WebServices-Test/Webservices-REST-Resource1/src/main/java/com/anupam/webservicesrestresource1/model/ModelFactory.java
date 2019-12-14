package com.anupam.webservicesrestresource1.model;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {

	private static final String[] CUST_NAMES = new String[] {"ANUPAM", "ANAMIKA"};
	
	public static List<Customer> getCustomers(){
		
		List<Customer> customers = new ArrayList<>();
		
		for(int i=0; i<CUST_NAMES.length; i++) {
			customers.add(new Customer(i, CUST_NAMES[i]));			
		}
		
		return customers;
	}
	
	public static Customer getCustomer(int id) {
		return getCustomers().get(id);
	}
	
}
