package com.anupam.springboottest2.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTest2ScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootTest2ScopeApplication.class);
	
	public static void main(String[] args) {
		
		final ApplicationContext applicationContext = SpringApplication.run(SpringBootTest2ScopeApplication.class, args);

		final PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);
		final PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", personDAO1);
		LOGGER.info("{}", personDAO1.getJdbcConnection());
		
		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO2.getJdbcConnection());
	}

}
