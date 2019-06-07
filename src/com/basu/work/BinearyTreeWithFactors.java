package com.basu.work;

import java.util.HashMap;
import java.util.Map;

public class BinearyTreeWithFactors {

	public static void main(String[] args) {
		//int[] array = {2,4,5,10};
		int[] array = {2,4};
		int count = numFactoredBinaryTrees(array);
		System.out.println(count);
	}
	
	private static int numFactoredBinaryTrees(int[] A) {
        int count = A.length;
        
        Map<Integer, Integer> index = new HashMap<>();
        for(int i=0;i<A.length;i++) {
        	index.put(A[i], i);
        }
        
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<i;j++) {
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                    	count++;
                    }
                }
            }
        }
		return count;
    }

	
/*	long res = 0L, mod = (long) Math.pow(10, 9) + 7;
    Arrays.sort(A);
    HashMap<Integer, Long> dp = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
        dp.put(A[i], 1L);
        for (int j = 0; j < i; ++j)
            if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j]))
                dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
    }
    for (long v : dp.values()) res = (res + v) % mod;
    return (int) res;*/
}
