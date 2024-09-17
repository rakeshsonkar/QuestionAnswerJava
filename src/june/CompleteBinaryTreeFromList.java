package june;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeFromList {

	public static TreeNode convertListToCompleteBinaryTree(ListNode head) {
		if (head == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(head.val);
		queue.add(root);
		head = head.next;

		while (head != null) {
			TreeNode current = queue.poll();

			// Left child
			current.left = new TreeNode(head.val);
			queue.add(current.left);
			head = head.next;

			if (head == null)
				break;

			// Right child
			current.right = new TreeNode(head.val);
			queue.add(current.right);
			head = head.next;
		}

		return root;
	}

	// Function to perform level order traversal
	public static void levelOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.val + " ");

			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        TreeNode root1 = convertListToCompleteBinaryTree(head1);
        levelOrderTraversal(root1);  // Output: 1 2 3 4 5
        System.out.println();

        // Example 2
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(1);

        TreeNode root2 = convertListToCompleteBinaryTree(head2);
        levelOrderTraversal(root2);  // Output: 5 4 3 2 1
    }

}

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int val) {
		this.val = val;
		left = right = null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		next = null;
	}
}
