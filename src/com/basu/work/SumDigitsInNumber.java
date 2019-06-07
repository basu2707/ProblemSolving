package com.basu.work;

public class SumDigitsInNumber {

	public static void main(String[] args) {
		int sum = sumDigits(10);
		System.out.println("Sum of digits in 10: "+sum);
	}

	static int sumDigits(int n) {
		int sum = 0;
		while (n>0) {
			sum += n % 10;
			n /=10;
		}
		
		return sum;
	}
}
