package com.sample.test.amazon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/*
 * Complete the 'foo' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY values
 *  2. INTEGER node1
 *  3. INTEGER node2
 */
class Result {
	static class Node {
		Node left, right;
		int key;
	}

	static Node newNode(int key) {
		Node ptr = new Node();
		ptr.key = key;
		ptr.left = null;
		ptr.right = null;
		return ptr;
	}

	static Node insert(Node root, int key) {
		if (root == null)
			root = newNode(key);
		else if (root.key > key)
			root.left = insert(root.left, key);
		else if (root.key < key)
			root.right = insert(root.right, key);
		return root;
	}

	static int distanceFromRoot(Node root, int x) {
		if (root.key == x)
			return 0;
		else if (root.key > x && root.left != null)
			return 1 + distanceFromRoot(root.left, x);
		else if (root.key < x && root.right != null)
			return 1 + distanceFromRoot(root.right, x);
		else
			return -1;
	}

	static int distanceBetween2(Node root, int a, int b) {
		if (root == null)
			return 0;

		if (root.key > a && root.key > b)
			return distanceBetween2(root.left, a, b);

		if (root.key < a && root.key < b)
			return distanceBetween2(root.right, a, b);

		if (root.key >= a && root.key <= b) {
			int disa = distanceFromRoot(root, a);
			int disb = distanceFromRoot(root, b);
			if (disa < 0 || disb < 0) {
				return -1;
			}
			return disa + disb;
		}

		return 0;
	}

	static int findDistanceBetweenNode(Node root, int a, int b) {
		int temp = 0;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		return distanceBetween2(root, a, b);
	}

	public static int foo(List<Integer> values, int node1, int node2) {
		Node root = null;
		for (Integer i : values) {
			root = insert(root, i);
		}
		return findDistanceBetweenNode(root, node1, node2);
	}
}



public class BSTDistanceBwNode {
	public static void main(String[] args) {
		Integer[] inputArray = { 9, 7, 5, 3, 1, };
		System.out.println(Result.foo(Arrays.asList(inputArray), 7, 20));
	}

}
