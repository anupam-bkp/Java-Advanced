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
public class HibernateTest2A {
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		SessionFactory sf = AnnotationHibernateTestUtil.getSessionFactory();
		Session session = sf.openSession();
		tx = session.beginTransaction();
		
		Employee emp = new Employee("Mark", "HR-EMP", 123344l);
		session.save(emp);
		
		tx.commit();
		session.close();
		
		System.out.println("Record Inserted");
	}

}
