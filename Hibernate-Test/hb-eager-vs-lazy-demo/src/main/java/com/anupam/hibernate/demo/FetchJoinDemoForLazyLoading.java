package com.anupam.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;

public class FetchJoinDemoForLazyLoading {

	public static void main(String[] args) {
		
		//Create SessionFactory
		
		final SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetatil.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			//Start a transaction
			session.beginTransaction();
			
			int theId = 1;

			//Get the Instructor
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + instructor);
			
			System.out.println("======Closing the Session=========");
			//Commit Transaction
			session.getTransaction().commit();
			session.close();
			
			//Open new session to fetch courses lazily
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//HQL query to get courses from a given instructor
			final Query<Course> query = session.createQuery("select c from Course c "
									+ "where c.instructor.id=:theInstructorId", 
					Course.class);
			
			query.setParameter("theInstructorId", theId);
			
			final List<Course> courses = query.getResultList();
			System.out.println("Courses : " + courses);
			
			session.getTransaction().commit();
			
			instructor.setCourses(courses);
			
			System.out.println("\n======Finally ========\n");
			System.out.println("Instructor : " + instructor);
			System.out.println("Courses : " + instructor.getCourses());
		}
		finally {
			session.close();
			factory.close();
		}
		
		System.out.println("Done!");
	}
}
