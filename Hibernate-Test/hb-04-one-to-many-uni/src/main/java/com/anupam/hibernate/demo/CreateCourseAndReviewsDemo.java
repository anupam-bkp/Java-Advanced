package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;
import com.anupam.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//Create SessionFactory
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetatil.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create Session

		final Session session = factory.getCurrentSession();
		
		//Use the save the session object  to save the java object
		try {			
			//Start a transaction
			session.beginTransaction();
			
			//create course with some reviews
			final Course course = new Course("Java");
			course.addReview(new Review("Good Course"));
			course.addReview(new Review("Cool Course"));
			course.addReview(new Review("Learn More"));
			
			//save the course and leverage the cascade All...
			session.save(course);
			
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
