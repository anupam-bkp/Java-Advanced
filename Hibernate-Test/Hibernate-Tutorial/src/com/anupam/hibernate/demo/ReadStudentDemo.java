package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//Build Session Factory
		final SessionFactory factory = new Configuration()
									   .configure("hibernate.cfg.xml")
									   .addAnnotatedClass(Student.class)
									   .buildSessionFactory();
		
		//Create Session object
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Starting Save Operation");
			
			//Create Student Object
			final Student student = new Student("Daffy", "Duck", "daffy@duck.com");
			
			//Begin save transaction
			session.beginTransaction();
			//Save student object
			session.save(student);
			//close the save transaction
			session.getTransaction().commit();
			
			System.out.println("Finished Save Operation");
			
			System.out.println("Starting Read Opeartion");
			System.out.println("Read saved student having Generated id: " + student.getId());
			
			//Get a new session and begin new transaction
			session = factory.getCurrentSession();
			session.getTransaction().begin();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id: " + student.getId());
			
			final Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Retrieved : " + myStudent);
			
			//commit the read transaction
			session.getTransaction().commit();
			
			System.out.println("Finished Read operation");
		}
		
		finally {
			factory.close();
		}
	}	
}