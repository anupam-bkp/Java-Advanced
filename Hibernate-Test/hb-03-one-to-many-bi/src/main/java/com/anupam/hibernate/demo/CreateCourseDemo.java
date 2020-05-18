package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class CreateCourseDemo {

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
		
		//Use the save the session object  to save the java object
		try {			
			//Start a transaction
			session.beginTransaction();
		
			//get the instructor from the db
			int theId = 1;
			final Instructor instructor = session.get(Instructor.class, theId);
		
			//create some courses
			final Course course1 = new Course("Java");
			final Course course2 = new Course("Python");
			
			//add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			//save the courses
			session.save(course1);
			session.save(course2);
			
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
