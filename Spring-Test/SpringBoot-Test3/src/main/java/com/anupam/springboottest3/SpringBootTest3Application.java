package com.anupam.springboottest3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan("com.anupam.springboottest3")
public class SpringBootTest3Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootTest3Application.class); 
	
	public static void main(String[] args) {
	
//		SpringApplication.run(SpringBootTest3Application.class, args);
//		final ApplicationContext applicationContext = SpringApplication.run(SpringBootTest3Application.class, args);
		
		final AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringBootTest3Application.class);
		
		final BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.search(new int[] {12, 3, 4},  3);
		
		LOGGER.info("{} - {}", result, binarySearch);
		
		applicationContext.close();
	}

}
