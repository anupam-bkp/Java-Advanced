package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Address;
import com.anupam.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Address.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Create the Object
			final Student theStudent = new Student("Pawan", "Singh", "Pawan@singh.com");
			
//			Address homeAddress = new Address("Street1", "City1", "zipcode1");
//			theStudent.setHomeAddress(homeAddress);
			
			final Address billingAddress = new Address("Bill-Stree1", "Bill-City1", "Bill-Code1");
			theStudent.setBillingAddress(billingAddress);
			
			//start a transaction
			session.beginTransaction();
			System.out.println("Saving student and its address...");
			
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
