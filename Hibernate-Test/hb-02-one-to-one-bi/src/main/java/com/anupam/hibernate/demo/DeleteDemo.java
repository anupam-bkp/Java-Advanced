package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class DeleteDemo {

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
	
			int id = 1;
			
			//Start a transaction
			session.beginTransaction();
			
			final Instructor instructor = session.get(Instructor.class, id);

			System.out.println(" the Instructor....");
			
			//This will also delete Instructor-Detatil 
			//because of CascadeType.ALL
			
			if(null != instructor) {
				session.delete(instructor);				
			}
			
			//Commit Transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		System.out.println("Done!");
		
	}
}
