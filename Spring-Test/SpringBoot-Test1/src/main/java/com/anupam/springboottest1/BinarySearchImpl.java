package com.anupam.springboottest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

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
	
}
