package com.basu.work;

public class BalanceStringByRemovingExtraParentheses {

	private static String str1 = "si)va)v(ku(mar(kollapur))";
	private static String str = "1+5)+5+)6+(5+9)*9";
	public static void main(String[] args) {
	    int count = 0;  
	    int n = str.length();  
	    StringBuilder sb = new StringBuilder();

	    String s1 = "";
	    
	    for (int i = 0; i < n; i++) {  
	        if (str.charAt(i) == '(') {  
	            sb.append(str.charAt(i));
	            count++;  
	        } else if (str.charAt(i) == ')' && count != 0) {  
	            sb.append(str.charAt(i));
	            count--;  
	        }  else if (str.charAt(i) != ')') {
	        	sb.append(str.charAt(i));
	        }
	            
	    }  
	  
	    if (count != 0)  {
	        for (int i = 0; i < count; i++)  {
	        	 sb.append(")");
	        }
	    }
	    System.out.println(sb.toString());     
	}  

}
