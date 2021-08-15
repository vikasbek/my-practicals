package com.sample.text.problesolving.array;

//User defined node class 
class Node { 
int data; 
Node left, right; 
// Constructor to create a new tree node 
Node(int key) 
{ 
	data = key; 
	left = right = null; 
} 
} 

class HeightSpecialTree { 

// function to check if given node is a leaf node or node 
static boolean isLeaf(Node node) 
{ 
		// If given node's left's right is pointing to given node 
		// and its right's left is pointing to the node itself 
		// then it's a leaf 
		return (node.left != null && node.left.right == node && 
				node.right != null && node.right.left == node); 
				
} 
/* Compute the height of a tree -- the number of 
Nodes along the longest path from the root node 
down to the farthest leaf node.*/
static int maxDepth(Node node) 
{ 
		// if node is NULL, return 0 
		if (node == null) 
			return 0; 

		// if node is a leaf node, return 1 
		if (isLeaf(node)) 
			return 1; 

		// compute the depth of each subtree and take maximum 
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); 
} 

// Driver code 
public static void main(String args[]) 
{ 
		Node root = new Node(1); 
		
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.left.left.left = new Node(6); 

		// Given tree contains 3 leaf nodes 
		Node L1 = root.left.left.left; 
		Node L2 = root.left.right; 
		Node L3 = root.right; 

		// create circular doubly linked list out of 
		// leaf nodes of the tree 
	
		// set next pointer of linked list 
		L1.right = L2; L2.right = L3; L3.right = L1; 

		// set prev pointer of linked list 
		L3.left = L2; L2.left = L1; L1.left = L3; 

		// calculate height of the tree 
		System.out.println("Height of tree is " + maxDepth(root)); 
} 
} 
//This code is contibuted by rachana soma 
