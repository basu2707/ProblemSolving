package com.basu.work;

import java.util.*;

/**
 * 
 Input: n=6
 Output:
     #
    ##
   ###
  ####
 #####
######
 * @author sivakumar
 *
 */
public class StaircaseConstruction {

	static void staircase(int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(' ');
		}
		for (int i = 1; i <= n; i++) {
			sb.setCharAt(n - i, '#');
			System.out.println(sb);
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}

}
