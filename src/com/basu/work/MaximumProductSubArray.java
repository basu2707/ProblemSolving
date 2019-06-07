package com.basu.work;

import java.util.Arrays;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		//int[] arr = {2, 3, -2, 4, 1, 3, 4, 5};
		int[] arr = {2, 3, -2, 0};
		System.out.println(maxProdSubArray(arr));
		
		int[] arr1 = {-2, 0, -1};
		System.out.println(maxProdOfContiguousSubArray(arr1));

	}

	private static int maxProdSubArray(int[] arr) {
		int result = 1;
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		for (int i=1;i<arr.length;i++) {
			int temp = arr[i] * arr[i-1];
			if (temp > result) {
				result = temp;
			}
		}
		
		return result;
	}
	
	private static int maxProdOfContiguousSubArray(int[] arr) {
        if(arr==null || arr.length<1) return 0;
        if(arr.length < 2) return arr[0];
 
        int result = arr[0];
        int max = arr[0], min = arr[0];
        for(int i=1; i<arr.length; i++) {
            int a = max*arr[i];
            int b = min*arr[i];
            
            max = Math.max(arr[i], Math.max(a, b));
            min = Math.min(arr[i], Math.min(a, b));
            result = Math.max(max, result);
        }
		return result;
	}
}
