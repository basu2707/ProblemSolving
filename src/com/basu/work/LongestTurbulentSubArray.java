package com.basu.work;

/**
 * 
Example 1:
Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])

Example 2:
Input: [4,8,12,16]
Output: 2
Explanation: (A[0] < A[1] < A[2] < A[3])

Example 3:
Input: [100]
Output: 1

Approach 1: Sliding Window
Evidently, we only care about the comparisons between adjacent elements. If the comparisons are represented by -1, 0, 1 (for <, =, >), 
then we want the longest sequence of alternating 1, -1, 1, -1, ... (starting with either 1 or -1).
These alternating comparisons form contiguous blocks. We know when the next block ends: when it is the last two elements being compared, 
or when the sequence isn't alternating.
For example, take an array like A = [9,4,2,10,7,8,8,1,9]. The comparisons are [1,1,-1,1,-1,0,-1,1]. The blocks are [1], [1,-1,1,-1], [0], [-1,1]. 

Algorithm
Scan the array from left to right. If we are at the end of a block (last elements OR it stopped alternating), then we should record the length of 
that block as our candidate answer, and set the start of the new block as the next element.
 * @author sivakumar
 *
 */
public class LongestTurbulentSubArray {

	public static void main(String[] args) {
		//int[] A = {9,4,2,10,7,8,8,1,11};
		int[] A = {4,8,12,16};
		
		int maxLongest = maxTurbulenceSize(A);
		System.out.println(maxLongest);

	}
	
	public static int maxTurbulenceSize(int[] A) {
		int length = A.length;
		int max = 1;
		int index = 0;
		
		for (int i=1;i<length;i++) {
			int comp = Integer.compare(A[i-1], A[i]);
			if (comp == 0) {
				index = i;
			} else if (i == length-1 || comp*Integer.compare(A[i], A[i+1]) != -1) {
				max = Math.max(max, i-index+1);
				index = i;
			}
		}
		
		return max;
	}

}
