package com.anupam.hibernatejpatest1;

import java.util.ArrayList;
import java.util.List;

import com.anupam.hibernatejpatest1.jpa.model.Employee;

public class ModelFactory {

	private static final String[] NAMES = new String[] {"abc", "yz", "stu", "def", "vwx"};
	
	public static List<Employee> getEmployees(){
		
		List<Employee> employees = new ArrayList<Employee>();
		
		for(int i=0; i<NAMES.length; i++) {
			employees.add(new Employee(NAMES[i]));
		}
		
		return employees;
	}
	
}
