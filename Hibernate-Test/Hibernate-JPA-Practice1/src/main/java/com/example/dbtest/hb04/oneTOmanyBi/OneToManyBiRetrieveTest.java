package com.example.dbtest.hb04.oneTOmanyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBiRetrieveTest {

	public static void main(String[] args) {

		final SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();

		session.getTransaction().begin();
	
		
		
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
