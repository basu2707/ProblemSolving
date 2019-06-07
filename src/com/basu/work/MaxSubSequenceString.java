package com.basu.work;

public class MaxSubSequenceString {
	
	static final int MAX = 1000; 
	
	public static void main(String[] args) {
		char x[] = "ABCD".toCharArray();
		char y[] = "BACDBDCD".toCharArray();
		
		int n=x.length, m=y.length;
		System.out.println(maxSubsequenceSubstring(x,y,n,m));
	}

	private static int maxSubsequenceSubstring(char[] x, char[] y, int n, int m) {
		int dp[][] = new int[MAX][MAX];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[j-1] == y[i-1]) {
					dp[i][j] = 1+ dp[i-1][j-1];
					System.out.println("LINE 28: "+dp[i][j]);
				} else {
					dp[i][j]=dp[i][j-1];
					System.out.println("LINE 31: "+dp[i][j]);
				}
			}
			
		}
		
        // Finding the maximum length. 
        int ans = 0; 
        for (int i = 1; i <= m; i++) 
            ans = Math.max(ans, dp[i][n]); 
       
        return ans; 
	}
	
}
