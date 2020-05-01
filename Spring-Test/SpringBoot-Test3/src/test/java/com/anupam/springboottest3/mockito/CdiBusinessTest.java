package com.anupam.springboottest3.mockito;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootCdiTestApplication.class)
public class CdiBusinessTest {

	@Autowired
	CdiBusiness cdiBusiness;
	
	@Test
	public void testCdiBusiness() {
		
		int actualResult = cdiBusiness.findGreatest();
		assertEquals("", 100, actualResult, 0);
		
	}

}
