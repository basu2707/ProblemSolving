package com.basu.work;

import java.math.BigInteger;

public class ExtraLongFactorial {

	public static void main(String[] args) {
		
		System.out.println(factorial(25));
	}
	
	private static BigInteger factorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i=n;i>1;i--) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

}
