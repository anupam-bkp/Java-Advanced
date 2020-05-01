package com.anupam.springboottest1.cdi;

import javax.inject.Named;

@Named
public class CdiDao {

	public CdiDao() {
		System.out.println("CdiDao.CdiDao()");
	}

	
}
