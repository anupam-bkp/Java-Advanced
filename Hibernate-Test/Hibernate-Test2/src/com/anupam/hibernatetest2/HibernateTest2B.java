package com.anupam.hibernatetest2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.anupam.hibernatetest2.Employee;
import com.anupam.hibernatetest2.AnnotationHibernateTestUtil;

/**
 * 
 * @author Anupam
 *
 */
public class HibernateTest2B {

	public static void main(String[] args) {
		
		SessionFactory sf = AnnotationHibernateTestUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = session.load(Employee.class, 1);
		System.out.println(emp);
		
		tx.commit();
		session.close();
		
		System.out.println("Record read successfully.");
	}
	
}
