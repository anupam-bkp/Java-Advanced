package com.anupam.springboottest1.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * Reads value from external properties file
 *
 */

@SpringBootApplication
@PropertySource("classpath:external.properties")
public class SpringBootExternalPropertiesFileTestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootExternalPropertiesFileTestApplication.class);
	
	public static void main(String[] args) {
		
		final ApplicationContext applicationContext = SpringApplication.run(SpringBootExternalPropertiesFileTestApplication.class, args);
		
		final ExternalService service = applicationContext.getBean(ExternalService.class);
		
		LOGGER.info("{}  value-{} ",service, service.getUrl());
	}

}
