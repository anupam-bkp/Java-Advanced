package com.anupam.springboottest3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
//	private SortAlgorithm quickSortAlgorithm;
	@Qualifier("quick")
//	@Qualifier("bubble")
	private SortAlgorithm sortAlgorithm;
	
	public int search(int[] numbers, int numberToSearchFor) {
		
		//Logic for BinarySearch		
		
		//1. Sort the array
		int[] result = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm);
		
		//2. Search the Array
		
		return 3;
	}
	
	@PostConstruct
	public void postConstruct() {
		logger.info("Post Construct");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("Pre Destroy");
	}
	
}
