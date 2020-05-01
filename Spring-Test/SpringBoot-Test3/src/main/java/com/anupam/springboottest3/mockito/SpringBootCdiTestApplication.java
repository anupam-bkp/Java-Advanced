package com.anupam.springboottest3.mockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringBootCdiTestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootCdiTestApplication.class);
	
	public static void main(String[] args) {
		
		final AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringBootCdiTestApplication.class);
		
		final CdiBusiness someCdiBusiness = applicationContext.getBean(CdiBusiness.class);
		
		LOGGER.info("{}  dao-{} ",someCdiBusiness, someCdiBusiness.findGreatest());
	
		applicationContext.close();
	}

}
