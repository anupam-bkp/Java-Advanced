package com.example.dbtest.hb05.manyTOmany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyCreateTest {
	
	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
	
		Course course1 = new Course("Java");
		Course course2 = new Course("Angular");
		
		Student st1 = new Student("Anupam");
		Student st2 = new Student("Pawan");
		
		course1.addStudent(st1);
		course1.addStudent(st2);
		
		//Start transaction
		session.beginTransaction();
		
		session.save(st1);
		session.save(st2);
		session.save(course1);
		session.save(course2);
		
		//Commit transaction
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}

}
