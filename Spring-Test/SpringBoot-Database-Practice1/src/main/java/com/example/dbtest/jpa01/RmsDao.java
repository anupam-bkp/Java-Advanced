package com.example.dbtest.jpa01;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RmsDao {

	@Autowired
	private EntityManager em;
	
	public ProjectDetail getPrjDetailById(int id) {
		return em.find(ProjectDetail.class, id);
	}
	
}
