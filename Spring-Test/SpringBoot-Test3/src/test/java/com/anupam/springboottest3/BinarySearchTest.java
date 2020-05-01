package com.anupam.springboottest3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//Load the Context
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = "/applicationContext.xml") //when working with XML Context
@ContextConfiguration(classes = SpringBootTest3Application.class)
public class BinarySearchTest {

	//Get the bean from the context
	@Autowired
	BinarySearchImpl binarySearch;
	
	@Test
	public void testBasicScenario() {
		int actualResult = binarySearch.search(new int[] {4, 1, 5, 6}, 3);
		assertEquals("Search Result", 3, actualResult, 0);
	}

}
