package com.anupam.springboottest3.mockito;

import javax.inject.Named;

@Named
public class CdiDao {

	public int[] getData() {
		return new int[] {5, 89, 100};
	}
	
	public CdiDao() {
		System.out.println("CdiDao.CdiDao()");
	}

	
}
