package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfGoodLeafNodesPairs {
	public static void main(String[] args) {
		
	}
	
	
	
	/*
	 * Algorithm 
	 * Initialize an adjacency list to convert the tree into a graph.
	 * Initialize a set to store the leaf nodes of the tree. Use a helper method
	 * traverseTree to traverse the tree to build the graph and find the leaf nodes.
	 * Maintain the current node as well as the parent node in the parameters. 
	 * If the current node is a leaf node, add it to the set initialize in step 2.
	 *  In the adjacency list, add the current node to the parent node's list of
	 * neighbors. Also, add the parent node to the current node's list of neighbors.
	 * Recursively call traverseTree for the current node's left child and right
	 * child. 
	 * Initialize an ans variable to count the number of good leaf node
	 * pairs. 
	 * Iterate through each leaf node in the set: 
	 * Run BFS for the current
	 * leaf node. BFS can be terminated early once all nodes that are a distance
	 * away from the current leaf node are discovered. Increment ans for every leaf
	 * node encountered in each BFS run.
	 *  Return ans / 2. We count each pair twice so we need to divide by 2 to get the actual count.
	 */
	 public static int countPairs(TreeNode root, int distance) {
		Map<TreeNode , List<TreeNode>> graph =new HashMap<>();
		Set<TreeNode> leafNodes = new  HashSet<>();
		
		traverseTree(root,null,graph,leafNodes);
		int ans =0;
		for(TreeNode left : leafNodes) {
			Queue<TreeNode> bfsQueue = new LinkedList<>();
			Set<TreeNode> seen = new HashSet<>();
			bfsQueue.add(left);
			seen.add(left);
			for(int i =0;i<=distance; i++) {
				int size=bfsQueue.size();
				for(int j=0;j<size;j++) {
					TreeNode cuurNode=bfsQueue.remove();
					if(leafNodes.contains(cuurNode) && cuurNode != leafNodes) {
						ans++;
					}
					if(graph.containsKey(cuurNode)) {
						for(TreeNode neighbor : graph.get(cuurNode)) {
							if(!seen.contains(neighbor)) {
								bfsQueue.add(neighbor);
								seen.add(neighbor);
							}
						}
					}
				}
			}
		}
		return ans/2;
	 }
	private static void traverseTree(TreeNode currNode,
			 TreeNode prevNode,
			Map<TreeNode, List<TreeNode>> graph,
			Set<TreeNode> leafNodes) {
		if(currNode ==null) {
			return;
		}
		if(currNode.left == null && currNode.right==null) {
			leafNodes.add(currNode);
		}
		if(prevNode != null) {
			graph.computeIfAbsent(prevNode, k-> new ArrayList<>());
			graph.get(prevNode).add(currNode);
			graph.computeIfAbsent(currNode, k-> new ArrayList<>());
			graph.get(currNode).add(prevNode);
		}
		
		traverseTree(currNode.left, currNode, graph, leafNodes);
		traverseTree(currNode.right, currNode, graph, leafNodes);
		
	}
	
	// -----------------------------------------second solution -------------------------------------
	
	///Post-Order Traversal
	
	//Algorithm
	//Define postOrder(TreeNode currentNode, int distance) helper function. This function will return an array that contains the count of leaf nodes for all possible distances from currentNode (currentNode[0] to currentNode[10]), as well as the total number of good leaf nodes pairs rooted at currentNode (currentNode[11]).
			//If currentNode is null, then return an empty array with all 0s.
			//If currentNode is a leaf node, then return an array where the count for leaf nodes with distance 0 is set to 1.
			//Recursively call postOrder on the left subtree and store the result in the left array.
			//Recursively call postOrder on the right subtree and store the result in the right array.
			//Initialize a current array.
			//Shift the counts in left and right by 1 in current. Specifically, for each distance d:
			//current[d+1] = left[d] + right[d].
			//Initialize current[11] to left[11] + right[11]. This is the total number of good leaf nodes pairs under the left and right subtrees.
			//For all distance pairs (d1, d2):
			//If 2 + d1 + d2 <= distance, then current[11] += left[d1] + right[d2].
			//Return current.
			//Return postOrder(root, distance)[11], the total number of good leaf nodes pairs rooted at root.
	
	public int countPairs1(TreeNode root, int distance) {
        return postOrder(root, distance)[11];
    }



	private int[] postOrder(TreeNode currentNode, int distance) {
		if(currentNode ==null) return new  int[12];
		else if (currentNode.left == null && currentNode.right == null) {
			int[] current = new int[12];
			current[0]=1;
			return current;
		}
		// leaft node count for a given  distance i
		int []left = postOrder(currentNode.left, distance);
		int [] right = postOrder(currentNode.right, distance);
		int[] current = new int[12];
		for(int i=0;i<10;i++) {
			current[i+1] +=left[i] + right[i];
		}
		current[11] +=left[11] + right[11];
		for(int d1=0;d1<=distance;d1++) {
			for(int d2=0;d2<=distance;d2++) {
				if(2+d1+d2<=distance) {
					current[11] +=left[d1]*right[d2];
				}
			}
		}
		return current;
	}
	
	
	
		 
}
