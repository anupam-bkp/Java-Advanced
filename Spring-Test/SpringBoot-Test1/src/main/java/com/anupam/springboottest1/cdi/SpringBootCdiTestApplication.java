package com.anupam.springboottest1.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCdiTestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootCdiTestApplication.class);
	
	public static void main(String[] args) {
		
		final ApplicationContext applicationContext = SpringApplication.run(SpringBootCdiTestApplication.class, args);
		
		final CdiBusiness someCdiBusiness = applicationContext.getBean(CdiBusiness.class);
		
		LOGGER.info("{}  dao-{} ",someCdiBusiness, someCdiBusiness.getCdiDao());
	}

}
