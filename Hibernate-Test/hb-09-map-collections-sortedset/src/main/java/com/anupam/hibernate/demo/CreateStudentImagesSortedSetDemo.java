package com.anupam.hibernate.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class CreateStudentImagesSortedSetDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create the Object
			Student theStudent = new Student("Pawan", "Singh", "Pawan@singh.com");
			Set<String> theImages = theStudent.getImages();
			
			theImages.add("photo1.jpg");
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg"); //Duplicate must be filtered at java level by Hashset.
			theImages.add("photo5.jpg");
			theImages.add("photo5.jpg"); //Duplicate must be filtered
			
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
