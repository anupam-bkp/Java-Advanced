package com.anupam.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class GetStudentImagesDemo {

	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId= 1;
			
			final Student theStudent = session.get(Student.class, theId);
			System.out.println("Student Details: " + theStudent);
			
			Map<String, String> images = theStudent.getImages();
			System.out.println("Associated Images : " + images);
			
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			session.close();
			factory.close();
		}
		
		
	}
	
}
