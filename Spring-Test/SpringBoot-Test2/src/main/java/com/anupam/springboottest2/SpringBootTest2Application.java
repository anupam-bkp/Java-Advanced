package com.anupam.springboottest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTest2Application {

	public static void main(String[] args) {
		final ApplicationContext applicationContext = SpringApplication.run(SpringBootTest2Application.class, args);

		final BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
		final BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
		
		System.out.println(binarySearch1);
		System.out.println(binarySearch2);
		
		/*int result = binarySearch.search(new int[] {12, 3, 4},  3);
		System.out.println(result);*/
	}

}
