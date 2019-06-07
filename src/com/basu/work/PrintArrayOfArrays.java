package com.basu.work;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintArrayOfArrays {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer> array1 = new ArrayList<>();
		array1.add(1);
		array1.add(2);
		array1.add(3);
		array1.add(4);
		A.add(array1);
		
		array1 = new ArrayList<>();
		array1.add(5);
		array1.add(6);
		array1.add(7);
		array1.add(8);
		A.add(array1);
		
		array1 = new ArrayList<>();
		array1.add(9);
		array1.add(10);
		array1.add(11);
		array1.add(12);
		A.add(array1);
		
		ArrayList<ArrayList<Integer>> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
		    for (int j = 0; j < B.get(i).size(); j++) {
		            System.out.print(B.get(i).get(j) + " ");
		    }
		}

	}

	private static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
}
}
