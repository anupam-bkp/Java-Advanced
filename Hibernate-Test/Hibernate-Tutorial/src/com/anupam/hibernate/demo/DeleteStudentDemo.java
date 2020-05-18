package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//Build Session Factory
		final SessionFactory factory = new Configuration()
									   .configure("hibernate.cfg.xml")
									   .addAnnotatedClass(Student.class)
									   .buildSessionFactory();
		
		//Create Session object
		Session session = factory.getCurrentSession();
		
		try {
			int studentId=1;	
			session.getTransaction().begin();
			
			//Retrieve Student having StudentId
			final Student myStudent = session.get(Student.class, studentId);
			
			//Update student
			myStudent.setFirstName("Scooby");
			
			//Commit
			session.getTransaction().commit();
			
			//Updating Email of all Students
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Finished Read operation");
		}
		
		finally {
			factory.close();
		}
	}	
}