package com.basu.work;

/**
 * Four score and seven years ago our fathers brought forth 
 * upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal
 * @author sivakumar
 *
 */
public class TextWrapProblem {

	private static String NEW_LINE = "\n";
	private static String BLANK_SPACE = " ";
	public static void main(String[] args) {
		String givenText = "Four score and seven years ago our fathers brought forth"
				+ " upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal";
		int widthOfWordWrap = 13;
		
		StringBuilder wordWrap = new StringBuilder();
		
		for (String word: givenText.split(BLANK_SPACE)) {
			int lastIndex = wordWrap.lastIndexOf(NEW_LINE);
			if (wordWrap.substring(lastIndex+1).length()+1+word.length() <= widthOfWordWrap) {
				wordWrap.append(word);
				wordWrap.append(BLANK_SPACE);
			} else {
				wordWrap.append(NEW_LINE)
						.append(word)
						.append(BLANK_SPACE);
			}
		}
		
		System.out.println(wordWrap);
	
	}
}