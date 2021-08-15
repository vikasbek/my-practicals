package com.sample.text.problemsolving.tree;

import java.util.Map;
import java.util.TreeMap;

class Node {
	private Integer data;
	private Node left;
	private Node right;

	Node(Integer data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}


public class HorizontalSum {


	public static void main(String[] args) {
		Node root = new Node(5, null, null);
		root.setLeft(new Node(3, null, null));
		root.setRight(new Node(8, null, null));
		
		root.getLeft().setLeft(new Node(4, null, null));
		root.getRight().setRight(new Node(5, null, null));
		
		
		Map<Integer, Integer> horizontalSum = new TreeMap<Integer,Integer>();
//		horizontalSum.put(-1, 1);
//		horizontalSum.put(-5, -5);
//		horizontalSum.put(-4, -4);
//		horizontalSum.put(3, 3);
//		horizontalSum.put(-3, -3);
//		horizontalSum.put(6, -3);
		horizontalSumTree(horizontalSum, root , 0);
		horizontalSum.forEach((k,v) -> {
			System.out.println(k + " " + v);
		});
		
		

	}

	private static void horizontalSumTree(Map<Integer, Integer> horizontalSum, Node root, int lineNo) {
		if(root ==null) {
			return;
		}
		
		if(horizontalSum.containsKey(lineNo)) {
			horizontalSum.put(lineNo, horizontalSum.get(lineNo) + root.getData());
		}else {
			horizontalSum.put(lineNo, root.getData());
		}
		
		horizontalSumTree(horizontalSum, root.getLeft(), lineNo-1);
		horizontalSumTree(horizontalSum, root.getRight(), lineNo+1);
	}


}
