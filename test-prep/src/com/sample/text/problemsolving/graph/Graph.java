package com.sample.text.problemsolving.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int v;
	private List<ArrayList<Integer>> adj;

	Graph(int v) {
		adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	void addUndirectedEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	void adddirectedEdge(int v, int w) {
		adj.get(v).add(w);
	}

	void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + "--->");
			}
			System.out.println();
		}
	}

	public List<ArrayList<Integer>> getAdj() {
		return adj;
	}

}
