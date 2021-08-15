package com.sample.text.problemsolving.tree;

class AvlNode {

	AvlNode left;
	AvlNode right;
	int data, height = 0;

	public AvlNode(int data) {
		this.data = data;
	}
}


class AVLTree {
	public AvlNode root;

	public int height(AvlNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	int getBalance(AvlNode N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	public AvlNode delete(AvlNode root, int key) {
		if (root == null) {
			return null;
		}

		if (root.data > key) {
			root.left = delete(root.left, key);
		} else if (root.data < key) {
			root.right = delete(root.right, key);
		} else if (root.data == key) {
			if (root.left == null || root.right == null) {
				if (root.left != null) {
					root = root.left;

				} else if (root.right != null) {
					root = root.right;
				} else {
					root = null;
				}
			} else {
				AvlNode smallestRightNode = getSmallestRightNode(root.right);
				root.data = smallestRightNode.data;
				root.right = delete(root.right, smallestRightNode.data);
			}
		}

		if (root == null) {
			return null;
		}

		int diff = Math.subtractExact(getBalance(root.left), getBalance(root.right));
		if (diff > 1 && getBalance(root.left) >= 0) {
			root = rightRotate(root);
		} else if (diff > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			root = rightRotate(root);
		} else if (diff < 1 && getBalance(root.right) <= 0) {
			root = leftRotate(root);
		} else if (diff < 1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			root = leftRotate(root);
		}
		return root;
	}

	private AvlNode getSmallestRightNode(AvlNode root2) {

		if (root2.left == null) {
			return root2;
		} else {
			return getSmallestRightNode(root2.left);
		}

	}

	public AvlNode insert(AvlNode root, int key) {
		if (root == null) {
			root = new AvlNode(key);
			root.left = null;
			root.right = null;
			root.height = 0;
			return root;
		}


		if (root.data < key) {
			root.right = insert(root.right, key);
		} else {
			root.left = insert(root.left, key);
		}

		int diff = Math.subtractExact(height(root.left), height(root.right));
		if (diff > 1 && key < root.left.data) {
			// left, left
			root = rightRotate(root);
		}
		if (diff > 1 && key > root.left.data) {
			// left,right
			root.left = leftRotate(root.left);
			root = rightRotate(root);
		} else if (diff < -1 && key < root.right.data) {
			// right,left
			root.right = rightRotate(root.right);
			root = leftRotate(root);
		} else if (diff < -1 && key > root.right.data) {
			// right,right
			root = leftRotate(root);
		}
		root.height = Math.max(height(root.left), height(root.right));

		return root;
	}


	private AvlNode leftRotate(AvlNode root) {
		if (root == null) {
			return null;
		}
		AvlNode rightnode = root.right;
		if (rightnode != null) {
			root.right = rightnode.left;
		}
		rightnode.left = root;
		return rightnode;
	}

	private AvlNode rightRotate(AvlNode root) {
		if (root == null) {
			return null;
		}
		AvlNode leftNode = root.left;
		if (leftNode != null) {
			root.left = leftNode.right;
		}
		leftNode.right = root;
		return leftNode;
	}

	private AvlNode insertBSTIter(AvlNode root, int key) {
		AvlNode newNode = new AvlNode(key);
		AvlNode parent = null;
		while (root != null) {
			parent = root;
			if (root.data < key) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		if (parent == null) {
			parent = newNode;
			this.root = parent;
			return this.root;
		}
		if (key < parent.data)
			parent.left = newNode;
		else
			parent.right = newNode;

		return parent;
	};

	public static void displayInorder(AvlNode root) {
		if (root == null) {
			return;
		}
		displayInorder(root.left);
		System.out.println(root.data);
		displayInorder(root.right);
	}
}


public class AVLTreeOps {


	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		// tree.root = tree.insert(tree.root, 25);

		/*
		 * The constructed AVL Tree would be 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.displayInorder(tree.root);
		System.out.println();
		tree.root = tree.delete(tree.root, 10);
		tree.displayInorder(tree.root);
	}

}
