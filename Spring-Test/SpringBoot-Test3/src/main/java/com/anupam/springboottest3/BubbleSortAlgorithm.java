package com.anupam.springboottest3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm{
	
	@Override
	public int[] sort(int[] numbers){
		
		//Logic for BubbleSort
		
		return numbers;
	}
}
