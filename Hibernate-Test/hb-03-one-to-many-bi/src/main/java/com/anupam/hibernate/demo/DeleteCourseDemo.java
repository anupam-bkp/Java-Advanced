package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//Create SessionFactory
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetatil.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//Create Session
		final Session session = factory.getCurrentSession();
		
		try {			
			//Start a transaction
			session.beginTransaction();
		
			//get the instructor from the db
			int theId = 11;
			final Course course = session.get(Course.class, theId);
			
			//delete the course
			// This shall delete only course not instructor as specific Cascade type is used
			session.delete(course);
			
			//Commit Transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
		
		System.out.println("Done!");
		
	}
}
