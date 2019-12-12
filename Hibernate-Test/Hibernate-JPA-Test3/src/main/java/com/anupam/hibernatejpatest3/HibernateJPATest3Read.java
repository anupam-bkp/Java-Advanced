package com.anupam.hibernatejpatest3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anupam.hibernatejpatest3.model.Customer;
import com.anupam.hibernatejpatest3.model.Employee;

public class HibernateJPATest3Read {

	public static void main(String[] args) {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate-JPA-Test3A");
		final EntityManager em = emf.createEntityManager();
	
		System.out.println("Read Started");
		
		@SuppressWarnings("unchecked")
		List<Employee> empList = em.createQuery("Select e from Employee e").getResultList();
		empList.forEach(System.out :: println);
		
		System.out.println("\n============================\n");
		
		@SuppressWarnings("unchecked")
		List<Customer> customersList = em.createQuery("select c from Customer c").getResultList();
		customersList.forEach(customer -> {
			System.out.println(customer);
			customer.getProducts().forEach(System.out :: println);
		});
	
		System.out.println("Read End");
	}
	
}
