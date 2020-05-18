package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;
import com.anupam.hibernate.demo.entity.Review;
import com.anupam.hibernate.demo.entity.Student;

public class DeleteJavaCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetatil.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
								
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
		
			//get the Java course from db
			int courseId = 10;
			Course course = session.get(Course.class, courseId);
			
			//Delete the course
			System.out.println("Deleting the course : " + course);
			session.delete(course);
							
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
	}
	
}
