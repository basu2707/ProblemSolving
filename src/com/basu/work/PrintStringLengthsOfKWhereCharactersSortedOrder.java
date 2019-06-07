package com.basu.work;

public class PrintStringLengthsOfKWhereCharactersSortedOrder {
	static int numChars = 26;
	public static void main(String[] args) {
		printSortedString(5);

	}

	static void printSortedString(int remaining) {
		printSortedString(remaining, "");
	}
	
	static void printSortedString(int remaining, String prefix) {
		if (remaining == 0) {
			if (isInOrder(prefix)) {
				System.out.println(prefix);
			}
		} else {
			for (int i = 0; i < numChars; i++) {
				char c = ithLetter(i);
				printSortedString(remaining-1, prefix+c);
			}
		}
	}

	private static char ithLetter(int i) {
		return (char)(((int) 'a')+i);
	}

	private static boolean isInOrder(String prefix) {
		for (int i = 0; i < prefix.length(); i++) {
			int prev=ithLetter(prefix.charAt(i-1));
			int curr=ithLetter(prefix.charAt(i));
			if (prev>curr) {
				return false;
			}
		}
		return true;
	}
}
