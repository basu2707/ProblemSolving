package com.basu.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TenMostFrequentWordsInFile {

	public static void main(String[] args) {
		int k=10;
		StringBuilder words = new StringBuilder();
		words.append("Welcome to the world of Geeks");
		words.append("This portal has been created to provide well written well thought and well explained");
		words.append("solutions for selected questions");
		words.append("If you like Geeks for Geeks and would like to contribute");
		words.append("here is your chance You can write article and mail your article to contribute");
		words.append("at geeksforgeeks org See your article appearing");
		words.append("on the Geeks for Geeks main page and help");
		words.append("thousands of other Geeks");

		String[] wordsStr = words.toString().split(" ");
		LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();
		for(int i=0; i<wordsStr.length; i++) {
			wordsCount.put(wordsStr[i], wordsCount.getOrDefault(wordsStr[i], 0)+1);
		}
		
		PriorityQueue<String> heap = new PriorityQueue<>(
				(w1,w2) -> wordsCount.get(w1).equals(wordsCount.get(w2)) ? w2.compareTo(w1) : wordsCount.get(w1) - wordsCount.get(w2));
		
		for (String word: wordsCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);

        System.out.println("common words frequency: "+ ans);
	}

}
