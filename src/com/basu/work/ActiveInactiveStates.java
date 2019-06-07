package com.basu.work;

import java.util.ArrayList;
import java.util.List;

public class ActiveInactiveStates {

	public static void main(String[] args) {
		int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
		//int[] states = {1, 1, 1, 0, 1, 1, 1, 1};
		int days = 2;
		System.out.println(findStates(states, days));
	}
	
	private static List<Integer> findStates(int[] states, int days) {
		List<Integer> ar = new ArrayList<>();
        for(int i=1; i<states.length; i++) {
            ar.add(states[i-1]);
        }
        while(days-- > 0) {
            int temp = 0;
            for(int i=1; i<states.length-2; i++) {
                if (i+1 < states.length) {
	            	if(Math.abs(temp-ar.get(i+1))==1) {
	                    temp = ar.get(i);
	                    ar.set(i, 1);
	                }
	                else {
	                    temp = ar.get(i);
	                    ar.set(i, 0);
	                }
                }
            }
        }
        return ar;
	}

}
