package com.example.dbtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.dbtest.entities.Employees;

public class CreateTest1 {

	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employees.class)
									.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
		
		//Create Employees Object
		
		Employees emp1 = new Employees("Anupam", "Kumar");
		Employees emp2 = new Employees("Pawan", "Singh");
		
		//begin transaction
		session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		
		//commit transaction
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
}
