package com.basu.work;

import java.util.*;

/**
 * Sample Input
 6
-4 3 -9 0 4 1    

Output:
0.500000
0.333333
0.166667

 * @author sivakumar
 *
 */
public class ArrayToPosNegZeroRatios {

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int countPos = 0;
		int countNeg = 0;
		int countZeros = 0;
		int arrayLen = arr.length;
		for (int i = 0; i < arrayLen; i++) {
			if (arr[i] > 0) {
				countPos++;
			} else if (arr[i] == 0) {
				countZeros++;
			} else {
				countNeg++;
			}
		}

		System.out.printf("%.6f %n", ((double) countPos / (double) arrayLen));
		System.out.printf("%.6f %n", ((double) countNeg / (double) arrayLen));
		System.out.printf("%.6f %n", ((double) countZeros / (double) arrayLen));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

}
