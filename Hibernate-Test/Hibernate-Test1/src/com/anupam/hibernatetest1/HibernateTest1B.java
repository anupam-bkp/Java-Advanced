package com.anupam.hibernatetest1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Reads data from DB
 * @author Anupam
 *
 */
public class HibernateTest1B {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateTestUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = session.load(Employee.class, 1);
		System.out.println(emp);
		
		tx.commit();
		session.close();
		
		System.out.println("Record read successfully.");
	}
	
}
