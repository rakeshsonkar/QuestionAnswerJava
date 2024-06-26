package june.bt;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
	// Function to perform inorder traversal and store the elements in a list
	private void inorderTraversal(TreeNode root, List<Integer> nodes) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, nodes);
		nodes.add(root.val);
		inorderTraversal(root.right, nodes);
	}

	// Function to build a balanced BST from the sorted list of elements
	private TreeNode buildBalancedBST(List<Integer> nodes, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(nodes.get(mid));
		node.left = buildBalancedBST(nodes, start, mid - 1);
		node.right = buildBalancedBST(nodes, mid + 1, end);
		return node;
	}

	// Main function to convert an unbalanced BST to a balanced BST
	public TreeNode balanceBST(TreeNode root) {
		List<Integer> nodes = new ArrayList<>();
		inorderTraversal(root, nodes);
		return buildBalancedBST(nodes, 0, nodes.size() - 1);
	}

	// Optional: Helper function to print the tree in inorder for testing purposes
	public void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		BalanceBST solution = new BalanceBST();

		// Example 1
		TreeNode root1 = new TreeNode(1);
		root1.right = new TreeNode(2);
		root1.right.right = new TreeNode(3);
		root1.right.right.right = new TreeNode(4);

		TreeNode balanced1 = solution.balanceBST(root1);
		System.out.print("Balanced BST (Example 1): ");
		solution.printInorder(balanced1);
		System.out.println();

		// Example 2
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);

		TreeNode balanced2 = solution.balanceBST(root2);
		System.out.print("Balanced BST (Example 2): ");
		solution.printInorder(balanced2);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
