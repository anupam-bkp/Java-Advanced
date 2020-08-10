package com.example.dbtest.hb02.oneTOoneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiRetrieveTest {

	public static void main(String[] args) {

		final SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg2.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();

		session.getTransaction().begin();
	
		/*
		 * Instructor instructor = session.get(Instructor.class, 1); InstructorDetail
		 * instructorDetail = instructor.getInstructorDetail();
		 */
		
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);
		Instructor instructor = instructorDetail.getInstructor();
		
		System.out.println("==========Instructor===========");
		System.out.println(instructor);
		System.out.println("========== Instructor Detail=========");
		System.out.println(instructorDetail);
		
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
