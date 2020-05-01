package com.anupam.springboottest2.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.anupam.springboottest2.scan.PersonScanDAO;

@SpringBootApplication
@ComponentScan("com.anupam.springboottest2.scan")
public class SpringBootTest2ScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootTest2ScanApplication.class);
	
	public static void main(String[] args) {
		
		final ApplicationContext applicationContext = SpringApplication.run(SpringBootTest2ScanApplication.class, args);

		final PersonScanDAO personDAO1 = applicationContext.getBean(PersonScanDAO.class);
		final PersonScanDAO personDAO2 = applicationContext.getBean(PersonScanDAO.class);
		
		LOGGER.info("{}", personDAO1);
		LOGGER.info("{}", personDAO1.getJdbcConnection());
		
		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO2.getJdbcConnection());
	}

}
