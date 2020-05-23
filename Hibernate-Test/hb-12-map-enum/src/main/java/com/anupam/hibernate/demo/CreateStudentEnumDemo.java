package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Status;
import com.anupam.hibernate.demo.entity.Student;

public class CreateStudentEnumDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create the Object
			final Student student1 = new Student("Anupam", "Kumar", 
					"Anupam@kumar.com", Status.ACTIVE);
			
			final Student student2 = new Student("Pawan", "Singh", 
					"Pawan@singh.com", Status.INACTIVE);
			
			//start a transaction
			session.beginTransaction();
			System.out.println("Saving student and its address...");
			
			session.persist(student1);
			session.persist(student2);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("----Done!!----");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}
	
}
