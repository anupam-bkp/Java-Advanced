package com.anupam.hibernatejpatest1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anupam.hibernatejpatest1.jpa.model.Employee;

public class HibernateJPATestRead {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate-JPA-Test1A");
		EntityManager em = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Employee> empList = em.createQuery("Select e from Employee e").getResultList();
		
		empList.forEach(System.out :: println);
	}
	
}
