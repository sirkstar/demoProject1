package com.java.collections;

import java.util.ArrayList;
import java.util.List;

public class LearnList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("mango");
		list.add("litchi");
		
		for(String fruit: list) {
			System.out.println(fruit);
		}
		
		System.out.println("First fruit: "+list.getFirst());
		
		System.out.println("Second Fruit: "+list.get(1));
		
		list.remove("apple");
		System.out.println("List after removal: "+list);

	}

}
