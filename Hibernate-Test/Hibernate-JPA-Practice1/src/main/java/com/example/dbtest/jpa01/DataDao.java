package com.example.dbtest.jpa01;

import javax.persistence.EntityManager;

public class DataDao {
	
	private static DataDao INSTANCE = new DataDao();

	private EntityManager em;
	
	private DataDao() {
		//For Singleton
	}
	
	public void initialize() {
		final EmfBuilder emfBuilder = EmfBuilder.getInstance();
		emfBuilder.initialize();
		em = emfBuilder.getEntityManager();
	}
	
	public static DataDao getInstance() {
		return INSTANCE;
	}

	public Object getEntityById(Class<?> cls, int id) {
		return em.find(cls, id);
	}
	
}
