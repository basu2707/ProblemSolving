package com.basu.work;

import java.util.Collections;

/**
 * 
Given two integers A and B, return any string S such that:
S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.

Example 1:
Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:
Input: A = 4, B = 1
Output: "aabaa"

Note:
0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B

If the initial number of As is greater than Bs, we swap A and B.
For each turn, we add 'a' to our string.
If the number of remaining As is greater than Bs, we add one more 'a'.
Finally, we add 'b'.
 * @author sivakumar
 *
 */
public class StringWithoutAAAorBBB {

	public static void main(String[] args) {
		int A = 1;
		int B = 4;
		System.out.println(strWithout3a3b(A, B));
		System.out.println(strWithout3a3bIterative(A, B));
		System.out.println(strWithout3a3bRecursive(A, B));

	}
	
	public static String strWithout3a3b(int A, int B) {
		StringBuilder sb = new StringBuilder();
		char a = 'a', b = 'b';
		int i=A, j=B;
		
		if (B > A) {
			b='a';
			a='b';
			i=B;
			j=A;
		}
		
		while (i-- > 0) {
			sb.append(a);
			if (i > j) {
				sb.append(a);
				--i;
			}
			if (j-- > 0) {
				sb.append(b);
			}
		}
		
		return sb.toString();
	}

	public static String strWithout3a3bIterative(int A, int B) {
		StringBuilder sb = new StringBuilder();
		while (A+B > 0) {
			String str = sb.toString();
			if (str.endsWith("aa")) {
				sb.append("b");
				--B;
			} else if (str.endsWith("bb")) {
				sb.append("a");
				--A;
			} else if (A>B) {
				sb.append("a");
				--A;
			} else {
				sb.append("b");
				--B;
			}
		}
		
		return sb.toString();
	}
	
	public static String strWithout3a3bRecursive(int A, int B) {
        if (A == 0 || B == 0) { // if A or B is 0, return A 'a's or B 'b's.
            String s = (A == 0 ? "b" : "a"); 
            return String.join("", Collections.nCopies(A + B, s)); 
        }
        if (A > B) {
        	return "aab"+strWithout3a3bRecursive(A-2, B-1);
        }
        
        return "bba" + strWithout3a3b(A - 1, B - 2);
	}
}
