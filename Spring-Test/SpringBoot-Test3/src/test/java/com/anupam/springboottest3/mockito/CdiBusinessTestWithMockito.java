package com.anupam.springboottest3.mockito;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CdiBusinessTestWithMockito {

	//Inject Mock
	@InjectMocks
	CdiBusiness cdiBusiness;

	//Create Mock
	@Mock
	CdiDao cdiDaoMock;
	
	@Test
	public void testCdiBusinessWithMultipleElements() {
		
		//When cdiDao.getData() method is called return new int[]{5, 15, 10}
		Mockito.when(cdiDaoMock.getData()).thenReturn(new int[] {5, 15, 10 });
		
		int actualResult = cdiBusiness.findGreatest();
		assertEquals("", 15, actualResult, 0);
		
	}
	
	@Test
	public void testCdiBusinessWithNoElements() {
		
		//When cdiDao.getData() method is called return new int[]{}
		Mockito.when(cdiDaoMock.getData()).thenReturn(new int[] {});
		
		int actualResult = cdiBusiness.findGreatest();
		assertEquals("", Integer.MIN_VALUE, actualResult, 0);
		
	}
	
	@Test
	public void testCdiBusinessWithEqualElements() {
		
		//When cdiDao.getData() method is called return new int[]{5, 5}
		Mockito.when(cdiDaoMock.getData()).thenReturn(new int[] {5, 5 });
		
		int actualResult = cdiBusiness.findGreatest();
		assertEquals("", 5, actualResult, 0);
	}
	
	

}
