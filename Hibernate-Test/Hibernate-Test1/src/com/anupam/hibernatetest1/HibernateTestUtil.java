package com.anupam.hibernatetest1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestUtil {

	private static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		
		if(null != factory) {
			return factory;
		}
		
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
		
		return factory;
	}
	
}
