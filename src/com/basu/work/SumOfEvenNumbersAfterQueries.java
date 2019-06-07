package com.basu.work;

import java.util.Arrays;

/**
 * 
 Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * @author sivakumar
 *
 */
public class SumOfEvenNumbersAfterQueries {

	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
		
		int[] sumOfEven = sumEvenAfterQueries(A, queries);
		System.out.println(Arrays.toString(sumOfEven));
	}

	 private static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		 int sum = 0;
		 for (int val : A) {
			 if (val % 2 == 0) {
				 sum += val;
			 }
		 }
		 
		 int[] ans = new int[queries.length];
		 
		 for (int i=0;i<queries.length;i++) {
			 int value = queries[i][0], index = queries[i][1];
			 
			 if (A[index] % 2 == 0) {
				 sum -= A[index];
			 }
			 A[index] += value;
			 if (A[index] % 2 == 0) {
				 sum += A[index];
			 }
			 ans[i] = sum;
		 }
		 
		 return ans;
	 }
}
