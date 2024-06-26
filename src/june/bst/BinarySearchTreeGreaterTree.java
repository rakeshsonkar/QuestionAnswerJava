package june.bst;

public class BinarySearchTreeGreaterTree {
	private int sum = 0;
	
	public TreeNode convertBST(TreeNode root) {
        reverseInOrder(root);
        return root;
    }
    
    private void reverseInOrder(TreeNode node) {
        if (node == null) return;
        
        // Traverse right subtree
        reverseInOrder(node.right);
        
        // Update node value with sum of all greater values
        sum += node.val;
        node.val = sum;
        
        // Traverse left subtree
        reverseInOrder(node.left);
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