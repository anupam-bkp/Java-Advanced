package com.example.dbtest;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.dbtest.entities.Employees;
import com.example.dbtest.entities.Employees_;

public class RetrieveTest1 {
	
	public static void main(String[] args) {
		
		final SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employees.class)
								.buildSessionFactory();
		
		final Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		//Using javax.persistence.criteria
		
		final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		
		//building typed query
		final CriteriaQuery<Employees> criteriaQuery = 
				criteriaBuilder.createQuery(Employees.class);
		
		final Root<Employees> root = criteriaQuery.from(Employees.class);
		criteriaQuery.select(root);
		
		criteriaQuery.where(
				criteriaBuilder.equal(root.get(Employees_.FIRST_NAME),
						"Anupam"));
		
		final List<Employees> resultList = session.createQuery(criteriaQuery).getResultList();
		
		System.out.println("====Printing Result through Criteria API");
		System.out.println(resultList);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}

}
