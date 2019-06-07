package com.basu.work;

import java.io.*;
import java.util.*;

/**
 * 
 Input: Birthday: 10
44 53 31 27 77 60 66 77 26 36
 result: 2
 
 Input: Birthday:4
3 2 1 3
 result: 2
 
 Input: 10
18 90 90 13 90 75 90 8 90 43
result: 5
 * @author sivakumar
 *
 */
public class BirthdayCandlesAlgorithm {


	    // Complete the birthdayCakeCandles function below.
	    static int birthdayCakeCandles(int[] ar) {
	        int count = 0;
	        int max = ar[0];
	        for (int i=0;i<ar.length;i++) {
	            if (ar[i] > max) {
	                max = ar[i];
	            } 
	        }

	        for(int i=0;i<ar.length;i++){
	                if(ar[i]==max){
	                    count++;
	                }
	            }
	        return count;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	    	
	        int[] arr = new int[10];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < arr.length; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        int result = birthdayCakeCandles(arr);
	        System.out.println(result);
	        scanner.close();
	    }

}
