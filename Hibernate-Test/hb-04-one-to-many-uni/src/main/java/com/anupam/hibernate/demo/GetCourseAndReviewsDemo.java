package com.anupam.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;
import com.anupam.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

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
			
			int theId = 10;
			
			//Fetch the course
			final Course course = session.get(Course.class, theId);
			System.out.println(course);
			
			//Fetch the Reviews lazily
			final List<Review> reviews = course.getReviews();
			System.out.println(reviews);
			
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
