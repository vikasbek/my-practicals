package com.sample.text.problemsolving.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

	public static void main(String[] args) {
		undirected_BFS_DFS();

	}

	private static void undirected_BFS_DFS() {
		Graph g = new Graph(5);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(1, 3);
		g.addUndirectedEdge(2, 4);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(1, 4);

		g.printGraph();
//		for (int i = 0; i < 8; i++) {
//			System.out.print(i + " ");
//		}
		printBFS(g);
		printDFS(g);
	}

	private static void printBFS(Graph g) {
		boolean visited[] = new boolean[5];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
//		visited[0] = true;

		while (!queue.isEmpty()) {
			Integer frontElement = queue.poll();
			if (!visited[frontElement]) {
				System.out.print(frontElement + ", ");
				visited[frontElement] = true;
			}
			for (Integer v : g.getAdj().get(frontElement)) {
				if (!visited[v]) {
					queue.add(v);
				}
			}

		}

	}

	private static void printDFSutil(boolean[] visited, List<ArrayList<Integer>> list, int v) {
		if (visited[v]) {
			return;
		}
		System.out.print(v + ", ");
		visited[v] = true;
		for (Integer i : list.get(v)) {
			printDFSutil(visited, list, i);
		}
	}

	private static void printDFS(Graph g) {
		boolean visited[] = new boolean[5];

		printDFSutil(visited, g.getAdj(), 0);

	}

}
