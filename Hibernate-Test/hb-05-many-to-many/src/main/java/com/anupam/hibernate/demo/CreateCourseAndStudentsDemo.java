package com.anupam.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anupam.hibernate.demo.entity.Course;
import com.anupam.hibernate.demo.entity.Instructor;
import com.anupam.hibernate.demo.entity.InstructorDetatil;
import com.anupam.hibernate.demo.entity.Review;
import com.anupam.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//Create a course
			Course course = new Course("Java");
			
			//Save the course
			session.save(course);
			
			//Create the students			
			Student student1 = new Student("Anupam", "Kumar", "anupam@kumar.com");
			Student student2 = new Student("Pawan", "Singh", "pawan@singh.com");
			
			//add the students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		
		
		
	}
	
}
