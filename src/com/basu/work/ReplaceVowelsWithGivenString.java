package com.basu.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceVowelsWithGivenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toGoatLatin(String S) {
        String[] subStr = S.split(" ");
        int countConstant = 1;
        
        List<String> vowels = new ArrayList<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");
        
        char charToRepeat = 'a';
        
        StringBuilder strBuild = new StringBuilder();
        for (int i=0;i<subStr.length;i++) {
            char charAt = subStr[i].charAt(0);
			if (vowels.contains(String.valueOf(charAt))) {
            	char[] chars = new char[countConstant];
            	Arrays.fill(chars, charToRepeat);
				strBuild.append(subStr[i]).append("ma").append(String.valueOf(chars));
            } else {
            	char firstStr = subStr[i].charAt(0);
            	//subStr[i].replace(firstStr, );
            }
        }
        
        return "";
    }

}
