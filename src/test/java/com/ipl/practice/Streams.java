package com.ipl.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {

		List<Integer> numberList = Arrays.asList(10,15,20,25,30);
		
		List<Integer> evenNumberList = new ArrayList<Integer>();
		
		for(int n: numberList) {
			if(n%2==0)
				evenNumberList.add(n);
		}
		System.out.println("Without streams: "+evenNumberList);
		
//		List<Integer> streamNumbers = numberList.stream();
		
//		evenNumberList=numberList.stream().filter(n->n%2==0).collect(Collectors.toList());
//		System.out.println("With Streams: "+evenNumberList);
		
		numberList.stream().filter(n->n%2==0).forEach(n->System.out.println(n));
	}

}
