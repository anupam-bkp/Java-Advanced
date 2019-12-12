package com.anupam.hibernatejpatest3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anupam.hibernatejpatest2.model.querydsl.QEmployee;
import com.anupam.hibernatejpatest3.model.Employee;
import com.querydsl.jpa.impl.JPAQuery;

public class HibernateJPATest3ReadUsingQueryDSL {
	
	public static void main(String[] args) {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate-JPA-Test3A");
		final EntityManager em = emf.createEntityManager();
	
		System.out.println("Read Started");
		
		JPAQuery<QEmployee> query = new JPAQuery<>(em);
		
		QEmployee qEmp = QEmployee.employee;
		List<QEmployee> fetch = query.from(qEmp).fetch();
		
//		fetch.stream().map(qEMP -> (Employee)qEMP).forEach(System.out :: println);
		
	}

}
