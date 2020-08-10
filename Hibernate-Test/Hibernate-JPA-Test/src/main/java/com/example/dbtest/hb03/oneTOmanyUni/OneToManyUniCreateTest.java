package com.example.dbtest.hb03.oneTOmanyUni;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyUniCreateTest {

	public static void main(String[] args) {

		final SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();

		final Course course1 = new Course("Angular");
		
		final Review review1 = new Review("This is review1.");
		final Review review2 = new Review("This is review2.");
		
		course1.setReviews(new ArrayList<Review>(Arrays.asList(review1, review2)));
		
		session.getTransaction().begin();
		session.save(course1);		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
}
