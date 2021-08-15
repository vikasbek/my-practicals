package com.sample.text.problemsolving.tree;

public class BinaryTreeProblems {


	public static void main(String[] args) {
		TreeNode root = new TreeNode(500);
		root.setLeft(new TreeNode(200));
		root.setRight(new TreeNode(700));

		root.getLeft().setLeft(new TreeNode(100));
		root.getLeft().setRight(new TreeNode(300));

		root.getRight().setLeft(new TreeNode(400));
		root.getRight().setRight(new TreeNode(800));

		printLevel(root, 2, 3);
	}
	
	private static void printLevel(TreeNode root, int l1, int l2){
	    if(root == null){
	        return;
	    }
	    printLevel(root, 1, l1, l2);
	    
	}


	private static void printLevel(TreeNode root, int currLevel, int l1, int l2){

	    if(root == null){
	        return;
	    }

	    if(currLevel>= l1 && currLevel<=l2 ){
	        System.out.println(root.getData()+ " ");
	    }
	    printLevel(root.getLeft(),currLevel + 1, l1, l2);
	    printLevel(root.getRight(),currLevel + 1, l1, l2);
	    
	}

}
