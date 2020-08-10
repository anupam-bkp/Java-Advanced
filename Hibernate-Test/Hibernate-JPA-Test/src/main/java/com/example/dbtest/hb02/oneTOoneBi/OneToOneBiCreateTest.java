package com.example.dbtest.hb02.oneTOoneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiCreateTest {

	public static void main(String[] args) {

		final SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		final Session session = sessionFactory.getCurrentSession();

		final Instructor instructor = new Instructor("Amit", "Kumar");
		final InstructorDetail instructorDetail1 = new InstructorDetail("channel1", "working1");
		final InstructorDetail instructorDetail2 = new InstructorDetail("channel2", "working2");

		instructor.setInstructorDetail(instructorDetail2);
//		instructorDetail2.setInstructor(instructor);

		session.getTransaction().begin();
		session.save(instructorDetail1);
		session.save(instructor);
//		session.save(instructorDetail2);
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}
