package com.anupam.springboottest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Scope("singleton")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
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
