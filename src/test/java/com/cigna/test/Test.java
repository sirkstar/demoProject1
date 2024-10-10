package com.cigna.test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String original = "Hello World!";
		String rev = new StringBuilder(original).reverse().toString();
//		
//		for(int i = original.length()-1;i>=0;i--) {
//			rev+=original.charAt(i);
//		}
		
		System.out.println(rev);
		
		Test anagrams = new Test();
		System.out.println(anagrams.areAnagrams("listen", "Krishna"));
	}
	
	public boolean areAnagrams(String str1, String str2) {
	    char[] arr1 = str1.toCharArray();
	    char[] arr2 = str2.toCharArray();
	    Arrays.sort(arr1);
	    Arrays.sort(arr2);
	    return Arrays.equals(arr1, arr2);
	}

}
