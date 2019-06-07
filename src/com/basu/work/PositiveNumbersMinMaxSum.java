package com.basu.work;

import java.util.*;

/**
 * 
For example, arr = [1,3,5,7,9]. Our minimum sum is 1+3+5+7=16 and our maximum sum is 3+5+7+9=24. We would print
16 24
 * @author sivakumar
 *
 */
public class PositiveNumbersMinMaxSum {

	    // Complete the miniMaxSum function below.
	    static void miniMaxSum(int[] arr) {
	        long min = 0;
	        long max = 0;
	        for (int i=0;i<arr.length;i++) {
	            long temp = 0;
	            for (int j=0;j<arr.length;j++) {
	                if (i != j) {
	                    temp = temp + arr[j];
	                }
	            }
	            if (min == 0 || min > temp) {
	                min = temp;
	            }
	            if (max < temp) {
	                max = temp;
	            }
	        }
	        System.out.println(min + " " + max);
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int[] arr = new int[5];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < 5; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        miniMaxSum(arr);

	        scanner.close();
	    }

}
