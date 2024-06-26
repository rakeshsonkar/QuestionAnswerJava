package june.bst;

import java.util.ArrayList;

public class BST {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}
		if (root.data > val) {
			// left subtree
			root.left = insert(root.left, val);
		} else {
			// right Subtree
			root.right = insert(root.right, val);
		}
		return root;
	}

	// Inorder travasal
	public static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Search Key CP O(H)
	public static boolean search(Node root, int key) {
		if (root == null) {
			return false;
		}

		if (root.data > key) {
			return search(root.left, key);
		} else if (root.data == key) {
			return true;
		} else {
			return search(root.right, key);
		}
	}

	// Delete Dode
	public static Node delete(Node root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data > val) {
			root.left = delete(root.left, val);
		} else if (root.data < val) {
			root.right = delete(root.right, val);
		} else {
			// Case 1
			if (root.left == null && root.right == null) {
				return null;
			}
			// case 2
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// case 3

			Node IS = inorderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}
		return root;
	}

	public static Node inorderSuccessor(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void printInRange(Node root, int x, int y) {
		if (root == null) {
			return;
		}
		if (root.data >= x && root.data <= y) {
			printInRange(root.left, x, y);
			System.out.print(root.data + " ");
			printInRange(root.right, x, y);
		} else if (root.data > y) {
			printInRange(root.left, x, y);
		} else {
			printInRange(root.right, x, y);
		}

	}

	public static void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.data);
		// leaf
		if (root.left == null && root.right == null) {
			printPath(path);
		} else {//non leaf
			printRootToLeafPaths(root.left, path);
			printRootToLeafPaths(root.right, path);
		}
		path.remove(path.size() - 1);
	}

	private static void printPath(ArrayList<Integer> path) {
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + "->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//int values[] = {8,5,3,6,10,11,14};
		int values[] = {8,5,3,1,4,6,10,11,14};
		Node root = null;
		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}
		inorder(root);
		System.out.println();

		/*
		 * if(search(root,8)) { System.out.println("found"); }else {
		 * System.out.println("Not found"); }
		 */

		// delete(root, 8);
		// inorder(root);
		// System.out.println();

		// printInRange(root, 6, 15);

		// RootToLeafPaths
		printRootToLeafPaths(root,new ArrayList<Integer>());

	}

}
