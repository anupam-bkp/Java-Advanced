package com.example.dbtest.review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfBuilder {

	private static final EmfBuilder INSTANCE = new EmfBuilder();  
	
	private EntityManager em;
	
	private EmfBuilder() {
		//For singleton
	}
	
	public void initialize() {
		buildEntityManager();
	}
	
	public void buildEntityManager() {
		
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("RMS-Application");
		em = emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public static EmfBuilder getInstance() {
		return INSTANCE;
	}
	
}
