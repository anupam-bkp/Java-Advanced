package com.anupam.hibernatejpatest3;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anupam.hibernatejpatest3.model.Customer;
import com.anupam.hibernatejpatest3.model.Employee;

public class HibernateJPATest3Write {

	public static void main(String[] args) {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate-JPA-Test3A");
		final EntityManager em = emf.createEntityManager();
		
		final List<Employee> employees = ModelFactory.getEmployees();
		final Set<Customer> customers = ModelFactory.getCustomers();
		
		System.out.println("Begin Transaction");
		
		em.getTransaction().begin();
		employees.forEach(em :: persist);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		customers.forEach(em :: persist);
		em.getTransaction().commit();
		
		em.getTransaction().commit();
		System.out.println("End Transaction");
	}
	
}
