package july;

import java.util.ArrayList;
import java.util.List;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {

	 public static class TreeNode {
	        int val;
	        TreeNode left, right;
	        TreeNode(int val) {
	            this.val = val;
	            this.left = null;
	            this.right = null;
	        }
	    }
	 
	 public String getDirections(TreeNode root, int startValue, int destValue) {
	        // Find paths from root to startValue and destValue
	        List<Character> pathToStart = new ArrayList<>();
	        List<Character> pathToDest = new ArrayList<>();
	        
	        findPath(root, startValue, pathToStart);
	        findPath(root, destValue, pathToDest);
	        
	        // Find the common path length
	        int i = 0, commonLength = Math.min(pathToStart.size(), pathToDest.size());
	        while (i < commonLength && pathToStart.get(i) == pathToDest.get(i)) {
	            i++;
	        }
	        
	        // Construct the directions
	        StringBuilder directions = new StringBuilder();
	        
	        // Add 'U' for the remaining part of pathToStart
	        for (int j = i; j < pathToStart.size(); j++) {
	            directions.append('U');
	        }
	        
	        // Add remaining part of pathToDest
	        for (int j = i; j < pathToDest.size(); j++) {
	            directions.append(pathToDest.get(j));
	        }
	        
	        return directions.toString();
	    }
	    
	    // Helper method to find the path from root to targetValue
	    private boolean findPath(TreeNode root, int targetValue, List<Character> path) {
	        if (root == null) {
	            return false;
	        }
	        if (root.val == targetValue) {
	            return true;
	        }
	        
	        path.add('L');
	        if (findPath(root.left, targetValue, path)) {
	            return true;
	        }
	        path.remove(path.size() - 1);
	        
	        path.add('R');
	        if (findPath(root.right, targetValue, path)) {
	            return true;
	        }
	        path.remove(path.size() - 1);
	        
	        return false;
	    }

	    // Main method for testing
	    public static void main(String[] args) {
	    	StepByStepDirectionsFromBinaryTreeNodeToAnother sol = new StepByStepDirectionsFromBinaryTreeNodeToAnother();
	        TreeNode root = new TreeNode(5);
	        root.left = new TreeNode(1);
	        root.right = new TreeNode(2);
	        root.left.left = new TreeNode(3);
	        root.right.left = new TreeNode(6);
	        root.right.right = new TreeNode(4);

	        String result = sol.getDirections(root, 3, 6);
	        System.out.println(result);  // Output: "UURL"
	    }

}
