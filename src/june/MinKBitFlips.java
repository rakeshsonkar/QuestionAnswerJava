package june;

import java.util.LinkedList;
import java.util.Queue;

public class MinKBitFlips {

	 public int minKBitFlips(int[] nums, int k) {
	        int n = nums.length;
	        int flipCount = 0;
	        int result = 0;
	        Queue<Integer> flipQueue = new LinkedList<>();
	        
	        for (int i = 0; i < n; i++) {
	            // Remove flips that are out of the range of the current window
	            if (!flipQueue.isEmpty() && flipQueue.peek() <= i - k) {
	                flipQueue.poll();
	                flipCount--;
	            }
	            
	            // If the current bit needs to be flipped (depending on flipCount)
	            if ((nums[i] + flipCount) % 2 == 0) {
	                if (i + k > n) { 
	                    return -1;
	                }
	                flipQueue.offer(i);
	                flipCount++;
	                result++;
	            }
	        }
	        
	        return result;
	    }
	 public static void main(String[] args) {
		 MinKBitFlips sol = new MinKBitFlips();
	        
	        int[] nums1 = {0, 1, 0};
	        int k1 = 1;
	        System.out.println(sol.minKBitFlips(nums1, k1)); // Output: 2
	        
	        int[] nums2 = {1, 1, 0};
	        int k2 = 2;
	        System.out.println(sol.minKBitFlips(nums2, k2)); // Output: -1
	        
	        int[] nums3 = {0, 0, 0, 1, 0, 1, 1, 0};
	        int k3 = 3;
	        System.out.println(sol.minKBitFlips(nums3, k3)); // Output: 3
	    }
}
