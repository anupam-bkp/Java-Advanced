package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//Build Session Factory
		final SessionFactory factory = new Configuration()
									   .configure("hibernate.cfg.xml")
									   .addAnnotatedClass(Student.class)
									   .buildSessionFactory();
		
		//Create Session object
		Session session = factory.getCurrentSession();
		
		try {

			int studentId=1;	
			System.out.println("Deleting Student with student Id : " + studentId);

			session.getTransaction().begin();
			
		/*	
		    //Delete Student Case-1
			final Student myStudent = session.get(Student.class, studentId);			
			session.delete(myStudent);
		*/
			
			//Delete Student Case-2
			session.createQuery("delete	from Student where id=2").executeUpdate();
			
			//Commit
			session.getTransaction().commit();
			
			System.out.println("Finished Delete operation");
		}
		
		finally {
			factory.close();
		}
	}	
}