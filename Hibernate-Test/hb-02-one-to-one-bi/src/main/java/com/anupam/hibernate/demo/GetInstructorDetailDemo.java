package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//Create SessionFactory
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetatil.class)
				.buildSessionFactory();
		
		//Create Session

		final Session session = factory.getCurrentSession();
	
		try {			
	
			//Start a transaction
			session.beginTransaction();

			//get the instructor-detail id
			int theId = 2;
			
			InstructorDetatil instDetail = session.get(InstructorDetatil.class, theId);
			
			System.out.println(instDetail);
			
			final Instructor instructor = instDetail.getInstructor();
			System.out.println(instructor);
			
			
			//Commit Transaction
			session.getTransaction().commit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
		
		System.out.println("Done!");
		
	}
}
