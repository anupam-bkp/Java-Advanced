package com.example.dbtest.hb04.oneTOmanyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBiCreateTest {

	public static void main(String[] args) {

		final SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();

		final Course course1 = new Course("Java");
		final Review review1 = new Review("This review for course1");
		final Review review2 = new Review("This review for course2");
		
		course1.addReview(review1);
		course1.addReview(review2);
		
		session.getTransaction().begin();
		session.save(course1);		
		session.save(review1);
		session.save(review2);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
}
