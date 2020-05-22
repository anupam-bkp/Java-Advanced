package com.anupam.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class CreateStudentImagesListDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create the Object
			Student theStudent = new Student("Pawan", "Singh", "Pawan@singh.com");
			List<String> theImages = theStudent.getImages();
			
			theImages.add("photo1.jpg");
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg"); //Duplicated are also inserted in the list.
			
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
