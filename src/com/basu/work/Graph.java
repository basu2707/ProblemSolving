package com.basu.work;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	int vertex;
	LinkedList<Integer> adjacent[];
	
	Graph(int v) {
		this.vertex = v;
		adjacent = new LinkedList[v];
		for (int i=0;i<v;i++) {
			adjacent[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w) {
		adjacent[v].add(w);
	}
	
	public void BFS(int s) {
		boolean visited[] = new boolean[vertex];
		LinkedList<Integer> queue = new LinkedList<>();
		
		
		visited[s] = true;
		queue.add(s);
		
		while (queue.size() != 0) {
			s = queue.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> i = adjacent[s].listIterator();
			while (i.hasNext()) {
				
				int n = i.next();
				
				if (!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}

}
