package com.sample.text.problemsolving.tree;

import java.util.HashMap;
import java.util.Map;

class BTNode {

	int data;
	BTNode left;
	BTNode right;

	BTNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

}

public class TopView {

	private static Map<Integer, Integer> map = new HashMap<>();
	private static int minVertical = 0;
	private static int maxVertical = 0;
//	         11
//      5          16
//  3       7,15       17
//      14         8
//   13                 9    
//12                         10
	public static void main(String[] args) {
		BTNode root = new BTNode(11);
		root.left = new BTNode(5);
		root.right = new BTNode(16);
		root.left.left = new BTNode(3);
		root.left.right = new BTNode(7);
		root.left.right.right = new BTNode(8);
		root.left.right.right.right = new BTNode(9);
		root.left.right.right.right.right = new BTNode(10);
		
		root.right.left = new BTNode(15);
		root.right.left.left = new BTNode(14);
		root.right.left.left.left = new BTNode(13);
		root.right.left.left.left.left = new BTNode(12);
		
		root.right.right = new BTNode(17);

		printTopView(root, 0);
		
		for(int i=minVertical;i<=maxVertical;i++) {
			System.out.print(map.get(i));
			System.out.print("-->");
		}
	}

	private static void printTopView(BTNode root, int vertical) {
		if (root == null)
			return;
		if (root.left != null)
			printTopViewleft(root.left, vertical-1);
		map.put(vertical, root.data);
		if (root.right != null)
			printTopViewRight(root.right, vertical +1);
	}

	private static void printTopViewleft(BTNode root, int vertical) {
		if (root == null)
			return;

		if (vertical > maxVertical) {
			maxVertical = vertical;
		}
		if (vertical < minVertical) {
			minVertical = vertical;
		}
		if (!map.containsKey(vertical)) {
			map.put(vertical, root.data);
		}
		if (root.left != null)
			printTopViewleft(root.left, vertical -1);

		if (root.right != null)
			printTopViewRight(root.right, vertical + 1);
	}

	private static void printTopViewRight(BTNode root, int vertical) {
		if (root == null)
			return;

		if (vertical > maxVertical) {
			maxVertical = vertical;
		}
		if (vertical < minVertical) {
			minVertical = vertical;
		}

		if (root.left != null)
			printTopViewleft(root.left, vertical -1);

		if (root.right != null)
			printTopViewRight(root.right, vertical+1);

		map.put(vertical, root.data);
	}
}
