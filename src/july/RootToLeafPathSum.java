package july;

public class RootToLeafPathSum {
	static boolean hasPathSum(Node root, int target) {
	        if (root == null) {
	            return false;
	        }
	        if (root.left == null && root.right == null) {
	            return target == root.data;
	        }
	        return hasPathSum(root.left, target - root.data) || hasPathSum(root.right, target - root.data);
	    }
	
	 public static void main(String[] args) {
	        // Create the tree:
	        //       10
	        //      /  \
	        //     8    2
	        //    / \  / \
	        //   3  5 2  6
	        Node root = new Node(10);
	        root.left = new Node(8);
	        root.right = new Node(2);
	        root.left.left = new Node(3);
	        root.left.right = new Node(5);
	        root.right.left = new Node(2);
	        root.right.right = new Node(6);

	 
	        int target = 21;
	        if (hasPathSum(root, target)) {
	            System.out.println("There is a root-to-leaf path with sum " + target);
	        } else {
	            System.out.println("There is no root-to-leaf path with sum " + target);
	        }

	        target = 14;
	        if (hasPathSum(root, target)) {
	            System.out.println("There is a root-to-leaf path with sum " + target);
	        } else {
	            System.out.println("There is no root-to-leaf path with sum " + target);
	        }
	    }

}
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}