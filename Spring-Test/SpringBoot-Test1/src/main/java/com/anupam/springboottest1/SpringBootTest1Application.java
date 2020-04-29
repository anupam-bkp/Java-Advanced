package com.anupam.springboottest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTest1Application {

	public static void main(String[] args) {
		
//		SpringApplication.run(SpringBootTest1Application.class, args);
		
		final ApplicationContext applicationContext = SpringApplication.run(SpringBootTest1Application.class, args);
		
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		final BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.search(new int[] {12, 3, 4},  3);
		System.out.println(result);
		
	}

}
