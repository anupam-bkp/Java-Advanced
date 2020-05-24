package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.Student;
import com.anupam.hibernate.demo.entity.User;

public class CreateUserStudentInstructorDemo {

	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("Anupam", "Kumar", "Hibernate");
			Instructor instructor = new Instructor("Mary", "Public", 10000.0d);
			
			System.out.println("Saving Student and Instructor");
			
			session.beginTransaction();
			
			session.save(student);
			session.save(instructor);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}
}
