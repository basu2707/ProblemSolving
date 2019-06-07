package com.basu.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CompareListOfStrings {

	public static void main(String[] args) {
		List<Character> inputList = new ArrayList<>();
		inputList.add('z');
		inputList.add('z');
		inputList.add('c');
		inputList.add('b');
		inputList.add('z');
		inputList.add('c');
		inputList.add('h');
		inputList.add('f');
		inputList.add('i');
		inputList.add('h');
		inputList.add('i');
		Map<Character, Integer> charPart = new HashMap<>();
		
		for (int i=0;i<inputList.size();i++) {
			Character character = inputList.get(i);
			int count = charPart.containsKey(character) ? charPart.get(character) : 0;
			charPart.put(character, count+1);
		}
		List<Integer> list = new ArrayList<>();
		list.addAll(charPart.values()); 
		Collections.sort(list);
		System.out.println(list);
	/*	List<String> strList = new ArrayList<>();
		strList.add("t2 l3 121 98");
		strList.add("r1 box ape bit");
		strList.add("b4 xi me nu");
		
		for (int i=0;i<strList.size();i++) {
			String[] str = strList.get(i).split(" ");
			
			
			
		}
		
		Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
		System.out.println(strList);*/
		
	}

}
