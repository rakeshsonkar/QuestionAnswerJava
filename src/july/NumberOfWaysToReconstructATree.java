package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfWaysToReconstructATree {

	public static void main(String[] args) {
		NumberOfWaysToReconstructATree solution = new NumberOfWaysToReconstructATree();
		 // Test case 1
        int[][] pairs1 = {{1, 2}, {2, 3}};
        System.out.println(solution.checkWays(pairs1)); // Output: 1

        // Test case 2
        int[][] pairs2 = {{1, 2}, {2, 3}, {1, 3}};
        System.out.println(solution.checkWays(pairs2)); // Output: 2

        // Test case 3
        int[][] pairs3 = {{1, 2}, {2, 3}, {2, 4}, {1, 5}};
        System.out.println(solution.checkWays(pairs3)); // Output: 0

	}
	
	public int checkWays(int[][] pairs) {
        // To store parent-child relationships
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        
        // Set of all nodes
        Set<Integer> nodes = new HashSet<>();
        
        // Build the tree from the pairs
        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];
            nodes.add(x);
            nodes.add(y);
            
            tree.putIfAbsent(x, new HashSet<>());
            tree.putIfAbsent(y, new HashSet<>());
            
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        
        // Finding the potential roots
        List<Integer> candidates = new ArrayList<>(nodes);
        candidates.sort((a, b) -> tree.get(b).size() - tree.get(a).size());
        
        int root = candidates.get(0);
        
        if (tree.get(root).size() != nodes.size() - 1) {
            return 0;
        }
        
        // Now check if we can build the tree in only one way
        return canFormUniqueTree(tree, root) ? 1 : 2;
    }
	
	private boolean canFormUniqueTree(Map<Integer, Set<Integer>> tree, int root) {
        Map<Integer, Set<Integer>> levels = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(root);
        visited.add(root);
        levels.put(0, new HashSet<>(Arrays.asList(root)));
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            Set<Integer> currentLevel = new HashSet<>();
            
            while (size-- > 0) {
                int node = queue.poll();
                
                for (int child : tree.get(node)) {
                    if (visited.contains(child)) continue;
                    visited.add(child);
                    queue.add(child);
                    currentLevel.add(child);
                }
            }
            
            if (!currentLevel.isEmpty()) {
                levels.put(level, currentLevel);
            }
        }
        
        for (int i = 1; i < levels.size(); i++) {
            Set<Integer> currentLevel = levels.get(i);
            for (int node : currentLevel) {
                  int parentCount = 0;
                
                for (int parent : levels.get(i - 1)) {
                    if (tree.get(parent).contains(node)) {
                         parentCount++; 
                    }
                }
                
                if (parentCount == 0) return false;
                 if (parentCount >1) return false;
            }
        }
        
        return true;
    }

}
