package com.example.dbtest.hb05.manyTOmany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyRetrieveTest {

	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml")
							.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
		
		
		session.beginTransaction();
		
		
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
	
}
