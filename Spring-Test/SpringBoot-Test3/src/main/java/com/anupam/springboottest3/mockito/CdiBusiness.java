package com.anupam.springboottest3.mockito;

import java.util.Arrays;
import java.util.OptionalInt;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CdiBusiness {
	
	@Inject
	private CdiDao cdiDao;

	public CdiDao getCdiDao() {
		return cdiDao;
	}
	
	public int findGreatest() {
				
		int[] data = cdiDao.getData();
		
		final OptionalInt max = Arrays.stream(data).max();
		
		if(max.isPresent()) {
			return max.getAsInt();
		}else {
			return Integer.MIN_VALUE;
		}
		
	}
}
