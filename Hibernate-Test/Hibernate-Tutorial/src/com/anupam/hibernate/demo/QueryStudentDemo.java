package com.anupam.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//Query All Students
			List<?> resultList = session.createQuery("from Student").getResultList();
			System.out.println(resultList);
			
			
			//Query Students with lastName as doe
			System.out.println("======\nStudent with last Name Doe ========");
			resultList = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println(resultList);

			//Query Students with lastName Doe or firstName Daffy
			resultList = session.createQuery("from Student s where s.firstName='Daffy' OR"
						+ " s.lastName='Doe'").getResultList();
			System.out.println("\n============\n" + resultList);
			
			//Query Students having email ends with doe.com
			resultList = session.createQuery("from Student s where s.email LIKE '%doe.com'")
						.getResultList();
			
			System.out.println("\n=========\n" + resultList);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
		System.out.println("Done !");
	}
	
}
