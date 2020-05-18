package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class CreateInstructorDemo {

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
			
			//Create the Objects
			/*final Instructor instructor = 
					new Instructor("Anupam", "Kumar", "Anupam@kumar.com");
			
			final InstructorDetatil instructorDetail = 
					new InstructorDetatil("anupam@youtube.com", "Coding");
			*/
			
			final Instructor instructor = 
					new Instructor("Vishal", "Kumar", "Vishal@kumar.com");
			
			final InstructorDetatil instructorDetail = 
					new InstructorDetatil("vishal@youtube.com", "Talking");
			
			//Associate the Objects
			instructor.setInstructorDetail(instructorDetail);
			
			//Start a transaction
			session.beginTransaction();
			
			//This will also save Instructor-Detail 
			//because of CascadeType.ALL
			System.out.println("Saving the Instructor....");
			session.save(instructor);
			
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
