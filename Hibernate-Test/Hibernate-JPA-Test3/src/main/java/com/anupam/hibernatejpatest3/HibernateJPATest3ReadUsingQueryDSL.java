package com.anupam.hibernatejpatest3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anupam.hibernatejpatest2.model.querydsl.QCustomer;
import com.anupam.hibernatejpatest2.model.querydsl.QEmployee;
import com.anupam.hibernatejpatest3.model.Customer;
import com.anupam.hibernatejpatest3.model.Employee;
import com.querydsl.jpa.impl.JPAQuery;

public class HibernateJPATest3ReadUsingQueryDSL {
	
	public static void main(String[] args) {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate-JPA-Test3A");
		final EntityManager em = emf.createEntityManager();
	
		System.out.println("Reading Employee Data");
		
		JPAQuery<Employee> query = new JPAQuery<>(em);
		QEmployee qEmp = QEmployee.employee;
		
		List<Employee> fetch = query.from(qEmp).fetch();
		fetch.stream().forEach(System.out :: println);
		
		System.out.println("Reading Customer Data");
		
		JPAQuery<Customer> custQuery = new JPAQuery<>(em);
		QCustomer qCust = QCustomer.customer;
		
		List<Customer> custList = custQuery.from(qCust).fetch();
		for(Customer cust : custList) {
			System.out.println(cust.getName());
			System.out.println(cust.getProducts());
		}	
	}

}
