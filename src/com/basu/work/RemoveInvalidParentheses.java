package com.basu.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).

Input: "()())()"
Output: ["()()()", "(())()"]

Input: "(a)())()" 
Output: ["(a)()()", "(a())()"]

Input: ")("
Output: [""]
 * @author sivakumar
 *
 */
public class RemoveInvalidParentheses {

	public static void main(String[] args) {

		String input = "()())()";
		String input1 = "(a)())()";
		String input2 = ")(";
		removeInvalidParentheses(input1);
	}

	private static List<String> removeInvalidParentheses1(String s) {
        int count = 0;
        int n = s.length();
       
        List<String> list = new ArrayList<>();
        String str = "";
        
        for (int i=0; i<n ;i++) {
            if (s.charAt(i) == '(') {
                str = str + s.charAt(i);
                count++;
            } else if (s.charAt(i) == ')' && count != 0) {
                str = str + s.charAt(i);
                count--;
            } else if (s.charAt(i) != ')') {
                str = str + s.charAt(i);
            } 
        }
        
        if (count != 0) {
            for (int i=0; i<count; i++) {
               str = str + ')';
            }
        }
        
        list.add(str.toString());

        return list;
    }
	
    static ArrayList<String> result = new ArrayList<String>();
    static int max=0; 
 
    private static List<String> removeInvalidParentheses(String s) {
        if(s==null)
            return result;
 
        dfs(s, "", 0, 0);
        if(result.size()==0){
            result.add("");
        }
 
        return result;
    }
 
    private static void dfs(String left, String right, int countLeft, int maxLeft){
        if(left.length()==0){
            if(countLeft==0 && right.length()!=0){
                if(maxLeft > max){
                    max = maxLeft;
                }
 
                if(maxLeft==max && !result.contains(right)){
                    result.add(right);
                }
            }
 
            return;
        }
 
        if(left.charAt(0)=='('){
            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
        }else if(left.charAt(0)==')'){
            if(countLeft>0){
                dfs(left.substring(1), right+")", countLeft-1, maxLeft);
            }
 
            dfs(left.substring(1), right, countLeft, maxLeft);
 
        }else{
            dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
        }
    }
}
