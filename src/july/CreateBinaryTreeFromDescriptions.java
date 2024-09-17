package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {
	

	public static void main(String[] args) {
		int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
		CreateBinaryTreeFromDescriptions binaryTreeFromDescriptions= new CreateBinaryTreeFromDescriptions();
		printTree(binaryTreeFromDescriptions.createBinaryTree1(descriptions));
		
	    TreeNode root1 = binaryTreeFromDescriptions.createBinaryTree(descriptions);
        printTree(root1); // Output: [50, 20, 80, 15, 17, 19]

        // Test case 2
        int[][] descriptions2 = {
                {1, 2, 1},
                {2, 3, 0},
                {3, 4, 1}
        };
        TreeNode root2 = binaryTreeFromDescriptions.createBinaryTree(descriptions2);
        printTree(root2); // Output: [1, 2, null, null, 3, 4]
				
	}

	public TreeNode createBinaryTree(int[][] descriptions) {
		Map< Integer, TreeNode> graph= new HashMap<Integer, TreeNode>();
		Set<Integer> children= new HashSet<Integer>();
		
		for(int[] node : descriptions) {
			int parent = node[0];
			int child = node[1];
			boolean isleft=node[2]==1;
			if(!graph.containsKey(parent)) {
				graph.put(parent, new TreeNode(parent));
			}
			if(!graph.containsKey(child)) {
				graph.put(child, new TreeNode(child));
			}
			children.add(child);
			if(isleft) {
				graph.get(parent).left=graph.get(child);
			}else {
				graph.get(parent).right=graph.get(child);
			}
			
		}
		
		for(int key : graph.keySet()) {
			if(!children.contains(key)) {
				return graph.get(key);
			}
		}
		
		return null;
	}
	
	
	public TreeNode createBinaryTree1(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            // Ensure parent node exists
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parentNode);

            // Ensure child node exists
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, childNode);

            // Assign child to the correct position
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Record the child node
            children.add(childVal);
        }

        // The root is the one which is never a child
        TreeNode root = null;
        for (int val : nodeMap.keySet()) {
            if (!children.contains(val)) {
                root = nodeMap.get(val);
                break;
            }
        }

        return root;
    }
	
	// Helper method to print the tree in level order
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }

}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){ this.val=val;}
	TreeNode(int val,TreeNode left,TreeNode right){
		this.val=val;
		this.left=left;
		this.right=right;
	}
	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
}
