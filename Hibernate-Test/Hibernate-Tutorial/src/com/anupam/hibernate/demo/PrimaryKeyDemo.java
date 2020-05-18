package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//Create SessionFactory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create Session Object
		Session session = factory.getCurrentSession();
		
		try {
			
			//Create 3 Student object
			
			Student stu1= new Student("John", "Doe", "john@doe.com");
			Student stu2= new Student("Mary", "Public", "mary@public.com");
			Student stu3= new Student("Bonita", "Applebum", "bonita@applebum.com");
			
			//Start transaction
			session.getTransaction().begin();
			
			//Save Student Object
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			
			//Commit Transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		System.out.println("Done!");
	}

}
