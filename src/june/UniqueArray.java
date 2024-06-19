package june;

import java.util.Arrays;

public class UniqueArray {
	 public static int minIncrementForUnique(int[] nums) {
	        Arrays.sort(nums);
	        int moves = 0;
	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] <= nums[i - 1]) {
	                int increment = nums[i - 1] - nums[i] + 1;
	                nums[i] += increment;
	                moves += increment;
	            }
	        }
	        return moves;
	    }

	    public static void main(String[] args) {
	        int[] nums1 = {1, 2, 2};
	        int[] nums2 = {3, 2, 1, 2, 1, 7};

	        System.out.println("Example 1 Output: " + minIncrementForUnique(nums1)); // Output: 1
	        System.out.println("Example 2 Output: " + minIncrementForUnique(nums2)); // Output: 6
	    }
}
