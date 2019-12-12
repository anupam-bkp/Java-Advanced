package com.anupam.hibernatejpatest1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anupam.hibernatejpatest1.jpa.model.Employee;

public class HibernateJPATest1Write {

	public static void main(String[] args) {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate-JPA-Test1A");
		final EntityManager em = emf.createEntityManager();
	
		final List<Employee> employees = ModelFactory.getEmployees();
		
		System.out.println("Starting Transaction");
		em.getTransaction().begin();
				
		//Creating Employees table and persisting employee object
		employees.forEach(em :: persist);
		
		em.getTransaction().commit();
		
		System.out.println("End Transaction");
		
	}
	
}
