package com.anupam.hibernatetest1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Inserts Data in DB
 * @author Anupam
 *
 */
public class HibernateTest1A {
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		SessionFactory sf = HibernateTestUtil.getSessionFactory();
		Session session = sf.openSession();
		tx = session.beginTransaction();
		
		Employee emp = new Employee("Mark", "HR", 123l);
		session.save(emp);
		
		tx.commit();
		session.close();
		
		System.out.println("Record Inserted");
	}
}
