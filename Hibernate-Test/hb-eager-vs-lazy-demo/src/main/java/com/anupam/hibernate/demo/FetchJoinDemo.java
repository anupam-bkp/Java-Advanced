package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//Create SessionFactory
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetatil.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//Create Session
		final Session session = factory.getCurrentSession();
		
		try {			
			
			
			//Start a transaction
			session.beginTransaction();
			
			int theId = 1;

			//Option 2: Hibernate query with HQL
			final Query<Instructor> query = 
						session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
									Instructor.class);
			
			//Set the parameter on query
			query.setParameter("theInstructorId", theId);
			
			//Execute the query and get Instructor
			Instructor instructor = query.getSingleResult();
			System.out.println("Instructor: " + instructor);
			
			System.out.println("======Closing the Session=========");
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Courses : " + instructor.getCourses());
			
		}
		finally {
			session.close();
			factory.close();
		}
		
		System.out.println("Done!");
	}
}
