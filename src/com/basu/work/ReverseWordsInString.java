package com.basu.work;

public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("t  hello world!  "));
		System.out.println(reverseWords("a good        example"));
	}
	
    public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

}
