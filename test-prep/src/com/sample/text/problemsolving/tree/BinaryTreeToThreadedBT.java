package com.sample.text.problemsolving.tree;

public class BinaryTreeToThreadedBT {

	static TreeNode convertBTToThreadedBT(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return root;
		}
		TreeNode node = null;

		node = convertBTToThreadedBT(root.getLeft());
		if (node != null && node.getRight() == null) {
			node.predecessor = root;
		}
		node = convertBTToThreadedBT(root.getRight());
		 if(node==null) {
			 return root;
		 }
		return node;
	}

	static void printPredeseccor(TreeNode root) {

		if(root ==null) {
			return;
		}
		if(root.getRight()==null && root.predecessor!=null) {
			System.out.println(root.getData() +"->"+root.predecessor.getData());
		}
		
		printPredeseccor(root.getLeft());
		printPredeseccor(root.getRight());

//		System.out.println(root.predecessor);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getRight().setLeft(new TreeNode(5));
		root.getRight().setRight(new TreeNode(6));

		convertBTToThreadedBT(root);
		printPredeseccor(root);
		
	}
}
