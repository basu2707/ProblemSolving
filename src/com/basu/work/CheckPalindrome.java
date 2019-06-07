package com.basu.work;

public class CheckPalindrome {
	public static void main(String[] args) {
		String sample = "Mala y alam" ; 
		//String sample = "madam";
		
		if (sample.equalsIgnoreCase(new StringBuffer(sample).reverse().toString())) {
			System.out.println("Given String is a Palindrome");
		}
	}
}
