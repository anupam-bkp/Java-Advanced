package com.anupam.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class CreateStudentImagesMapDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create the Object
			Student theStudent = new Student("Pawan", "Singh", "Pawan@singh.com");
			Map<String, String> theImages = theStudent.getImages();
			
			theImages.put("photo1.jpg", "Photo 1");
			theImages.put("photo2.jpg", "Photo 2");
			theImages.put("photo3.jpg", "Photo 3");
			
			//start a transaction
			session.beginTransaction();
			System.out.println("Saving student and images...");
			
			session.persist(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("----Done!!----");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}
	
}
