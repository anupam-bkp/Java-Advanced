package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//Create SessionFactory
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create Session

		final Session session = factory.getCurrentSession();
		
		//Use the save the session object  to save the java object
		try {			
			//Create a student object
			
			System.out.println("Creating a new Student Object");
			
			final Student tempStudent = new Student("Paul", "Wall", "paul@wall.com");
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the Student Object
			System.out.println("Saving the student....");
			session.save(tempStudent);
			
			//Commit Transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		System.out.println("Done!");
		
	}
}
