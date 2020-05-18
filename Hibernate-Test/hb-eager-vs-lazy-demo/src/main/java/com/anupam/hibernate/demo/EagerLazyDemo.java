package com.anupam.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class EagerLazyDemo {

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
			
			//get the instructor
			int theId = 1;
			final Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Instructor : " + instructor);
			
			//get the courses
			final List<Course> courses = instructor.getCourses();
			System.out.println(courses);
			
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
