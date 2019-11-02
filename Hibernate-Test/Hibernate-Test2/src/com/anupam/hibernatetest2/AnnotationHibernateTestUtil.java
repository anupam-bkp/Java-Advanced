package com.anupam.hibernatetest2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnnotationHibernateTestUtil {

	private static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		
		if(null != factory) {
			return factory;
		}
		
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
		
		/*Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);*/
		
		return factory;
	}
	
}
