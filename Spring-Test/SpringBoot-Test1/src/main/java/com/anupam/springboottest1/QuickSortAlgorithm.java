package com.anupam.springboottest1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm{
	
	@Override
	public int[] sort(int[] numbers){
		
		//Logic for QuickSort
		
		return numbers;
	}
}
