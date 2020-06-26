package com.example.dbtest.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorJpaDaoImpl implements InstructorJpaDao{

	/*
	 * @Autowired private SessionFactory factory;
	 */
	@Autowired
	private EntityManager factory;

	@Override
	public List<Instructor> getAllInstructors() {
		
//		final Session session = factory.getCurrentSession();
		
		List<Instructor> instructors = 
				factory.createQuery("select i from Instructor i", Instructor.class).getResultList();

		return instructors;
	}
	
}
