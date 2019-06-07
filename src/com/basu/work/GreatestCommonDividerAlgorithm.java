package com.basu.work;

public class GreatestCommonDividerAlgorithm {

	public static void main(String[] args) {
		int num = 5;
		//int[] arr = { 2, 4, 6, 8, 10 };
		// int[] arr = {2, 3, 4, 5, 6};
		 int[] arr = {40, 32, 16, 8, 4};
		System.out.println(greatestCommonDivider(num, arr));
	}

	private static int greatestCommonDivider(int num, int[] arr) {
		int result = arr[0];
		for (int i = 0; i < arr.length; i++) {
			result = gcd(arr[i], result);
		}

		return result;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

}
