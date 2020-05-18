package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;
import com.anupam.hibernate.demo.entity.Review;
import com.anupam.hibernate.demo.entity.Student;

public class DeleteAnupamStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetatil.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
								
		//Create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
		
			//get Student Anupam from Database
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Loaded Student : " + student);
			System.out.println("Already Enrolled Courses : " + student.getCourses());
			
			//delete student
			System.out.println("Deleting Student : " + student);
			session.delete(student);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
	}
	
}
